package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LottoGenerator {
	static final int EACH_LOTTO_PRICE = 1000;
	static final int MIN_LOTTO_NUMBER = 1;
	static final int MAX_LOTTO_NUMBER = 45;
	static final int LOTTO_NUMBER_COUNT = 6;
	Scanner scanner = new Scanner(System.in);
	Random random = new Random();

	private int inputLottoPriceFromUser() {
		int lottoPrice;
		do {
			System.out.println("구입금액을 입력해 주세요.");
			lottoPrice = changeTypeStringToInt(scanner.next());
		} while (!validateLottoPrice(lottoPrice));
		return lottoPrice;
	}

	private int changeTypeStringToInt(String inputLottoPrice) {
		int lottoPrice;
		try {
			lottoPrice = Integer.parseInt(inputLottoPrice);
		} catch (NumberFormatException e) {
			// 구입금액이 정수가 아닐 경우, -1를 반환하여 1000원 이상이라는 조건을 만족하지 않음
			return -1;
		}
		return lottoPrice;
	}
	
	private boolean validateLottoPrice(int lottoPrice) {
		if (lottoPrice < EACH_LOTTO_PRICE || lottoPrice % EACH_LOTTO_PRICE != 0) {
			System.out.println("구입금액이 잘못 되었습니다.");
			return false;
		}
		return true;
	}
	
	private List<Integer> makeLottoNumbers() {
		List<Integer> lottoNumbers = new ArrayList<Integer>();
		while (lottoNumbers.size() < LOTTO_NUMBER_COUNT) {
			int randomNumber = random.nextInt(MAX_LOTTO_NUMBER) + MIN_LOTTO_NUMBER;
				lottoNumbers.add(randomNumber);
		}
		return lottoNumbers;
	}
}
