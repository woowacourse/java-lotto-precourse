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

    /*
     * 구매한 로또와 당첨 로또와의 매칭 정도 판단
     */
    public Rank match(Lotto userLotto) {
        int matchCount = countMatchNum(userLotto);
        boolean matchBonus = matchBonusNum(userLotto);

        return valueOf(matchCount, matchBonus);
    }
}
