package domain;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }
    
    // 추가 기능 구현
    
    public String toString() {   	
    	String result = "[";
    	
    	for (int i = 0; i < this.numbers.size() - 1; i++) {
    		result += this.numbers.get(i) + ", ";
    	}
    	
    	result += this.numbers.get(5) + "]";
    	
    	return result;
    }
    
    public List<Integer> getNumbers() {
    	return this.numbers;
    }
    
}
