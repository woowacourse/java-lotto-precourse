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
        int counter = 0;
        List<Integer> userNumbers = userLotto.getNumbers();
        for (int num : lotto.getNumbers()) {
            counter = (userNumbers.contains(num)) ? counter + 1 : counter;
        }
        return Rank.valueOf(counter, isMatchBonus(userNumbers));
    }

    private boolean isMatchBonus(List<Integer> list) {
        return list.contains(bonusNo);
    }
}
