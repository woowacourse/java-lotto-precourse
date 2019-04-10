/*
 * LottoGame
 * 
 * version 1.0
 * 
 * 2019. 4. 7
 * 
 * Created by Wongeun Song
 */

package edu.yk1028;

import java.util.List;
import java.util.Scanner;

/**
 * 로또 당첨을 담당하는 객체
 */
public class LottoGame {
	private final int NUMBER_OF_LOTTO_NUMBERS = 6;
	private final String NUMBER_SEPARATOR = ",";
	private final String REQUEST_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
	private final String REQUEST_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
	private final String FAIL_GENERATEING_WINNING_LOTTO = "잘못된 당첨 번호입니다.";

	private WinningLotto winningLotto;

	public boolean generateWinningLotto() {
		try {
			Lotto lotto = new Lotto(makeList(inputWinningNumbers()));
			int bonusNumber = inputBonusNumber();

			winningLotto = makeWinningLotto(lotto, bonusNumber);
		} catch (Exception e) {
			System.out.println(FAIL_GENERATEING_WINNING_LOTTO);
			return false;
		}
		return true;
	}
	
	public void confirmWinning(User user) {
		Result result = user.calculateResult(winningLotto);
		result.print();
	}

	private String[] inputWinningNumbers() {
		Scanner scanner = new Scanner(System.in);

		System.out.println(REQUEST_WINNING_NUMBERS);
		return scanner.nextLine().split(NUMBER_SEPARATOR);
	}

	private List<Integer> makeList(String[] numbers) throws Exception {
		NumberList numberList = new NumberList();

		if (numbers.length != NUMBER_OF_LOTTO_NUMBERS) {
			throw new Exception();
		}
		for (String number : numbers) {
			numberList.add(Integer.parseInt(number.trim()));
		}
		return numberList.getList();
	}

	private int inputBonusNumber() throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.println(REQUEST_BONUS_NUMBER);
		int bonus = scanner.nextInt();
		if (bonus < 1 && 45 < bonus) {
			throw new Exception();
		}
		return bonus;
	}
	
	private WinningLotto makeWinningLotto(Lotto lotto,int bonus) throws Exception {
		if (lotto.hasNumber(bonus)) {
			throw new Exception();
		}
		return new WinningLotto(lotto, bonus);
	}
}
