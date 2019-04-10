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
		 List<Integer> matchLottoList = new ArrayList<Integer>();
		 boolean hasBonus = false;
		 matchLottoList.addAll(userLotto.getNumbers());
		 if(matchLottoList.contains(bonusNo)) hasBonus = true;
		 int oldSize = matchLottoList.size();
		 for(int number : lotto.getNumbers()) {
			 if(!matchLottoList.contains(number)) matchLottoList.add(number);
		 }
		 int score = LottoRule.LottoLENGTH.getNum() - (matchLottoList.size() - oldSize);
		 return Rank.valueOf(score, hasBonus);
    }
}
