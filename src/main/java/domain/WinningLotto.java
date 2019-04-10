/*
 * 이 클래스는 당첨 번호를 담당하는 객체입니다.
 *
 * 클래스 이름    WinningLotto
 * 버전 정보     1.0
 * 날짜    2019/04/11
 * 저작권   권유상
 */

package domain;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        int matchCount = 0;
        List<Integer> userLottoList = userLotto.getLottoList();
        for (int number : lotto.getLottoList()) {
            matchCount += (userLottoList.contains(number)) ? 1 : 0;
        }
        return Rank.valueOf(matchCount, userLottoList.contains(bonusNo));
    }
}
