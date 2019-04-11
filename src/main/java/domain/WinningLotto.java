package domain;

import domain.util.Input;

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

    public static WinningLotto createWinningLotto() {
        Lotto lotto = new Lotto(Input.inputWiningNum());
        int bonumsNum = lotto.getBonusNumber(lotto);
        return new WinningLotto(lotto, bonumsNum);
    }

    /**
     * 두 로또를 비교해 등수를 반환
     * @param userLotto
     * @return 비교완료한 rank값
     */
    public Rank match(Lotto userLotto) {
        int countMatch = userLotto.countMatchNumber(this.lotto);
        boolean bonusMatch = userLotto.hasBonusNumber(this.bonusNo);
        return Rank.valueOf(countMatch, bonusMatch);
    }
}
