package domain;

import domain.util.Constant;
import domain.util.Input;

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


    public static WinningLotto createWinningLotto() {
        Lotto fiveNumberlLotto = new Lotto(Input.inputWiningNum());
        int bonumsNum = fiveNumberlLotto.getBonusNumber(fiveNumberlLotto);
        return new WinningLotto(fiveNumberlLotto, bonumsNum);
    }


    public Rank match(Lotto userLotto) {
        // TODO 로직 구현
        return null;
    }
}
