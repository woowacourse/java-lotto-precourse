package domain;

import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Integer;

public class WinningLottoMaker {

	private static final Scanner SCANNER = new Scanner(System.in);
	private static final String WINNIG_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
	private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

	private String[] inputWinningNumbers() {
		System.out.println(WINNIG_NUMBERS_MESSAGE);
		String winningNumbersString = SCANNER.nextLine();
		String[] winningNumbersArray = winningNumbersString.split(",");
		return winningNumbersArray;
	}

	private int inputBonusNumber() {
		System.out.println(BONUS_NUMBER_MESSAGE);
		int bonusNumber = SCANNER.nextInt();
		return bonusNumber;
	}

	private ArrayList<Integer> stringArrayConvertIntegerArrayList(String[] stringArray) {
		ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
		for (String number : stringArray) {
			integerArrayList.add(Integer.parseInt(number));
		}
		return integerArrayList;
	}

	public WinningLotto makeWinningLotto() {
		ArrayList<Integer> winningNumbers = stringArrayConvertIntegerArrayList(inputWinningNumbers());
		int bonusNumber = inputBonusNumber();
		WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusNumber);
		return winningLotto;
	}

	/* 테스트 코드 */
	public static void main(String[] args) {
		WinningLottoMaker maker = new WinningLottoMaker();
		maker.makeWinningLotto();
	}
}
