package domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static final String AMOUNT_QUESTION = "구입금액을 입력해 주세요.";
	static final String BOUGHT_STATEMENT = "%d개를 구매했습니다.\n";
	static final String LAST_WINNING_NUMBER_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
	static final String BONUS_NUMBER_QUESTION = "보너스 볼을 입력해 주세요.";
	static final String THREE_MATCH_STATEMENT = "3개 일치(5000원)- %d개\n";
	static final String FOUR_MATCH_STATEMENT = "4개 일치(50000원)- %d개\n";
	static final String FIVE_MATCH_STATEMENT = "5개 일치(1500000원)- %d개\n";
	static final String FIVE_MATCH_BONUS_STATEMENT = "5개 일치, 보너스 볼 일치(30000000원)-%d개\n";
	static final String SIX_BONUS_STATEMENT = "6개일치(2000000000원)- %d개\n";
	static final String PROFIT_RATE_STATEMENT = "총 수익률은 %f입니다.";
	
	private static WinningLotto winningLotto;
	public static int bonusWinningNumber = 0;
	
	private static int[] winningCount = new int[6];
	
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
		
		checkNoOfWinningLottos(userLottos);

		printFinalResult();
		printProfitRate(numberOfLottoToBuy);
	}
	
	
	private static void printProfitRate(int numberOfLottoToBuy) {
		double profitRate = (5000 * winningCount[4] + 50000 * winningCount[3] + 1500000 * winningCount[2] + 30000000 * winningCount[1] + 2000000000 * winningCount[0]) / (numberOfLottoToBuy * 1000);
		System.out.printf(PROFIT_RATE_STATEMENT, profitRate);
	}
	private static void printFinalResult() {
		System.out.println("당첨 통계");
		System.out.println("---------");
		System.out.printf(THREE_MATCH_STATEMENT, winningCount[4]);
		System.out.printf(FOUR_MATCH_STATEMENT, winningCount[3]);
		System.out.printf(FIVE_MATCH_STATEMENT, winningCount[2]);
		System.out.printf(FIVE_MATCH_BONUS_STATEMENT, winningCount[1]);
		System.out.printf(SIX_BONUS_STATEMENT, winningCount[0]);
	}
	
	private static void checkNoOfWinningLottos(Lotto[] userLottos) {
		for(int i = 0; i < userLottos.length; i++) {
			Rank currentRank = winningLotto.match(userLottos[i]);
			winningCount[currentRank.ordinal()]++;
		}
		
	}
	
	private static void setWinningNumber(String winningNumbersInput) {
		String[] winningNumberArr = winningNumbersInput.split(",");
		List<Integer> winningNumberList = new ArrayList<>();
		for(int i = 0; i < winningNumberArr.length; i++) {
			int currWinningNumber = Integer.parseInt(winningNumberArr[i]);
			winningNumberList.add(currWinningNumber);
		}
		winningLotto = new WinningLotto(new Lotto(winningNumberList), bonusWinningNumber);
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
