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
		winningLotto = InputView.getWinningLotto();
	}

	public void proceedLotto() {
		OutputView.printLottoList(lottoList);
		LottoResult lottoResult = new LottoResult(lottoList, winningLotto);
		OutputView.printResult(lottoResult);
	}
}
