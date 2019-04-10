package domain;

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
    	List<Integer> userLottoNum = userLotto.getNumbers();
    	int countOfMatch = 0;
    	boolean matchOfBonus = false;
    	for(int i=0; i<LottoGame.LOTTO_NUM_LENGTH; ++i) {
    		countOfMatch += getCountOfMatch(userLottoNum.get(i));
    		matchOfBonus |= (bonusNo ==userLottoNum.get(i));
    	}
    	return Rank.valueOf(countOfMatch, matchOfBonus);
    }
    
    public int getCountOfMatch(int userLottoNum) {
    	boolean isMatched = false;
    	for(int i=0; i<LottoGame.LOTTO_NUM_LENGTH; ++i) {
    		isMatched |= (userLottoNum == this.lotto.getNumbers().get(i));
    	}
    	if(isMatched) {
    		return 1;
    	}
    	return 0;
    }
}
