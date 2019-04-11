package domain;

import java.util.List;
import java.util.stream.Collectors;

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
        List<Integer> matchNumbers;
        boolean matchBonus = userLotto.contains(bonusNo);

        matchNumbers = userLotto.getNumbers()
                .stream()
                .filter(this.lotto::contains)
                .collect(Collectors.toList());

        return Rank.valueOf(matchNumbers.size(), matchBonus);
    }
}
