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

	public String getLotto() {
		StringBuilder sb = new StringBuilder();
		int countOfLotto = gameUser.countOfLottos();

		sb.append(String.format("%d개를 구매했습니다.\n", countOfLotto));
		for (int i = 0; i < countOfLotto; i++) {
			sb.append(gameUser.getLotto(i).toString()).append("\n");
		}

		return sb.toString();
	}
}
