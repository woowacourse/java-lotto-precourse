package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LottoGame {
	private static int numberOfPurchase; 
	private static final int LOTTO_CHARGE = 1000;
	private static final int MIN_NUMBER_BALL = 1;
	private static final int MAX_NUMBER_BALL = 45;
	private static final int COUNT_OF_BALL = 6;
	private static List<Lotto> lottos = new ArrayList<>(); 
	
	public void printNumberOfPurchase(int purchaseAmount) {
		numberOfPurchase = purchaseAmount/LOTTO_CHARGE;
		System.out.println("\n"+numberOfPurchase+"개를 구매했습니다.");
	}
	
	public List<Integer> makeRandomNumberBalls() {
		List<Integer> numbers = new ArrayList<>();
		Random random = new Random();
		int numberBall;
		
		do {
			numberBall = random.nextInt(MAX_NUMBER_BALL)+MIN_NUMBER_BALL;
			numbers.add(numberBall);
			numbers = numbers.stream().distinct().collect(Collectors.toList());
		} while (numbers.size() < COUNT_OF_BALL);
		
		Collections.sort(numbers);
		
		return numbers;
	}

	public static void main(String[] args) {
		LottoGame game = new LottoGame();
		UserInput user = new UserInput();
		Lotto lotto;
		WinningLotto winningLotto;
		int purchaseAmount;
		int bonusNo;
		
		purchaseAmount = user.inputPurchaseAmount();
		game.printNumberOfPurchase(purchaseAmount);
		
		for (int i = 0; i < numberOfPurchase; i++) {
			lottos.add(new Lotto(game.makeRandomNumberBalls()));
			lottos.get(i).print();
		}
		
		lotto = user.inputWinningLotto();
		bonusNo = user.inputBonusNo();
		winningLotto = new WinningLotto(lotto, bonusNo);
		
		for (int i = 0; i < numberOfPurchase; i++) {
			winningLotto.match(lottos.get(i));
		}
	}

	
}
