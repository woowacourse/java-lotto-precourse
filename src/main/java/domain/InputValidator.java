package domain;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 유저 입력을 유효성 검사하는 클래스
 */
public class InputValidator {
	private static final int LOTTO_CHARGE = 1000;
	private static final int MOD_OF_LOTTO_CHARGE = 0;
	private static final int COUNT_OF_BALL = 6;
	private static final int COUNT_OF_BONUS_BALL = 1;
	private static final String PATTERN_OF_MONEY = "^[0-9]*$";
	private static final int MIN_BALL = 1;
	private static final int MAX_BALL = 45;
	
	public boolean isValidPurchaseAmount (String purchaseAmount) {
		if (isNumber(purchaseAmount) 
				&& isThousandWonUnit(purchaseAmount)) {
			return true;
		}
		
		return false;
	}
	
	private boolean isNumber (String purchaseAmount) {
		if (Pattern.matches(PATTERN_OF_MONEY, purchaseAmount)) {
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
	
	public boolean isValidNuberBalls(List<String> numbers) {
		if (isValidSize(numbers) && isCollectNumber(numbers)
				&& noOverlap(numbers)) {
			return true;
		}
		return false;
	}
	
	private boolean isValidSize(List<String> numbers) {
		if (numbers.size() == COUNT_OF_BALL) {
			return true;
		}
		System.out.println("당첨번호 6개를 입력해주세요.");
		return false;
	}

	private boolean isCollectNumber (List<String> numbers) {
		for (String number : numbers) {
			if (!Pattern.matches(PATTERN_OF_MONEY, number)
					|| !(MIN_BALL<=Integer.parseInt(number)
						&&MAX_BALL>=Integer.parseInt(number))) {
				return false;
			}
		}
		System.out.println("1에서 45사이의 수만 입력해주세요");
		return true;
	}
	
	private boolean noOverlap(List<String> numbers) {
		numbers = numbers.stream().distinct().collect(Collectors.toList());
		if (numbers.size() != COUNT_OF_BALL) {
			return false;
		}
		System.out.println("중복되지 않는 번호를 입력해주세요");
		return true;
	}
	
	private boolean noOverlapBonusNO(List<String> numbers) {
		numbers = numbers.stream().distinct().collect(Collectors.toList());
		
		if (numbers.size() != COUNT_OF_BALL+COUNT_OF_BONUS_BALL) {
			System.out.println("중복되지 않는 번호를 입력해주세요");
			return false;
		}
		return true;
	}
	
	public boolean isValidBonusNO(String bonusNo, List<String> numbers) {
		if (!isNumber(bonusNo)) {
			return false;
		}
		numbers.add(bonusNo);
		if (!noOverlapBonusNO(numbers)) {
			return false;
		}
		return true;
	}
	
}
