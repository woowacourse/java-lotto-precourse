package domain;

import validation.MoneyValidation;

public class Game {
	GameUser gameUser;
	WinningLotto winningLotto;

	public void setMoney(int money) {
		this.gameUser = new GameUser(money);
		int countOfLotto = money / MoneyValidation.MONEY_UNIT;

		for (int i = 0; i < countOfLotto; i++) {
			LottoCombinator lottoCombinator = new LottoCombinator();
			Lotto lotto = lottoCombinator.getLotto();

			this.gameUser.addLotto(lotto);
		}
	}
}
