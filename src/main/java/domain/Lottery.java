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
	
	private int inputPrice() {
		String price = "";
		do {
			System.out.println("구입 금액을 입력해 주세요.");
			price = SCANNER.nextLine();
			
		}while(isNaturalNumber(price));
		return Integer.parseInt(price);
	}
	
	private boolean isNaturalNumber(String value) {
		// TODO ADD more exception!
		if(value == null || value.length() == 0) {
			return false;
		}
		return true;
	}
	
	private void setLottoCount(int inputtedPrice) {
		numberOfPurchases = inputtedPrice / LOTTO_PRICE;
		
		// TODO 위치 변경
		System.out.println(numberOfPurchases + "개를 구매했습니다.");
	}
	
	
}
