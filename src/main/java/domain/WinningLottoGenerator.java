package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * 지난 주 당첨 번호와 보너스 볼을 입력받아 당첨 로또를 생성하는 객체
 */
public class WinningLottoGenerator {
	static final int LOTTO_NUMBER_COUNT = new LottoGenerator().get_LOTTO_NUMBER_COUNT();
	static final int MIN_LOTTO_NUMBER = new LottoGenerator().get_MIN_LOTTO_NUMBER();
	static final int MAX_LOTTO_NUMBER = new LottoGenerator().get_MAX_LOTTO_NUMBER();
	Scanner scanner = new Scanner(System.in);

	private List<Integer> inputWinningNumbersFromUser() {
		List<Integer> winningNumbers;
		do {
			System.out.println("지난 주 당첨 번호를 입력해주세요.");
			winningNumbers = getSplitedWinningNumbers(scanner.next());
		} while (!validateWinningNumbers(winningNumbers));
		return winningNumbers;
	}

	private List<Integer> getSplitedWinningNumbers(String winningNumbers) {
		String[] splitedWinningNumbers = winningNumbers.split(",");
		List<Integer> listWinningNumbers = new ArrayList<Integer>();
		for (int i = 0; i < splitedWinningNumbers.length; i++) {
			int winningNumber = changeTypeStringToInt(splitedWinningNumbers[i]);
			listWinningNumbers.add(winningNumber);
		}
		return listWinningNumbers;
	}

	private int changeTypeStringToInt(String inputWinningNumber) {
		int winningNumber;
		try {
			winningNumber = Integer.parseInt(inputWinningNumber);
		} catch (NumberFormatException e) {
			// 당첨 번호가 정수가 아닐 경우, -1을 반환하여 1 ~ 45가 아니도록 한다.
			return -1;
		}
		return winningNumber;
	}

	private boolean validateWinningNumbers(List<Integer> winningNumbers) {
		Collections.sort(winningNumbers);
		if (!validateWinningNumbersCount(winningNumbers) || !validateWinningNumbersRange(winningNumbers)
				|| !validateWinningNumbersOverlap(winningNumbers)) {
			System.out.println("당첨 번호가 잘못되었습니다.");
			return false;
		}
		return true;
	}

	private boolean validateWinningNumbersCount(List<Integer> winningNumbers) {
		if (winningNumbers.size() != LOTTO_NUMBER_COUNT) {
			return false;
		}
		return true;
	}

	private boolean validateWinningNumbersRange(List<Integer> winningNumbers) {
		if ((winningNumbers.get(0) < MIN_LOTTO_NUMBER)
				|| (winningNumbers.get(winningNumbers.size() - 1) > MAX_LOTTO_NUMBER)) {
			return false;
		}
		return true;
	}

	private boolean validateWinningNumbersOverlap(List<Integer> winningNumbers) {
		List<Integer> tmpWinningNumbers = new ArrayList<Integer>();
		tmpWinningNumbers.addAll(winningNumbers);
		boolean overlap = false;
		while (!tmpWinningNumbers.isEmpty() && overlap == false) {
			int winningNumber = tmpWinningNumbers.get(0);
			tmpWinningNumbers.remove(0);
			overlap = tmpWinningNumbers.contains(winningNumber);
		}
		return !overlap; // overlap이 True일 때: 중복이 존재(유효하지 않음), overlap이 False일 때: 중복이 존재하지 않음(유효함)
	}

	private int inputBonusNumberFromUser() {
		System.out.println("보너스 볼을 입력해 주세요.");
		return changeTypeStringToInt(scanner.next());
	}
}
