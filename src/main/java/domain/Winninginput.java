/*
 * @(#)Winninginput.java	1.8.0_191 2019/04/11
 * 
 * Copyright (c) 2019 Youngbae Son
 * ComputerScience, ProgrammingLanguage, Java, Busan, KOREA
 * All rights reserved.
 * 
 * */
package domain;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 당첨번호와 보너스번호에 대한
 * 입력과 예외처리를 담당하는 객체
 * 
 */
public class Winninginput {

	private List<Integer> numbers;
	private int bonusNum;

	private void createBonusNumber(String bonusNum) {

		this.bonusNum = Integer.parseInt(bonusNum);
	}

	public boolean inputOfLastWeekendLotto() {

		Scanner scan = new Scanner(System.in);
		System.out.println("지난 주 당첨 5개 번호를 입력해 주세요.");
		String inputWinningLotto = scan.nextLine();
		String[] lottoNumber = split(inputWinningLotto);

		if (!checkLength(lottoNumber))
			return false;
		
		if (checkInputWinningLotto(lottoNumber))
			return true;

		return false;
	}

	public boolean inputOfBonusNumber() {

		Scanner scan = new Scanner(System.in);
		System.out.println("보너스 볼을 입력해 주세요.");
		String bonusNo = scan.nextLine();

		if (checkBonusNo(bonusNo)) {
			createBonusNumber(bonusNo);
			return true;
		}

		return false;
	}

	private boolean checkBonusNo(String bonusNo) {

		try {
			int number = Integer.parseInt(bonusNo);
			if (number < 0 || number > 45)
				return false;
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	private void createWinningLotto(int[] lottoNumber) {

		numbers = new ArrayList<>();
		for (int i = 0; i < lottoNumber.length; i++) {
			numbers.add(lottoNumber[i]);
		}
	}

	private String[] split(String inputWinningLotto) {

		String[] winningLotto = inputWinningLotto.split(",");
		return winningLotto;
	}

	private boolean checkInputWinningLotto(String[] lottoNumber) {

		int[] number = new int[5];
		
		try {
			number[0] = Integer.parseInt(lottoNumber[0]);
			number[1] = Integer.parseInt(lottoNumber[1]);
			number[2] = Integer.parseInt(lottoNumber[2]);
			number[3] = Integer.parseInt(lottoNumber[3]);
			number[4] = Integer.parseInt(lottoNumber[4]);
		} catch (Exception e) {
			return false;
		}

		createWinningLotto(number);

		return true;
	}

	private boolean checkLength(String[] winningLotto) {

		if (winningLotto.length == 5)
			return true;

		return false;

	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public int getBonusNum() {
		return bonusNum;
	}

}
