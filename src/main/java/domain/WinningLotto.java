package domain;

import java.util.List;

import static domain.Rank.valueOf;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private static final int EXIST = 1;
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
}
