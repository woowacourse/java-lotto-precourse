package domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private static final int MAX_NUMBER_COUNT = 12;         // userLotto와 winningLotto에 적힌 숫자 개수의 최대 값(하나도 일치하지 않을 때 12개)

    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        Set<Integer> numberPool = new HashSet<>(lotto.getNumbers());
        int numberPoolSize;

        numberPool.addAll(userLotto.getNumbers());
        numberPoolSize = numberPool.size();
        numberPool.add(bonusNo);

        return Rank.valueOf(MAX_NUMBER_COUNT - numberPoolSize,
                numberPoolSize == numberPool.size());
    }
}
