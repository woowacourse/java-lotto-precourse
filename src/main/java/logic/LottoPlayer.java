/*
 * LottoPlayer.java
 */
package logic;

import domain.Lotto;
import domain.LottoResult;
import domain.WinningLotto;

import java.util.List;

class LottoPlayer {
	int gameCount;
	List<Lotto> lottoList;
	WinningLotto winningLotto;

	public LottoPlayer() {
		init();
	}

	private void init() {
		gameCount = InputView.getLottoCount();
		lottoList = LottoMaker.getRandomLottoList(gameCount);
		OutputView.printGameCount(gameCount);
		OutputView.printLottoList(lottoList);
	}

	public void proceedLotto() {
		winningLotto = InputView.getWinningLotto();
		LottoResult lottoResult = new LottoResult(lottoList, winningLotto);
		OutputView.printResult(lottoResult);
	}
}
