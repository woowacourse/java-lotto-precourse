package domain;

import java.util.Scanner;
import java.util.regex.Pattern;

public class LottoGame {
	static private Scanner sc = new Scanner(System.in);
	static private final String NUMBER_CHECK_REGEX = "^[0-9]*$";
	static private final int LOTTO_PRICE = 1000;
	static private final int LOTTO_BUY_LIMIT = 100000;
	
	private String inputMoney() {
		System.out.println("구매금액을 입력해 주세요.");
		String money = sc.nextLine();
		return money;
	}
	
	private boolean checkNumberOrNot(String money) {
		return (Pattern.matches(NUMBER_CHECK_REGEX, money)) ? true : false;
	}
	
	private boolean devideByThousand(String money) {
		if (Integer.parseInt(money) % LOTTO_PRICE != 0 || Integer.parseInt(money) > LOTTO_BUY_LIMIT) {
			System.out.println("100,000이하의 금액을 1,000원 단위로 입력해주세요.");
			return false;
		}
		return true; 
	}
	

}