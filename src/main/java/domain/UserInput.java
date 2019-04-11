package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 유저 입력을 처리하는 클래스
 */
public class UserInput {
	private Scanner sc = new Scanner(System.in);
	private InputValidator validator = new InputValidator(); 
	private List<String> numbers = new ArrayList<>();
	
	public int inputPurchaseAmount() {
		String purchaseAmount;
		
		do {
			System.out.println("구입금액을 입력해 주세요.");
			purchaseAmount = sc.nextLine();
		} while (!validator.isValidPurchaseAmount(purchaseAmount));
		
		return Integer.parseInt(purchaseAmount);
	}
	
	public Lotto inputWinningLotto() {
		do {
			System.out.println("지난 주 당첨 번호를 입력해주세요.");
			splitNumberBall();
		} while (validator.isValidNuberBalls(numbers));
		
		List<Integer> intNumbers = numbers.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
		Collections.sort(numbers);
		
		return new Lotto(intNumbers);
	}
	
	public int inputBonusNo() {
		String bonusNo;
		do {
			System.out.println("보너스 볼을 입력해주세요.");
			bonusNo = sc.nextLine();
		} while (validator.isValidBonusNO(bonusNo, numbers));
		
		return Integer.parseInt(bonusNo);
	}
	
	private void splitNumberBall() {
		String inputNumbers = sc.nextLine();
		numbers = Arrays.asList(inputNumbers.split(","));
	}
}
