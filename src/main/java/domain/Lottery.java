package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import domain.util.Validator;

public class Lottery {

	private static final Scanner SCANNER = new Scanner(System.in);

	private long price;

	public void runProgram() {
		long inputtedPrice = inputPrice();
		setPrice(inputtedPrice);
		UserLotto userLotto = new UserLotto(price);
		userLotto.printLottoes();
		WinningLotto winningLotto = setWinnigLotto();
		Map<Rank, Integer> result = calculateResult(userLotto, winningLotto);
		printResult(result);
	}

	private long inputPrice() {
		String price = "";
		do {
			System.out.println("구입 금액을 입력해 주세요.");
			price = SCANNER.nextLine();
		} while (!Validator.isNaturalNumber(price));
		return Long.parseLong(price.trim());
	}

	public void setPrice(long price) {
		this.price = price;
	}

	private WinningLotto setWinnigLotto() {
		Lotto lotto = new Lotto(inputPreviousLotto());
		int bonusNumber = inputPreviousBonusNumber(lotto);
		return new WinningLotto(lotto, bonusNumber);
	}

	private List<Integer> inputPreviousLotto() {
		String previousLotto = "";
		do {
			System.out.println("지난 주 당첨 번호를 입력해 주세요.");
			previousLotto = SCANNER.nextLine();
		} while (!Validator.isValidInputtedNumbers(previousLotto, Lotto.DRAWS_COUNT));

		return Arrays.stream(previousLotto.split(","))
			.sorted()
			.map(number -> Integer.parseInt(number.trim()))
			.collect(Collectors.toList());
	}

	private int inputPreviousBonusNumber(Lotto lotto) {
		String previousBonusNumber = "";
		do {
			System.out.println("지난 주 보너스 번호를 입력해 주세요.");
			previousBonusNumber = SCANNER.nextLine();
		} while (!Validator.isIncludeLottoNumber(previousBonusNumber)
			&& !lotto.getNumbers().contains(Integer.parseInt(previousBonusNumber)));
		return Integer.parseInt(previousBonusNumber.trim());
	}

	private Map<Rank, Integer> calculateResult(UserLotto userLotto, WinningLotto winningLotto) {
		Map<Rank, Integer> result = new HashMap<>();
		Arrays.stream(Rank.values()).forEach(rank -> result.put(rank, 0));

		for (Lotto lotto : userLotto.getLottoes()) {
			Rank rank = winningLotto.match(lotto);
			result.put(rank, result.get(rank) + 1);
		}
		return result;
	}

	private void printResult(Map<Rank, Integer> result) {
		long sum = 0;
		for (Rank rank : Rank.values()) {
			rank.printMatchResult(result.get(rank));
			sum += rank.getWinningMoney() * result.get(rank);
		}
		System.out.printf("총 수익률은 %.2f%% 입니다.\n", calculateEarningRate(sum));
	}

	private double calculateEarningRate(long sum) {
		return sum / (double)price * 100;
	}
}
