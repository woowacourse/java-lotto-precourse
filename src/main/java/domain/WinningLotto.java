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
        return null;
    }

    public int matchWinningNumber(Lotto userLotto) {
        int countOfMatch = 0;
        for (int number: lotto.getNumbers()) {
            if (userLotto.hasNumber(number)) {
                countOfMatch ++;
            }
        }
        return countOfMatch;
    }

}
