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
    
    public void printNumbers() {
		System.out.println(numbers.toString());
	}

	public boolean contains(int value) {
		boolean res = numbers.contains(value);
		return res;
	}

	public int getCountOfMatch(Lotto lotto) {
		final int LOTTO_MIN = 1;
		final int LOTTO_MAX = 45;
		
		int res =0;
		
		for (int i = LOTTO_MIN; i <= LOTTO_MAX; i++) {
			res += coHas(lotto,i);
		}
		return res;
	}

	private int coHas(Lotto lotto, int i) {
		int res = 0;
		
		if (lotto.contains(i) && contains(i)) {
			res = 1;
		}
		return res;
	}

}
