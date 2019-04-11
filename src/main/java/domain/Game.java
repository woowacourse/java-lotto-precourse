package domain;

import validation.MoneyValidation;

import java.util.List;
import java.util.Map;

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

	public void setWinningLotto(List<Integer> numbers, int bonusNo) {
		Lotto lotto = new Lotto(numbers);
		winningLotto = new WinningLotto(lotto, bonusNo);
	}

	public String getResult() {
		StringBuilder sb = new StringBuilder();
		Map<Rank, Integer> rankCount = calRankCount(initRankCount());

		sb.append("당첨 통계").append("\n")
				.append("---------").append("\n")
				.append(getMatchResult(rankCount))
				.append(String.format("총 수익률은 %.3f 입니다.", getYeild(rankCount)))
				.append("\n");

		return sb.toString();
	}

	private Map<Rank, Integer> initRankCount() {
		return null;
	}

	private Map<Rank, Integer> calRankCount(Map<Rank, Integer> rankCount) {
		return null;
	}

	private String getMatchResult(Map<Rank, Integer> rankCount) {
		return null;
	}

	private double getYeild(Map<Rank, Integer> rankCount) {
		return 0.0;
	}
}
