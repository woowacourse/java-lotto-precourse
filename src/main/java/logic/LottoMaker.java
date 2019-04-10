/*
 * LottoMaker.java
 */

package logic;

import domain.Lotto;
import util.DuplicateValidator;
import util.RandomNumberMaker;

import java.util.ArrayList;
import java.util.List;

import static domain.LottoConstant.*;

public class LottoMaker {
	private static final DuplicateValidator DUPLICATE_VALIDATOR = new DuplicateValidator();

	public static List<Lotto> getRandomLottoList(int gameCount) {
		List<Lotto> lottoList = new ArrayList<>();
		for (int i = 0; i < gameCount; i++) {
			lottoList.add(makeLotto());
		}
		return lottoList;
	}

	private static Lotto makeLotto() {
		List<Integer> intList;
		do {
			intList = makeRandomIntList();
		} while (DUPLICATE_VALIDATOR.isDuplicate(intList));
		return new Lotto(intList);
	}

	private static List<Integer> makeRandomIntList() {
		List<Integer> intList = new ArrayList<>();
		for (int i = 0; i < LOTTO_SIZE; i++) {
			intList.add(RandomNumberMaker.getRandomNumber(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER));
		}
		return intList;
	}
}
