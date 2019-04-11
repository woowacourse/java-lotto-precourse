package domain;

import java.util.List;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private final int LOTTOS_NUMBER_EXCEPTBOUNS = 6; //당첨번호를 제외한 숫자
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        int countOfMatch;

        countOfMatch = compareLists(userLotto.getNumbersList(), lotto.getNumbersList());
        return Rank.valueOf(countOfMatch, checkBouns(userLotto.getBonusNumber()));
    }

    public int compareLists(List<Integer> userNumber, List<Integer> lastNumber) {
        int countOfMatch = 0;

        for (int i = 0; i < LOTTOS_NUMBER_EXCEPTBOUNS; i++) {
            int temp = userNumber.get(i);
            countOfMatch += lastNumber.stream().filter(num -> (num == temp)).count();
        }
        return countOfMatch;
    }

    public boolean checkBouns(int userBonus) {
        return userBonus == bonusNo;
    }
}
