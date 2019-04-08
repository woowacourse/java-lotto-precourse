/*
 * OutputView.java
 */
package logic;

import domain.Lotto;

import java.util.List;

public class OutputView {

	public static void printLottoList(List<Lotto> lottoList) {
		for (Lotto lotto : lottoList) {
			System.out.println(lotto);
		}
	}
}
