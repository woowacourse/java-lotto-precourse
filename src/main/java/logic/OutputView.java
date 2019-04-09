/*
 * OutputView.java
 */
package logic;

import domain.Lotto;
import domain.LottoResult;
import domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {

	public static void printGameCount(int gameCount) {
		System.out.println(gameCount + "개를 구매했습니다.");
	}

	public static void printLottoList(List<Lotto> lottoList) {
		for (Lotto lotto : lottoList) {
			System.out.println(lotto);
		}
	}

	public static void printResult(LottoResult lottoResult) {
		printLottoStatResult(lottoResult);
		printProfitRate(lottoResult);
	}

	private static void printLottoStatResult(LottoResult lottoResult) {
		System.out.println("당첨 통계");
		System.out.println("---------");
		Map<Rank, Integer> map = lottoResult.getMap();
		for (Rank rank : Rank.reverseValues()) {
			printLottoRank(rank, map.get(rank));
		}
	}

	private static void printLottoRank(Rank rank, Integer value) {
		if (!(rank == Rank.MISS)) {
			System.out.println(rank.toString() + " - " + value + "개");
		}
	}

	public static void printProfitRate(LottoResult lottoResult) {
		System.out.print("총 수익률은 ");
		System.out.printf("%.3f입니다.", lottoResult.getProfitRate());
	}
}
