package domain;

import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public static Lotto create() {
		HashSet hs = new HashSet();
		while (hs.size() < 6) {
			hs.add(makeRandomNum());
		}
		List lottoList = new ArrayList();
		lottoList.addAll(hs);
		
		Collections.sort(lottoList);
		return new Lotto(lottoList);
	}

	private static int makeRandomNum() {
		Random random = new Random();
		return random.nextInt(45) + 1;
	}

	public void getNumbers() {
		System.out.println(numbers.toString());
	}
}
