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

    private int checkMatchLottoNumber(int number) {
        if (lotto.getNumbers().contains(number)) {
            return 1;
        }

        if (bonusNo == number) {
            return 1;
        }

        return 0;
    }
}
