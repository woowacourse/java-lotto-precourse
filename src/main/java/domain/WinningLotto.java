package domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import static domain.Const.*;

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
        // TODO 로직 구현
        int hitStack;
        boolean hitBonus;

        hitStack = compareLotto(userLotto.getNumbers(), this.lotto.getNumbers());
        hitBonus = compareBonus(userLotto.getNumbers());

        return Rank.valueOf(hitStack, hitBonus);
    }

    private int compareLotto(List<Integer> userLotto, List<Integer> winningLotto) {
        int hitStack = 0;

        hitStack += indexingUserLotto(userLotto, winningLotto);
        return hitStack;
    }

    private int indexingUserLotto(List<Integer> userLotto, List<Integer> winningLotto) {
        int hitStack = 0;

        for (int userIdx = 0; userIdx < LOTTO_NUMBER_SIZE; ++userIdx) {
            hitStack += indexingWinningLotto(userLotto, winningLotto, userIdx);
        }
        return hitStack;
    }

    private int indexingWinningLotto(List<Integer> userLotto, List<Integer> winningLotto, int userIdx) {
        int hitStack = 0;
        for (int winningIdx = 0; winningIdx < LOTTO_NUMBER_SIZE; ++winningIdx) {
            hitStack += isSameNumber(userLotto.get(userIdx), winningLotto.get(winningIdx));
        }
        return hitStack;
    }

    private boolean compareBonus(List<Integer> userLotto) {
        int isSame = 0;

        for (int userIdx = 0; userIdx < LOTTO_NUMBER_SIZE; ++userIdx) {
            isSame += isSameNumber(userLotto.get(userIdx), bonusNo);
        }
        if (isSame == 1) {
            return true;
        }
        return false;
    }

    private int isSameNumber(int user, int winning) {
        if (user == winning) {
            return 1;
        }
        return 0;
    }
}
