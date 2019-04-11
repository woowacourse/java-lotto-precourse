package domain;

import java.util.List;
import java.util.Random;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;
    Random r = new Random();
    
    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }
    
    

    // 추가 기능 구현
    
    public void setWinningNumbers() {
    	int randInt;
    	while(numbers.size() < 6) {
    		randInt = (Math.abs(r.nextInt()) % 65) + 1;
    		if(!numbers.contains(randInt)) {
    			numbers.add(randInt);
    		}
    	}
    }
}
