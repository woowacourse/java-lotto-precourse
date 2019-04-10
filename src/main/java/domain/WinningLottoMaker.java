/*
 * @WinningLottoMaker.java		1.02 2019/04/10
 * 
 * Copyright(c)2019			HwiJin Hong.
 * All right reserved.
 * 
 * [ 우아한 테크코스 3주차 미션 ]
 * 로또 게임 프로그램
 */

package domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 당첨 로또 번호를 만들어주는 클래스
 * 
 * @version 1.02 2019년 4월 10일
 * @author 홍휘진
 *
 */
public class WinningLottoMaker {

	private static final String LAST_WINNER_LOTTO = "지난 주 당첨 번호를 입력해 주세요.";

	private static final String LAST_WINNER_ERROR = "반드시 6개의 숫자(1~45)를 [,]로 구분하세요!";

	private static final String BONUS_LOTTO = "보너스 볼을 입력해 주세요.";

	private static final String BONUS_LOTTO_ERROR = "제대로 보너스 볼(1~45숫자)을 입력해 주세요.";

	private Scanner scanner;

	private Lotto lastWeekLotto;

	private int bonusNo;

	public WinningLottoMaker(Scanner scanner) {
		this.scanner = scanner;
	}

	public WinningLotto makeWinninglotto() {
		winnerLottoInput();
		bonusNumberInput();
		return new WinningLotto(lastWeekLotto, bonusNo);
	}

	private void winnerLottoInput() {
		System.out.println(LAST_WINNER_LOTTO);
		while (notValidLotto(scanner.nextLine())) {
			System.out.println(LAST_WINNER_ERROR);
		}
	}

	private void bonusNumberInput() {
		System.out.println(BONUS_LOTTO);
		while (notValidBonusLotto(scanner.nextLine())) {
			System.out.println(BONUS_LOTTO_ERROR);
		}
	}

	private boolean notValidLotto(String lottoScan) {
		if (notValidString(lottoScan)) {
			return true;
		}
		return notLotto(lottoScan.split(","));
	}

	private boolean notValidBonusLotto(String lottoScan) {
		if (!LottoGame.isValidNumber(lottoScan)) {
			return true;
		}
		bonusNo = Integer.parseInt(lottoScan);
		return ((bonusNo < Lotto.MIN_LOTTO_NUM) || (bonusNo > Lotto.MAX_LOTTO_NUM));
	}

	private boolean notLotto(String[] lottoNumbers) {
		if (lottoNumbers.length != Lotto.LOTTO_NUMBER_SIZE) {
			return true;
		}
		boolean validNumbers = true;
		for (String lottoNumber : lottoNumbers) {
			validNumbers &= LottoGame.isValidNumber(lottoNumber);
			validNumbers &= notLottoNumber(lottoNumber, validNumbers);
		}
		return validNumbers ? !parseWinnerLotto(lottoNumbers) : true;
	}

	private boolean notValidString(String lottoScan) {
		return !lottoScan.contains(",");
	}

	private boolean notLottoNumber(String lottoNumber, boolean validNumbers) {
		if (!validNumbers) {
			return false;
		}
		int number = Integer.parseInt(lottoNumber);
		return ((number <= Lotto.MAX_LOTTO_NUM) && (number >= Lotto.MIN_LOTTO_NUM));
	}

	private boolean parseWinnerLotto(String[] lottoNumbers) {
		List<Integer> numbers = new LinkedList<>();
		int number;
		for (String lottoNumber : lottoNumbers) {
			number = Integer.parseInt(lottoNumber);
			numbers.add(number);
		}
		lastWeekLotto = new Lotto(numbers);
		return Lotto.duplicateNumberInLotto(numbers);
	}
}
