package ui;

import domain.GameStatistics;
import domain.GameUser;
import domain.Rank;

/**
 * Output 객체는 게임로직으로부터 나온 결과를 사용자에게 출력한다.
 *
 * @author 조남균
 */
public class Output {
	public static String showLotto(GameUser gameUser) {
		StringBuilder sb = new StringBuilder();
		int countOfLotto = gameUser.countOfLotto();

		sb.append("\n").append(String.format("%d개를 구매했습니다.\n", countOfLotto));
		for (int i = 0; i < countOfLotto; i++) {
			sb.append(gameUser.getLotto(i).toString()).append("\n");
		}

		return sb.toString();
	}

	public static String showResult(GameUser gameUser, GameStatistics gameStatistics) {
		StringBuilder sb = new StringBuilder();
		String matchResult = showMatchResult(gameStatistics);
		String matchYield = String.format("총 수익률은 %.3f 입니다.", gameStatistics.getYield(gameUser));

		sb.append("\n당첨 통계").append("\n")
				.append("---------").append("\n")
				.append(matchResult)
				.append(matchYield)
				.append("\n");

		return sb.toString();
	}

	private static String showMatchResult(GameStatistics gameStatistics) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("%d개 일치(%d원)-%d개\n",
				Rank.FIFTH.getCountOfMatch(), Rank.FIFTH.getWinningMoney(), gameStatistics.countOfWinningNumber(Rank.FIRST)));
		sb.append(String.format("%d개 일치(%d원)-%d개\n",
				Rank.FOURTH.getCountOfMatch(), Rank.FOURTH.getWinningMoney(), gameStatistics.countOfWinningNumber(Rank.FOURTH)));
		sb.append(String.format("%d개 일치(%d원)-%d개\n",
				Rank.THIRD.getCountOfMatch(), Rank.THIRD.getWinningMoney(), gameStatistics.countOfWinningNumber(Rank.THIRD)));
		sb.append(String.format("%d개 일치, 보너스 볼 일치(%d원)-%d개\n",
				Rank.SECOND.getCountOfMatch(), Rank.SECOND.getWinningMoney(), gameStatistics.countOfWinningNumber(Rank.SECOND)));
		sb.append(String.format("%d개 일치(%d원)-%d개\n",
				Rank.FIRST.getCountOfMatch(), Rank.FIRST.getWinningMoney(), gameStatistics.countOfWinningNumber(Rank.FIRST)));

		return sb.toString();
	}
}
