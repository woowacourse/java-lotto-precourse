/*
 * Main.java
 */

package logic;

import domain.Lotto;
import util.RandomNumberMaker;

import java.util.List;

public class Main {
	private static final int LOTTO_SIZE = 6;
	private static final int LOTTO_MIN_NUMBER = 1;
	private static final int LOTTO_MAX_NUMBER = 45;
	private static final RandomNumberMaker RANDOM_NUMBER_MAKER
			= new RandomNumberMaker(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER);

	public static void main(String[] args) {
		InputView input = new InputView();
		int gameCount = input.getLottoCount();
		System.out.println(gameCount + "개를 구매했습니다.");
		LottoMaker lottoMaker = new LottoMaker(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
		List<Lotto> lottoList = lottoMaker.getRandomLottoList(gameCount);
		printLottoList(lottoList);
		//input.getWinningLotto());
	}

	private static void printLottoList(List<Lotto> lottoList) {
		for (Lotto lotto : lottoList) {
			System.out.println(lotto);
		}
	}

}
