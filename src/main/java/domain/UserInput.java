package domain;

import java.util.Scanner;

/**
 * 유저 입력을 처리하는 클래스
 */
public class UserInput {
	private Scanner sc = new Scanner(System.in);
	private InputValidator validator; 
	
	public int InputPurchaseAmount() {
		String purchaseAmount;
		validator = new InputValidator();
		
		do {
			System.out.println("구입금액을 입력해 주세요.");
			purchaseAmount = sc.next();
		} while (!validator.isValidPurchaseAmount(purchaseAmount));
		
		return Integer.parseInt(purchaseAmount);
	}
	
	
}
