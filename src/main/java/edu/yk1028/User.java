/*
 * User
 * 
 * version 1.0
 * 
 * 2019. 4. 6
 * 
 * Created by Wongeun Song
 */

package edu.yk1028;

import java.util.List;
import java.util.Scanner;

/**
 * 로또를 구매하는 사용자 객체
 * 
 * @author wongeunsong
 *
 */
public class User {
	private final String REQUEST_MONEY = "구입 금액을 입력해 주세요.";
	private final String WRONG_INPUT = "잘못된 입력입니다.";
	private final String PURCHASE_FAILED = "로또 구매에 실패했습니다.";
	private final String PURCHASE_LOTTO_TAIL_MESSAGE = "개를 구매했습니다.";

	private List<Lotto> lottos;

	public void buyLottos(LottoMachine lottoMachine) {
		try {
			int money = insertMoney();
			this.lottos = lottoMachine.cellLottos(money);
			System.out.println(lottos.size() + PURCHASE_LOTTO_TAIL_MESSAGE);
		} catch (Exception e) {
			System.out.println(PURCHASE_FAILED);
		}
	}

	private int insertMoney() {
		Scanner scanner = new Scanner(System.in);

		System.out.println(REQUEST_MONEY);
		while (!scanner.hasNextInt()) {
			scanner.next();
			System.out.println(WRONG_INPUT);
		}
		return scanner.nextInt();
	}

	public void printLottos() {
		for (Lotto lotto : lottos) {
			lotto.printNumbers();
		}
	}
}
