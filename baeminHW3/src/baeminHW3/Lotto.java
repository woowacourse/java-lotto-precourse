package baeminHW3;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }
    
    public int getMatchCount(Lotto lotto) {
    	int cnt =0;
    	for(int i=0; i<lotto.numbers.size(); i++) {
    		cnt += isEqualNumber(this.numbers.get(i), lotto.numbers.get(i));
    	}
    	return cnt;
    }
    
    public int isEqualNumber(int a, int b) {
    	return a == b ? 1 : 0 ;
    }
}
