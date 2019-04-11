package baeminHW3;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }
    
    public List<Integer> getNumbers(){
    	return this.numbers;
    }
       
    public void printNumber() {
    	System.out.print('[');
    	for(int i=0; i<this.numbers.size(); i++) {
    		System.out.print(this.numbers.get(i) + ", ");
    	}
    	System.out.println("]");
    }
}