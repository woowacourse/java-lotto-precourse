package domain;

import ui.Output;
import validation.MoneyValidation;

import java.util.List;

/**
 * Game 객체는 로또 게임로직을 관리한다.
 *
 * @author 조남균
 */
public class Game {
	GameUser gameUser;
	WinningLotto winningLotto;
	GameStatistics gameStatistics;

	public Game() {
		this.gameStatistics = new GameStatistics();
	}

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
		return Output.showLotto(gameUser);
	}

	public void setWinningLotto(List<Integer> numbers, int bonusNo) {
		Lotto lotto = new Lotto(numbers);
		winningLotto = new WinningLotto(lotto, bonusNo);
	}

	public String getResult() {
		gameStatistics = new GameStatistics();
		gameStatistics.calRankCount(gameUser, winningLotto);
		return Output.showResult(gameUser, gameStatistics);
	}
}
