package domain;

import java.util.Scanner;

public class UserInput {
	private Scanner sc = new Scanner(System.in);
	private InputValidator validator; 
	
	public int InputPurchasingAmount() {
		String purchasingAmount;
		validator = new InputValidator();
		
		do {
			purchasingAmount = sc.next();
		} while (!validator.isValidPurchasingAmount(purchasingAmount));
		
		return Integer.parseInt(purchasingAmount);
	}
}
