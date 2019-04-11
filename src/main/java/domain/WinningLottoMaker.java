package domain;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.lang.Integer;

public class WinningLottoMaker {

	private static final Scanner SCANNER = new Scanner(System.in);
	private static final String WINNIG_NUMBERS_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";
	private static final String OVERLAP_ERROR = "Err: 중복값을 입력하셨습니다. 다시 입력해주세요";
	private static final String SIZE_ERROR = "Err: 입력하신 숫자가 6개가 아닙니다. 다시 입력해주세요";
	private static final String NUMBER_ERROR = "Err: 입력하신 숫자가 1~45가 아닙니다. 다시 입력해주세요";
	private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
	private static final String BONUS_NUMBER_OVERLAP_ERROR = "Err: 보너스 볼이 당첨번호와 중복됩니다. 다시 입력해주세요.";
	private static final String SPLIT_STRING = "\\s?,\\s?";
	private static final int MAX_LOTTO_NUM = 45;
	private static final int MIN_LOTTO_NUM = 1;

	private ArrayList<Integer> inputWinningNumbers() {
		System.out.println(WINNIG_NUMBERS_MESSAGE);
		String winningNumbersString = SCANNER.nextLine();
		String[] winningNumbersArray = winningNumbersString.split(SPLIT_STRING);
		ArrayList<Integer> winningNumbers = convertIntegerArrayList(winningNumbersArray);
		tryInputWinningNumbers(winningNumbers);

		return winningNumbers;
	}

	private void tryInputWinningNumbers(ArrayList<Integer> winningNumbers) {
		checkOverlapError(winningNumbers);
		checkSizeError(winningNumbers);
		checkNumberError(winningNumbers);
	}

	private void checkOverlapError(ArrayList<Integer> winningNumbers) {
		HashSet<Integer> checkSet = new HashSet<Integer>(winningNumbers);
		if (winningNumbers.size() != checkSet.size()) {
			System.out.println(OVERLAP_ERROR);
			inputWinningNumbers();
		}
	}

	private void checkSizeError(ArrayList<Integer> winningNumbers) {
		if (winningNumbers.size() != 6) {
			System.out.println(SIZE_ERROR);
			inputWinningNumbers();
		}
	}

	private void checkNumberError(ArrayList<Integer> winningNumbers) {
		boolean check = false;
		for (int number : winningNumbers) {
			check = (number < MIN_LOTTO_NUM || number > MAX_LOTTO_NUM) ? true : check;
		}
		if (check) {
			System.out.println(NUMBER_ERROR);
			inputWinningNumbers();
		}
	}

	private int inputBonusNumber() {
		System.out.println(BONUS_NUMBER_MESSAGE);
		int bonusNumber = SCANNER.nextInt();
		return bonusNumber;
	}

	private ArrayList<Integer> convertIntegerArrayList(String[] stringArray) {
		ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
		for (String number : stringArray) {
			integerArrayList.add(Integer.parseInt(number));
		}
		return integerArrayList;
	}

	public WinningLotto makeWinningLotto() {
		ArrayList<Integer> winningNumbers = inputWinningNumbers();
		int bonusNumber = inputBonusNumber();
		
		tryMakeWinningLotto(winningNumbers, bonusNumber);
		WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);
		return winningLotto;
	}
	
	private void tryMakeWinningLotto(ArrayList<Integer> winningNumbers, int bonusNumber) {
		checkNumberError(bonusNumber);
		checkBonusNumberOverlapError(winningNumbers, bonusNumber);
	}
	
	private void checkNumberError(int bonusNumber) {
		if(bonusNumber < MIN_LOTTO_NUM || bonusNumber > MAX_LOTTO_NUM) {
			System.out.println(NUMBER_ERROR);
			makeWinningLotto();
		}
	}
	
	private void checkBonusNumberOverlapError(ArrayList<Integer> winningNumbers, int bonusNumber) {
		if(winningNumbers.contains(bonusNumber)) {
			System.out.println(BONUS_NUMBER_OVERLAP_ERROR);
			makeWinningLotto();
		}
	}
}