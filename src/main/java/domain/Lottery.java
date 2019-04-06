package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lottery {

	// XXX Only 3 field in method!!
	private static final Scanner SCANNER = new Scanner(System.in);
	private static final int LOTTO_PRICE = 1_000;

	private Integer[] ALL_LOTTO_NUMBER = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
		11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
		21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
		31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
		41, 42, 43, 44, 45};
	private static final int DRAWS_COUNT = 6;

	private int price;
	private int lottoCount = 0;
	private List<Lotto> lottoes;

	public void runProgram() {
		int inputtedPrice = inputPrice();
		setPrice(inputtedPrice);
		setLottoCount();
		setLottoes(lottoCount);
		printLottoes();
	}

	private int inputPrice() {
		String price = "";
		do {
			System.out.println("구입 금액을 입력해 주세요.");
			price = SCANNER.nextLine();

		} while (!isNaturalNumber(price));
		// TODO int? long?
		return Integer.parseInt(price);
	}

	public void setPrice(int price) {
		this.price = price;
	}

	private boolean isNaturalNumber(String value) {
		// TODO ADD more exception!
		if (value == null || value.length() == 0) {
			return false;
		}
		return true;
	}

	private void setLottoCount() {
		lottoCount = price / LOTTO_PRICE;
	}

	private void setLottoes(int lottoCount) {
		List<Lotto> purchasedLotto = new ArrayList<>();
		for (int i = 0; i < lottoCount; ++i) {
			purchasedLotto.add(createLotto());
		}
		this.lottoes = purchasedLotto;
	}

	private void printLottoes() {
		if (lottoes != null || lottoes.size() == 0) {
			System.out.println("구매한 로또가 없습니다.");
		}
		System.out.println(lottoCount + "개를 구매했습니다.");
		for (Lotto lotto : lottoes) {
			System.out.println(lotto);
		}
	}

	private Lotto createLotto() {
		List<Integer> lottoNumbersToExtract = new ArrayList<>(Arrays.asList(ALL_LOTTO_NUMBER));

		List<Integer> lottoNumber = new ArrayList<>();
		for (int i = 0; i < DRAWS_COUNT; ++i) {
			int randomNumber = selectRandomLottoNumber(lottoNumbersToExtract);
			lottoNumber.add(randomNumber);
		}
		Collections.sort(lottoNumber);
		return new Lotto(lottoNumber);
	}

	private int selectRandomLottoNumber(List<Integer> lottoNumbersToExtract) {
		return lottoNumbersToExtract
			.remove((int)(Math.random() * lottoNumbersToExtract.size()));
	}

}
