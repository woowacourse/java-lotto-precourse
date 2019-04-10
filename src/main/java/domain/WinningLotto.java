package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        int countOfMatch = 0;
        List<Integer> winLottoList = this.lotto.getNumbers();
        for(int i=0;i<Lotto.oneLottoAmount;i++) {
            countOfMatch += userLotto.IsIncludeWinNumber(winLottoList.get(i));
        }
        boolean matchBonus = userLotto.IsIncludeBonusNumber(this.bonusNo);
        System.out.println(countOfMatch + ", " + matchBonus);
        Rank rank = Rank.valueOf(countOfMatch, matchBonus);
        return rank;
    }
}
