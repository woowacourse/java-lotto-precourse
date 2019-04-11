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
	
	public boolean winNumVaild(String input) {
		String temp[] = input.split(",");
		for(int i = 0; i < temp.length; i++) {
			if (!isInteger(temp[i])) {
				return false;
			}
		}
		if ( isSixNum(temp)|| isLottoNum(temp) || isOverLap(temp)) {
			return false;
		}
		return true;
	}
	
	public boolean isSixNum(String[] input) {
		boolean result = false;
		if (input.length != 6) {
			System.out.println("6개의 숫자를 입력해주세요.");
			result = true;
		}
		return result;
	}
	
	public boolean isLottoNum(String[] input) {
		boolean result = false;
		for (int i = 0; i < input.length; i++) {
			int number = Integer.parseInt(input[i]);
			if (number < 1 || number > 45) {
				System.out.println("입력 숫자가 로또 숫자가 아닙니다.");
				result = true;
			}
		}
		return result;
	}
	
	public boolean isOverLap(String[] input) {
		boolean result = false;
		for (int i = 0; i < input.length; i++) {
			for (int j = 1; j < input.length; j++) {
				if (input[i] == input[j]) {
					System.out.println("중복되는 값은 입력하실 수 없습니다.");
					result = true;
				}
			}
		}
		return result;
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
