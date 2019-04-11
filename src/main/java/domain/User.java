package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class User {
	static private Scanner scanner = new Scanner(System.in);
	private static ArrayList<Lotto> userLottoList = new ArrayList<Lotto>();
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
	}

	public static int compareWithWinningLotto() {
	}

	public static void printTotalResult(int gameMoney) {
	}

}
