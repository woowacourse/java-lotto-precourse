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
        int countOfMatch = matchAnswers(userLotto);
        boolean matchBonus = userLotto.contains(bonusNo);
        return Rank.valueOf(countOfMatch, matchBonus);
    }

    private int matchAnswers(Lotto userLotto) {
        List<Integer> userNumbers = userLotto.getNumbers();
        return userNumbers.stream().filter(lotto::contains).toArray().length;
    }
}
