package service;

import domain.Money;
import domain.WinningLotto;

/**
 * @version 1.00 2019/04/10
 * @author 조재훈
 */
public class Dealer {

	private void start() {
		InputPurchasingMoney inputPurchasingMoney = new InputPurchasingMoney();
		Money money = inputPurchasingMoney.getMoney();
		LottoGenerator lottoGenerator = new LottoGenerator(money.getLottoCount());
		InputWinningNumber inputWinningNumber = new InputWinningNumber();
		WinningLotto winningLotto = inputWinningNumber.getWinner();
		RankCounter ranker = new RankCounter(winningLotto, lottoGenerator);
		ranker.calResult();
	}

	public static void main(String[] args) {
		new Dealer().start();
	}
}
