/**
 * 우아한테크코스 프리코스 3주차 미션
 * 로또 게임
 *
 * @author JiHoon Kim
 * @version 1.0
 */

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
        int countOfMatch = 0;

        for (int userNum : userLotto.getNumbersList())          /* 입력 받은 로또의 번호마다 당첨번호에 포함되는지 확인 */
            if (lotto.contains(userNum))
                countOfMatch++;

        return Rank.valueOf(countOfMatch, compareBonus(userLotto));
    }

    private boolean compareBonus(Lotto userLotto) {
        return userLotto.contains(bonusNo);
    }
}
