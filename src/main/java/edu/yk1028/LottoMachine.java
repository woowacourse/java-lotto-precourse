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

import edu.yk1028.Exception.MoneyLackException;

/**
 * 사용자에게 로또를 발급하는 객체
 * 
 * @author wongeunsong
 *
 */
public class LottoMachine {
	private Random random = new Random();
	
	public List<Lotto> cellLottos(long money) throws Exception {
		if (money < LottoConstant.MIN_MONEY) {
			throw new MoneyLackException();
		}
		return generateLottos(maximumNumberOfLotto(money));
	}

	private long maximumNumberOfLotto(long money) {
		return money / LottoConstant.LOTTO_PRICE;
	}

	private List<Lotto> generateLottos(long count) {
		List<Lotto> lottoList = new ArrayList<Lotto>();

		for (long i = 0; i < count; i++) {
			lottoList.add(new Lotto(generateLottoNumbers()));
		}
		return lottoList;
	}

	private List<Integer> generateLottoNumbers() {
		List<Integer> numberList = new ArrayList<Integer>();
		Set<Integer> numberSet = new HashSet<Integer>();

		while (numberSet.size() != LottoConstant.NUMBER_OF_LOTTO_NUMBERS) {
			numberSet.add(makeRandomLottoNumber());
		}
		numberList.addAll(numberSet);
		return numberList;
	}

	private int makeRandomLottoNumber() {
		return random.nextInt((LottoConstant.SIZE_OF_RANGE)) + LottoConstant.MINIMUM_RANGE_OF_LOTTO_NUMBER;
	}
}
