/*
 * Main.java
 */

package logic;

import domain.Lotto;
import domain.LottoResult;
import domain.WinningLotto;

import java.util.List;

import static domain.LottoConstant.*;


public class Main {
	public static void main(String[] args) {
		InputView input = new InputView();
		int gameCount = input.getLottoCount();
		System.out.println(gameCount + "개를 구매했습니다.");
		LottoMaker lottoMaker = new LottoMaker(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
		List<Lotto> lottoList = lottoMaker.getRandomLottoList(gameCount);
		OutputView.printLottoList(lottoList);
		WinningLotto winningLotto = input.getWinningLotto();
		LottoResult lottoResult = new LottoResult(lottoList, winningLotto);
		OutputView.printResult(lottoResult);
	}
}
