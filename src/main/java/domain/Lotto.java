package domain;

import java.util.Collections;
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
    
    public void printLotto() {
    	System.out.print("{");
    	for(int i = 0; i < numbers.size(); i++) {
    		System.out.print(numbers.get(i));
    		if(i != numbers.size() - 1) {
    			System.out.print(", ");
    		}
    	}
    	System.out.println("}");
    }
    
    public void setWinningNumbers() {
    	int randInt;
    	while(numbers.size() < 6) {
    		randInt = (Math.abs(r.nextInt()) % 45) + 1;
    		if(!numbers.contains(randInt)) {
    			numbers.add(randInt);
    		}
    	}
    	Collections.sort(numbers);
    }
}
