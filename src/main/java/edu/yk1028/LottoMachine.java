/*
 * LottoMachine
 * 
 * version 1.0
 * 
 * 2019. 4. 6
 * 
 * Created by Wongeun Song
 */

package edu.yk1028;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * 사용자에게 로또를 발급하는 객체
 * 
 * @author wongeunsong
 *
 */
public class LottoMachine {
	private final int MIN_MONEY = 1000;
	private final int LOTTO_PRICE = 1000;
	private final int NUMBER_OF_LOTTO_NUMBERS = 6;
	private final int BOUND_OF_LOTTO_NUMBER = 45;
	private final String REQUEST_MONEY_OVER_MINIMUM = String.format("최소 구입 금액은 %d원입니다.", MIN_MONEY);
	
	public List<Lotto> cellLottos(int money) throws Exception {
		if (money < MIN_MONEY) {
			System.out.println(REQUEST_MONEY_OVER_MINIMUM);
			throw new Exception();
		}
		return generateLottos(maximumNumberOfLotto(money));
	}

	private int maximumNumberOfLotto(int money) {
		return money / LOTTO_PRICE;
	}

	private List<Lotto> generateLottos(int count) {
		List<Lotto> lottoList = new ArrayList<Lotto>();

		for (int i = 0; i < count; i++) {
			lottoList.add(new Lotto(generateLottoNumbers()));
		}
		return lottoList;
	}

	private List<Integer> generateLottoNumbers() {
		List<Integer> numberList = new ArrayList<Integer>();
		Set<Integer> numberSet = new HashSet<Integer>();
		Random random = new Random();

		for (; numberSet.size() < NUMBER_OF_LOTTO_NUMBERS;
					numberSet.add(random.nextInt(BOUND_OF_LOTTO_NUMBER) + 1));
		numberList.addAll(numberSet);
		return numberList;
	}
}
