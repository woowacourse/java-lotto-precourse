package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static final String AMOUNT_QUESTION = "구입금액을 입력해 주세요.";
	static final String BOUGHT_STATEMENT = "%d개를 구매했습니다.\n";
	static final String LAST_WINNING_NUMBER_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
	static final String BONUS_NUMBER_QUESTION = "보너스 볼을 입력해 주세요.";
	
	public static int[] winningNumbers = new int[46];
	public static int bonusWinningNumber = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(AMOUNT_QUESTION);
		
		int inputMoney = Integer.parseInt(in.readLine());
		
		int numberOfLottoToBuy = numberOfLotto(inputMoney);
		
		System.out.printf(BOUGHT_STATEMENT, numberOfLottoToBuy);
		
		Lotto[] userLottos = new Lotto[numberOfLottoToBuy];
		
		initializeLottos(userLottos);
		printLottos(userLottos);
		
		System.out.println(LAST_WINNING_NUMBER_QUESTION);
		String winningNumbersInput = in.readLine();
		setWinningNumber(winningNumbersInput);
		
		System.out.println(BONUS_NUMBER_QUESTION);
		bonusWinningNumber = Integer.parseInt(in.readLine());
		
	}
	
	private static void setWinningNumber(String winningNumbersInput) {
		String[] winningNumberArr = winningNumbersInput.split(",");
		for(int i = 0; i < winningNumberArr.length; i++) {
			int currWinningNumber = Integer.parseInt(winningNumberArr[i]);
			++winningNumbers[currWinningNumber];
		}
	}
	
	private static void printLottos(Lotto[] userLottos) {
		for(int i = 0; i < userLottos.length; i++) {
			userLottos[i].printLotto();
		}
	}
	
	private static void initializeLottos(Lotto[] userLottos) {
		for(int i = 0; i < userLottos.length; i++) {
			userLottos[i] = new Lotto(new ArrayList<Integer>());
			userLottos[i].setWinningNumbers();
		}
	}
	
	private static int numberOfLotto(int inputMoney) {
		return inputMoney / 1000;
	}
}
