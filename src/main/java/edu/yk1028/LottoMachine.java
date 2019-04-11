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
import java.util.Collections;
import java.util.List;
import java.util.Random;

import edu.yk1028.Exception.MoneyLackException;

/**
 * 사용자에게 로또를 발급하는 객체
 * 
 * @author wongeunsong
 *
 */
public class LottoMachine {
	private Random random = new Random();
	private List<Integer> baseNumbers = new ArrayList<Integer>();
	
	public LottoMachine() {
		for	(int i = LottoConstant.MINIMUM_RANGE_OF_LOTTO_NUMBER; i <= LottoConstant.MAXIMUM_RANGE_OF_LOTTO_NUMBER; i++) {
			baseNumbers.add(i);
		}
	}

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
		
		for	(int i = LottoConstant.MINIMUM_RANGE_OF_LOTTO_NUMBER; i <= LottoConstant.NUMBER_OF_LOTTO_NUMBERS; i++) {
			int randomIndex = random.nextInt(LottoConstant.SIZE_OF_RANGE - i) 
								+ LottoConstant.MINIMUM_RANGE_OF_LOTTO_NUMBER;
			numberList.add(baseNumbers.get(randomIndex));
			Collections.swap(baseNumbers, randomIndex, LottoConstant.MAXIMUM_RANGE_OF_LOTTO_NUMBER - i);
		}
		return numberList;
	}
}
