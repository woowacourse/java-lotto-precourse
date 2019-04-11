package baeminHW3;

import baeminHW3.mainClass.Rank;
import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }
    
    public int getMatchCount(Lotto userLotto) {
    	int cnt =0;
    	List<Integer> userNumber = userLotto.getNumbers();
    	List<Integer> Winning = this.lotto.getNumbers();
    	for(int i=0; i<userNumber.size(); i++) {
    		boolean check = isEqualNumber(Winning.get(i), userNumber.get(i));
    		if(check) {
    			cnt++;
    		}
    	}
    	return cnt;
    }
    
    public boolean isHaveBonus(Lotto userLotto) {
    	List<Integer> userNumber = userLotto.getNumbers();
       	List<Integer> Winning = this.lotto.getNumbers();
    	for(int i=0; i<userNumber.size(); i++) {
    		boolean bonusCheck = isEqualNumber(Winning.get(i), Integer.valueOf(bonusNo));		
    		boolean check = isEqualNumber(Winning.get(i), userNumber.get(i));
    		if(bonusCheck && !check) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean isEqualNumber(Integer a, Integer b) {
    	return a.intValue() == b.intValue() ? true : false ;
    }
    
    public Rank match(Lotto userLotto) {
    	int countOfMatch = getMatchCount(userLotto);
    	boolean matchBonus = isHaveBonus(userLotto);
    	Rank r = Rank.valueOf(countOfMatch, matchBonus);
        return r;
    }
}
