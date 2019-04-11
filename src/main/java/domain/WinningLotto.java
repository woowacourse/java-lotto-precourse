/*
 * WinningLotto
 *
 * version 1.1
 *
 * 2019/04/10
 */

package domain;

/**
 * 당첨 번호를 담당하는 객체
 *
 * @author 우아한 테크코스, 김성훈
 * @version 1.0 2019/04/10
 *          1.1 2019/04/11  당첨번호와 사용자의 로또 번호를 비교하는 메소드(match) 구현
 */
public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        return Rank.valueOf(userLotto.calcCountOfMatch(lotto), userLotto.contains(bonusNo));
    }
}
