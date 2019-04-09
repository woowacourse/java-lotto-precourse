/*
 * @WinningLotto.java     0.1 2019-04-10
 * */

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

    /**
     * 구입한 Lotto와 당첨 번호 및 보너스 볼과 비교
     *
     * @return 일치하는 갯수에 따라 등급 반환
     */
    public Rank match(Lotto userLotto) {
        int countOfMatch = matchWinningNumber(userLotto);
        boolean matchBonus = false;
        if (countOfMatch == 5) {
            matchBonus = userLotto.hasNumber(bonusNo);
        }
        return Rank.valueOf(countOfMatch, matchBonus);
    }

    /**
     * Lotto 번호와 당첨 번호 일치 갯수 반환
     */
    public int matchWinningNumber(Lotto userLotto) {
        int countOfMatch = 0;
        for (int number : lotto.getNumbers()) {
            if (userLotto.hasNumber(number)) {
                countOfMatch++;
            }
        }
        return countOfMatch;
    }
}
