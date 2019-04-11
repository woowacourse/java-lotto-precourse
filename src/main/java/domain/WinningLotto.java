package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 당첨 번호를 담당하는 객체
 * 구매한 로또들과 당첨 로또를 비교
 * 각각의 당첨 결과를 return 해준다.
 */
public class WinningLotto {

    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public List<Rank> checkHowManyMatch(List<Lotto> userLotto) {
        List<Lotto> userLottoList = userLotto;
        List<Rank> userLottoRankList = new ArrayList<>();

        Iterator<Lotto> iter = userLottoList.iterator();
        while (iter.hasNext()) {
            userLottoRankList.add(match(iter.next()));
        }
        return userLottoRankList;
    }

    public Rank match(Lotto userLotto) {
        int countOfMatch;
        boolean isMatchBonusNo;

        countOfMatch = countMatchLottoNumber(userLotto);
        isMatchBonusNo = isMatchBonusNumber(userLotto);

        return Rank.valueOf(countOfMatch, isMatchBonusNo);
    }

    private int countMatchLottoNumber(Lotto userLotto) {
        List<Integer> copyUserLotto = new ArrayList<>(userLotto.getNumbers());
        List<Integer> copyWinningLotto = new ArrayList<>(lotto.getNumbers());

        copyUserLotto.retainAll(copyWinningLotto);
        return copyUserLotto.size();
    }

    private boolean isMatchBonusNumber(Lotto userLotto) {
        return userLotto.getNumbers().contains(bonusNo);
    }
}
