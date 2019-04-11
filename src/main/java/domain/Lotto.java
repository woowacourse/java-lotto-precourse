package domain;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;
    private final int LAST_INDEX = 5;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public String toString() {   	
    	String result = "[";
    	
    	for (int i = 0; i < this.numbers.size() - 1; i++) {
    		result += this.numbers.get(i) + ", ";
    	}
    	
    	result += this.numbers.get(LAST_INDEX) + "]";
    	
    	return result;
    }
    
    public List<Integer> getNumbers() {
    	return this.numbers;
    }
    
}
