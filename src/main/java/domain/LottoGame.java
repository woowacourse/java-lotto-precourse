package domain;

import java.util.Scanner;
import java.util.regex.Pattern;

public class LottoGame {
	static private Scanner sc = new Scanner(System.in);
	static private final String NUMBER_CHECK_REGEX = "^[0-9]*$";
	
	private String inputMoney() {
		System.out.println("구매금액을 입력해 주세요.");
		String money = sc.nextLine();
		return money;
	}
	
	private boolean checkNumberOrNot(String money) {
		return (Pattern.matches(NUMBER_CHECK_REGEX, money)) ? true : false;
	}
	
}