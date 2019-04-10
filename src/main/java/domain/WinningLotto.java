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
        // TODO 로직 구현
        List<Integer> userNumbers = userLotto.getNumbers();
        int count = 0;
        boolean checkBonusNum;

        for (Integer userNumber : userNumbers) {
            count = countLottoNumber(userNumber, count);
        }
        checkBonusNum = userNumbers.contains(bonusNo);

        return Rank.valueOf(count, checkBonusNum);
    }

    private int countLottoNumber(int number, int countOfMatch) {
        if (lotto.getNumbers().contains(number)) {
            countOfMatch++;
        }
        return countOfMatch;
    }

}
