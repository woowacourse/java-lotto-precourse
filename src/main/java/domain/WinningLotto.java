package domain;

import java.util.List;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        List<Integer> winningNumbers = this.lotto.getNumbers();
        List<Integer> userLottoNumbers = userLotto.getNumbers();

        int matchCount = (int) winningNumbers.stream().filter(n -> userLottoNumbers.contains(n)).count();
        boolean matchBonus = userLottoNumbers.contains(this.bonusNo);

        Rank userRank = Rank.valueOf(matchCount, matchBonus);
        return userRank;
    }
}
