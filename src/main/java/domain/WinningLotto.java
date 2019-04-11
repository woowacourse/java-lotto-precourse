package domain;

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
        int count = 0;

        for (int userNumber : userLotto.getNumbers()) {
            count = countOfMatchNumber(userNumber, count);
        }

        return Rank.valueOf(count, userLotto.getNumbers().contains(bonusNo));
    }

    private int countOfMatchNumber(int number, int count) {
        if (lotto.getNumbers().contains(number)) {
            return ++count;
        }
        return count;
    }
}
