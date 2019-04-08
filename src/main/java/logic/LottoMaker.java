/*
 * LottoMaker.java
 */
package logic;

import domain.Lotto;
import util.RandomNumberMaker;

import java.util.ArrayList;
import java.util.List;

import static domain.LottoConstant.*;

public class LottoMaker {

	public static List<Lotto> getRandomLottoList(int gameCount) {
		List<Lotto> lottoList = new ArrayList<>();
		for (int i = 0; i < gameCount; i++) {
			lottoList.add(makeRandomLotto());
		}
		return lottoList;
	}

	private static Lotto makeRandomLotto() {
		return new Lotto(makeRandomIntList());
	}

	private static List<Integer> makeRandomIntList() {
		List<Integer> intList = new ArrayList<>();
		for (int i = 0; i < LOTTO_SIZE; i++) {
			intList.add(RandomNumberMaker.getRandomNumber(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER));
		}
		return intList;
	}
}
