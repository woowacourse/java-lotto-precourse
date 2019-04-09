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
        int countOfMatch = countMatch(userLotto);

        // TODO 로직 구현
        return Rank.valueOf(countOfMatch, userLotto.hasNumber(bonusNo));
    }

    private int countMatch(Lotto userLotto) {
        HashSet<Integer> set = new HashSet<>(userLotto.returnNumbers());
        set.addAll(lotto.returnNumbers());

        return userLotto.returnNumbers().size() + lotto.returnNumbers().size() - set.size();
    }

    @Override
    public String toString() {
        return lotto.toString() + bonusNo;
    }
}
