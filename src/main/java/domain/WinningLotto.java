package domain;

import java.util.ArrayList;
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

    public Rank match(Lotto userLotto) {
        List<Integer> userNumbers = new ArrayList<>();
        userNumbers.addAll(userLotto.getNumbers());

        userNumbers.retainAll(lotto.getNumbers());
        int matchCount = userNumbers.size();

        boolean matchBonus = userLotto.getNumbers().contains(bonusNo);

        return Rank.valueOf(matchCount, matchBonus);
    }

}
