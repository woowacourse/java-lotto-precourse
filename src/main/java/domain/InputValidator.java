package domain;

import java.util.regex.Pattern;

public class InputValidator {
	private static final int LOTTO_CHARGE = 1000;
	private static final int MOD_OF_LOTTO_CHARGE = 0;
	
	public boolean isValidPurchasingAmount (String purchasingAmount) {
		if (isNumber(purchasingAmount) 
				&& isThousandWonUnit(purchasingAmount)) {
			return true;
		}
		
		return false;
	}
	
	private boolean isNumber (String purchasingAmount) {
		String moneyPattern = "^[0-9]*$";
		
		if (Pattern.matches(moneyPattern, purchasingAmount)) {
			return true;
		}
		
		System.out.println("숫자만 입력할 수 있습니다.");
		return false;
	}
	
	private boolean isThousandWonUnit(String purchasingAmount) {
		int numPurchasingAmount = Integer.parseInt(purchasingAmount);
		
		if (numPurchasingAmount != 0 &&
				numPurchasingAmount%LOTTO_CHARGE == MOD_OF_LOTTO_CHARGE) {
			return true;
		}
		
		System.out.println("천원 단위로 입력해주세요.");
		return false;
	}
}
