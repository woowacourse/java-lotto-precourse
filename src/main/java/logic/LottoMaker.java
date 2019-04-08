/*
 * LottoMaker.java
 */
package logic;

import domain.Lotto;
import util.RandomNumberMaker;

import java.util.ArrayList;
import java.util.List;

public class LottoMaker {
	private int lottoMinNumber;
	private int lottoMaxNumber;
	private int lottoSize;

	public LottoMaker(int lottoMinNumber, int lottoMaxNumber, int lottoSize) {
		this.lottoMinNumber = lottoMinNumber;
		this.lottoMaxNumber = lottoMaxNumber;
		this.lottoSize = lottoSize;
	}

	public List<Lotto> getRandomLottoList(int gameCount) {
		List<Lotto> lottoList = new ArrayList<>();
		for (int i = 0; i < gameCount; i++) {
			lottoList.add(makeRandomLotto());
		}
		return lottoList;
	}

	private Lotto makeRandomLotto() {
		return new Lotto(makeRandomIntList());
	}

	private List<Integer> makeRandomIntList() {
		List<Integer> intList = new ArrayList<>();
		for (int i = 0; i < lottoSize; i++) {
			intList.add(RandomNumberMaker.getRandomNumber(lottoMaxNumber, lottoMinNumber));
		}
		return intList;
	}
}
