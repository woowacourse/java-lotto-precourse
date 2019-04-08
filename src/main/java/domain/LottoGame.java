package domain;

import java.util.Scanner;

public class LottoGame {
	static private Scanner sc = new Scanner(System.in);
	
	private String inputMoney() {
		System.out.println("구매금액을 입력해 주세요.");
		
		String money = sc.nextLine();
		
		return money;
	}
}