package domain;

import java.util.ArrayList;

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
        ArrayList<Integer> userList = new ArrayList<Integer> (userLotto.getNumbers());
        ArrayList<Integer> winningList = new ArrayList<Integer>(lotto.getNumbers());
        boolean matchBonus = userList.contains(bonusNo);
        userList.retainAll(winningList);
        return Rank.valueOf(userList.size(), matchBonus);
    }
}
