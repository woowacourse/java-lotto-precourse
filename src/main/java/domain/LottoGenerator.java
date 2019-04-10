package domain;

import java.util.Scanner;

public class LottoGenerator {
	Scanner scanner = new Scanner(System.in);
	
	private int inputLottoPriceFromUser() {
		System.out.println("구입금액을 입력해 주세요.");
		return scanner.nextInt();
	}
}
