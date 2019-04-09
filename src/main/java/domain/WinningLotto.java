package domain;

import java.util.List;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {

    public static final int MATCH = 1;

    public static final int NOT_MATCH = 0;

    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        List<Integer> winningLottoNumber = lotto.getNumbers();
        List<Integer> userLottoNumber = userLotto.getNumbers();
        int countOfMatch = NOT_MATCH;
        for (Integer userNumber : userLottoNumber) {
            countOfMatch += matchNumber(userNumber, winningLottoNumber);
        }
        boolean matchBonus = userLottoNumber.contains(bonusNo);
        return Rank.valueOf(countOfMatch, matchBonus);
    }

    private int matchNumber(Integer userNumber, List<Integer> winningLottoNumber) {
        return (winningLottoNumber.contains(userNumber)) ? MATCH : NOT_MATCH;
    }
}
