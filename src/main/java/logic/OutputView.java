/*
 * OutputView.java
 */
package logic;

import domain.Lotto;
import domain.LottoResult;

import java.util.List;

public class OutputView {

	public static void printLottoList(List<Lotto> lottoList) {
		for (Lotto lotto : lottoList) {
			System.out.println(lotto);
		}
	}

	public static void printResult(LottoResult lottoResult) {
		printLottoStatResult(lottoResult);
		printProfitRate(lottoResult);
	}

	public static void printLottoStatResult(LottoResult lottoResult) {
		System.out.println("당첨 통계");
		System.out.println("---------");
		lottoResult.printStatResult();
	}

	public static void printProfitRate(LottoResult lottoResult) {
		System.out.print("총 수익률은 ");
		System.out.printf("%.3f입니다.", lottoResult.getProfitRate());
	}
}
