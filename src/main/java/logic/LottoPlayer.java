/*
 * LottoPlayer.java
 */

package logic;

import domain.Lotto;
import domain.LottoResult;
import domain.WinningLotto;

import java.util.List;

class LottoPlayer {
	private int gameCount;
	private List<Lotto> lottoList;

	public LottoPlayer() {
		init();
	}

	private void init() {
		gameCount = InputView.getLottoCount();
		lottoList = LottoMaker.getRandomLottoList(gameCount);
	}

	public void proceedLottoGame() {
		OutputView.printGameCount(gameCount);
		OutputView.printLottoList(lottoList);
		WinningLotto winningLotto = InputView.getWinningLotto();
		LottoResult lottoResult = new LottoResult(lottoList, winningLotto);
		OutputView.printResult(lottoResult);
	}
}
