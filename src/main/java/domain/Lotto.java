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
    
    public void createLottoNumber() {
    	
    	int [] visit = new int[46];
    	int lottoNumber;
    	int loopCount = 0;
    	
    	while (loopCount < 6) {
    		
    		lottoNumber = (int) (Math.random()*100) % 46;
    		
			if(lottoNumber == 0 || visit[lottoNumber] == 1)
				continue;
			
			loopCount++;
			visit[lottoNumber] = 1;
			this.numbers.add(lottoNumber);
		}
    }

    
}
