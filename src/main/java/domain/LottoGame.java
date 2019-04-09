/*
 * @LottoGame.java		1.00 2019/04/09
 * 
 * Copyright(c)2019		HwiJin Hong.
 * All right reserved.
 * 
 * [ 우아한 테크코스 3주차 미션 ]
 * 로또 게임 프로그램
 */

package domain;

import java.util.Scanner;

/**
 * 로또게임이 진행되는 클래스
 * 
 * @version 1.00 2019년 4월 9일
 * @author 홍휘진
 *
 */
public class LottoGame {

	private static final String MONEY_MSG = "0원 이상의 정수로 구입금액을 입력해 주세요.";

	private static final String MONEY_ERROR = "반드시 0원 이상의 정수로 입력해주세요!";

	private static final int MONEY_MIN_BOUND = 0;

	private static final int MONEY_MAX_BOUND = 4000000;

	private MyLottoManager myLottoManager;

	private WinningLottoMaker winningLottoMaker;

	private WinningLotto winningLotto;

	private Scanner scanner;

	private int money;

	public LottoGame() {
		scanner = new Scanner(System.in);
		myLottoManager = new MyLottoManager();
		winningLottoMaker = new WinningLottoMaker(scanner);
	}
	
	public static boolean isValidNumber(String numberScan) {
		try {
			Integer.parseInt(numberScan);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public void lottogame() {
		moneyInput();
		myLottoManager.buyLotto(money);
		winningLotto = winningLottoMaker.makeWinninglotto();
	}

	private void moneyInput() {
		System.out.println(MONEY_MSG);
		while (notValidMoney(scanner.nextLine())) {
			System.out.println(MONEY_ERROR);
		}
	}

	private boolean notValidMoney(String moneyScan) {
		if (!isValidNumber(moneyScan)) {
			return true;
		}
		money = Integer.parseInt(moneyScan);
		if ((money < MONEY_MIN_BOUND) || (money > MONEY_MAX_BOUND)) {
			return true;
		}
		return false;
	}
}
