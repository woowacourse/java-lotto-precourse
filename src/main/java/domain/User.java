package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class User {
	static private Scanner scanner = new Scanner(System.in);
	private static ArrayList<Lotto> userLottoList = new ArrayList<Lotto>();
	private static WinningLotto winningLotto;
	private static Map<Rank, Integer> compareResultMap = new LinkedHashMap<>();
	private static final int LOTTO_NUMBER_COUNT = 6;
	private static final int MAX_LOTTO_NUMBER = 45;
	private static final int PRICE_OF_ONE_LOTTO = 1000;

	public static int inputUserMoney() {
		String userInput = "";
		do {
			System.out.println("구입금액을 입력해주세요.");
			userInput = scanner.nextLine().trim();
		} while (!Util.isValidNumber(userInput) || !Util.isDividedByOneThousand(userInput));
		int inputMoney = Util.StringToInteger(userInput);
		return inputMoney;
	}

	public static void buyLotto(int inputMoney) {
		for (int i = 0; i < inputMoney / PRICE_OF_ONE_LOTTO; i++) {
			Lotto lotto = new Lotto(makeLottoNumber());
			userLottoList.add(lotto);
		}
	}

	public static List<Integer> makeLottoNumber() {
		Set<Integer> set = new HashSet<Integer>();
		while (set.size() < LOTTO_NUMBER_COUNT) {
			int num = (int) (Math.random() * MAX_LOTTO_NUMBER) + 1;
			set.add(new Integer(num));
		}
		List<Integer> list = new LinkedList<Integer>(set);
		Collections.sort(list);
		return list;
	}

	public static void printBoughtLottoList() {
		System.out.println(userLottoList.size() + "개를 구매했습니다. ");
		for (int i = 0; i < userLottoList.size(); i++) {
			System.out.println(userLottoList.get(i).getNumbers());
		}
		System.out.println();
	}

	public static void makeNumberListOfLastWeek() {
		List<Integer> lastweekNumberList = inputNumberOfLastweek();
		Lotto lastweekLotto = new Lotto(lastweekNumberList);
		int bonusNumber = inputBonusNumber(lastweekNumberList);
		winningLotto = new WinningLotto(lastweekLotto, bonusNumber);
	}

	public static List<Integer> inputNumberOfLastweek() {
		Set<Integer> set = new HashSet<Integer>();
		String[] userInputWithoutComma = {};
		do {
			userInputWithoutComma = splitWithComma();
			set = makeWeekNumberSet(userInputWithoutComma);
		} while (Util.isDuplicatedNumber(set) || !Util.isValidRange(userInputWithoutComma));
		List<Integer> lastweekNumberList = new LinkedList<Integer>(set);
		return lastweekNumberList;
	}

	public static String[] splitWithComma() {
		String userInput = "";
		String[] userInputWithoutComma = {};
		do {
			System.out.println("지난주 당첨번호를 입력해 주세요.");
			userInput = scanner.nextLine();
			userInputWithoutComma = userInput.split(",");
		} while (!Util.isvalidWeekNumber(userInputWithoutComma) || !Util.isValidNumberCount(userInputWithoutComma));
		return userInputWithoutComma;
	}

	public static Set<Integer> makeWeekNumberSet(String[] userInputWithoutComma) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < userInputWithoutComma.length; i++) {
			set.add(Util.StringToInteger(userInputWithoutComma[i].replaceAll("\\p{Z}", "")));
		}
		return set;
	}

	public static int inputBonusNumber(List<Integer> lastweekNumberList) {
		String userInput = "";
		do {
			System.out.println("보너스 볼을 입력해주세요.");
			userInput = scanner.nextLine();
		} while (!Util.isValidNumber(userInput) || !Util.checkValidRangeForBonus(userInput)
				|| Util.checkDuplicatedBonusNumber(userInput, lastweekNumberList));
		int inputMoney = Util.StringToInteger(userInput);
		return inputMoney;
	}

	public static void initData(Map<Rank, Integer> map) {
		map.put(Rank.FIFTH, 0);
		map.put(Rank.FOURTH, 0);
		map.put(Rank.THIRD, 0);
		map.put(Rank.SECOND, 0);
		map.put(Rank.FIRST, 0);
		map.put(Rank.MISS, 0);
	}

	public static int compareWithWinningLotto() {
		int sumOfWinningMoney = 0;
		initData(compareResultMap);
		for (int i = 0; i < userLottoList.size(); i++) {
			Rank rank = winningLotto.match(userLottoList.get(i));
			Integer value = compareResultMap.get(rank);
			sumOfWinningMoney += rank.getWinningMoney();
			compareResultMap.put(rank, value + 1);
		}
		compareResultMap.remove(Rank.MISS);
		return sumOfWinningMoney;
	}

	public static void printTotalResult(int gameMoney) {
		int totalWinningMoney = compareWithWinningLotto();
		printWinningResult(compareResultMap);
		System.out.println("총 수익률은 " + (double) totalWinningMoney / gameMoney + "입니다.");

	}

	public static void printWinningResult(Map<Rank, Integer> map) {
		System.out.println("당첨 통계\n----------");
		Set<Rank> set = map.keySet();
		Iterator<Rank> iter = set.iterator();
		while (iter.hasNext()) {
			Rank key = ((Rank) iter.next());
			Integer value = map.get(key);
			System.out.println(key.getCountOfMatch() + " 개 일치(" + key.getWinningMoney() + ")원-" + value + "개");
		}

	}

}
