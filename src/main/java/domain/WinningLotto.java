package domain;

import java.util.HashSet;

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
        final int NUMBER_A_PLUS_B = App.LOTTO_NUMBER_OF_PICKS * 2;

        /*
        n(A ∩ B) = n(A) + n(B) - n(A ∪ B), A, B는 집합, n()은 집합의 원소의 개수
         */
        return Rank.valueOf(
            NUMBER_A_PLUS_B - lotto.unionSet(userLotto).size(),
            userLotto.contains(bonusNo)
        );
    }
}