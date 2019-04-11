package domain;
import java.util.*;

public class Vaild {
	private final int LottoMinNum = 1;
	private final int LottoMaxNum = 45;
	private final int MinPrice = 1000;
	
	public boolean priceVaild(String money) {

		if (!isInteger(money) || isNegative(money) || isMinPrice(money)) {
			return false;
		}
		return true;
	}
	
	public boolean isInteger(String input) {		
		boolean result = false; 
	
		try {
			Integer.parseInt(input) ;
			result = true ;
		} catch(NumberFormatException e){
			System.out.println("문자열은 입력할수 없습니다.");
		}
		return result ;
	}
	
	public boolean isNegative(String input) {
		boolean result = false;
		
		if (Integer.parseInt(input) < 0 ) {
			System.out.println("음수 값은 입력 할 수 없습니다 입력 값을 확인하세요");
			result = true;
		}
		return result;
	}
	
	public boolean isMinPrice(String input) {
		boolean result = false;
		
		if (Integer.parseInt(input) > 0 && Integer.parseInt(input) < MinPrice ) {
			System.out.println("금액이 너무 적게 입력되었습니다. 최소단위는 1000입니다.");
			result = true;
		}
		return result;
	}
}
