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
        List<Integer> lottoNum = lotto.getNumbers();
        List<Integer> userNum = userLotto.getNumbers();

        boolean matchBonus = userNum.contains(bonusNo);
        userNum.retainAll(lottoNum);
        int countOfMatch = userNum.size();

        return Rank.valueOf(countOfMatch, matchBonus);
    }
}
