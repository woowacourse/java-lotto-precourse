package domain;

import java.util.Scanner;

public class LottoGenerator {
	Scanner scanner = new Scanner(System.in);

	private int inputLottoPriceFromUser() {
		System.out.println("구입금액을 입력해 주세요.");
		return changeTypeStringToInt(scanner.next());
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
}
