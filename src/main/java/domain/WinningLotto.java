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
        int countOfMatch;
        boolean isMatchBonusNo;

        countOfMatch = checkSameLottoNumber(userLotto);
        isMatchBonusNo = checkMatchBonusNumber(userLotto);

        return Rank.valueOf(countOfMatch, isMatchBonusNo);
    }

    private int checkSameLottoNumber(Lotto userLotto){
        List<Integer> copyUserLotto = new ArrayList<>(userLotto.getNumbers());
        List<Integer> copyWinningLotto = new ArrayList<>(lotto.getNumbers());

        copyUserLotto.retainAll(copyWinningLotto);
        return copyUserLotto.size();
    }

    private boolean checkMatchBonusNumber(Lotto userLotto){
        return userLotto.getNumbers().contains(bonusNo);
    }
}
