package domain;

import java.util.regex.Pattern;

/**
 * 유저 입력을 유효성 검사하는 클래스
 */
public class InputValidator {
	private static final int LOTTO_CHARGE = 1000;
	private static final int MOD_OF_LOTTO_CHARGE = 0;
	
	public boolean isValidPurchaseAmount (String purchaseAmount) {
		if (isNumber(purchaseAmount) 
				&& isThousandWonUnit(purchaseAmount)) {
			return true;
		}
		
		return false;
	}
	
	private boolean isNumber (String purchaseAmount) {
		String moneyPattern = "^[0-9]*$";
		
		if (Pattern.matches(moneyPattern, purchaseAmount)) {
			return true;
		}
		
		System.out.println("숫자만 입력할 수 있습니다.");
		return false;
	}
	
	private boolean isThousandWonUnit(String purchaseAmount) {
		int numPurchaseAmount = Integer.parseInt(purchaseAmount);
		
		if (numPurchaseAmount != 0 &&
				numPurchaseAmount%LOTTO_CHARGE == MOD_OF_LOTTO_CHARGE) {
			return true;
		}
		
		System.out.println("천원 단위로 입력해주세요.");
		return false;
	}
}
