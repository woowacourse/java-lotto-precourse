package domain;

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
    
    public String toString() {
    	String result = "";	
    	result = this.lotto.toString() + " bonus : " + bonusNo;
    	
    	return result;
    }

    public Rank match(Lotto userLotto) {
    	int countOfMath = 0;

    	for (int i = 0; i < userLotto.getNumbers().size(); i++) {
    		countOfMath += this.lotto.getNumbers().contains(userLotto.getNumbers().get(i)) ? 1 : 0;
    	}
    	
        return Rank.valueOf(countOfMath, userLotto.getNumbers().contains(this.bonusNo));
    }
}
