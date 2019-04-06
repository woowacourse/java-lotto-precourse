package domain;

import java.util.Scanner;

public class Lottery {

	// XXX Only 3 field in method!!
	private static final Scanner SCANNER = new Scanner(System.in);
	
	public void runProgram() {
		int price = inputPrice();
	}
	
	public int inputPrice() {
		String price = "";
		do {
			System.out.println("구입 금액을 입력해 주세요.");
			price = SCANNER.nextLine();
			
		}while(isNaturalNumber(price));
		return Integer.parseInt(price);
	}
	
	public boolean isNaturalNumber(String value) {
		// TODO ADD more exception!
		if(value == null || value.length() == 0) {
			return false;
		}
		return true;
	}
}
