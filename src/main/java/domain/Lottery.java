package domain;

import java.util.Scanner;

public class Lottery {

	// XXX Only 3 field in method!!
	private static final Scanner SCANNER = new Scanner(System.in);
	private static final int LOTTO_PRICE = 1_000;
	
	private int numberOfPurchases = 0;
	
	public void runProgram() {
		int inputtedPrice = inputPrice();
		setLottoCount(inputtedPrice);
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
	
	public void setLottoCount(int inputtedPrice) {
		numberOfPurchases = inputtedPrice / LOTTO_PRICE;
	}
}
