package domain;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
	public static Scanner scan = new Scanner(System.in);
	public static final int LOTTO_NUM_LENGTH = 6;
	public static final int LOTTO_PRICE = 1000;
	public static final int LOTTO_WINNING_MIN_COUNT = 3;

	public static void main(String[] args) {
		int price = getPrice();
		int lottoCount = price / LOTTO_PRICE;
		System.out.println(lottoCount + "개를 구매했습니다.");
		List<Lotto> lottoList = makeLottoList(lottoCount);
		List<Rank> rankList = new ArrayList<Rank>();
		Lotto winningNumber;
		scan.nextLine();
		int totalReward = 0;
		WinningLotto winLotto = new WinningLotto(winningNumber = new Lotto(scanWinningNumber()),
				scanBonusNumber(winningNumber));
		for (int i = 0; i < lottoCount; ++i) {
			rankList.add(winLotto.match(lottoList.get(i)));
		}
		printResult(rankList, price);

	}

	public static int getPrice() {
		System.out.println("구입 금액을 입력해 주세요.");
		int price = scan.nextInt();
		;
		if (isValidPrice(price)) {
			price = scan.nextInt();
		}
		if (price % LOTTO_PRICE != 0) {
			System.out.println("거스름돈은 " + price % 1000 + "원 입니다.");
		}
		return price;
	}

	public static boolean isValidPrice(int price) {
		if (price < LOTTO_PRICE) {
			System.out.println("최소 구입 금액은 1000원입니다.");
			System.out.println("다시 입력해주십시오.");
			return true;
		}
		return false;
	}

	public static List<Integer> getRandomNumber() {
		List<Integer> randomNumber = new ArrayList<Integer>();
		for (int i = 0; i < LOTTO_NUM_LENGTH; i++) {
			randomNumber.add((int) (Math.random() * 45) + 1);
		}
		return randomNumber;
	}

	public static boolean isNotValid(List<Integer> temp) {
		boolean result = false;
		for (int i = 0; i < LOTTO_NUM_LENGTH - 1; i++) {
			result |= (temp.get(i) == temp.get(i + 1));
		}
		return result;
	}

	public static List<Integer> makeLotto() {
		List<Integer> lottoNum;
		do {
			lottoNum = getRandomNumber();
			Collections.sort(lottoNum);
		} while (isNotValid(lottoNum));
		System.out.println(lottoNum);
		return lottoNum;

	}

	public static List<Lotto> makeLottoList(int lottoCount) {
		List<Lotto> lottoList = new ArrayList<Lotto>();
		for (int i = 0; i < lottoCount; ++i) {
			lottoList.add(new Lotto(makeLotto()));
		}
		return lottoList;
	}

	public static List<Integer> getWinningNumber() {
		List<Integer> winningNumber = new ArrayList<Integer>();
		String[] input = scan.nextLine().split(",");
		if (input.length != LOTTO_NUM_LENGTH) {
			System.out.println("숫자의 갯수가 6개가 넘습니다!\n다시 입력해주세요.");
			return getWinningNumber();
		}
		for (int i = 0; i < LOTTO_NUM_LENGTH; ++i) {
			winningNumber.add(Integer.parseInt(input[i].trim()));
		}
		return winningNumber;
	}

	public static boolean isNotWinningValidRange(List<Integer> winningNumber) {
		boolean result = false;
		for (int i = 0; i < LOTTO_NUM_LENGTH; ++i) {
			result |= (winningNumber.get(i) > 45 || winningNumber.get(i) < 1);
		}
		return result;
	}

	public static void printErrorMessage(int tryNum) {
		if (tryNum > 0) {
			System.out.println("중복 숫자와 범위 밖 숫자는 입력할 수 없습니다.");
			System.out.println("다시 입력하십시오.");
		}
	}

	public static List<Integer> scanWinningNumber() {
		List<Integer> winningNumber;
		System.out.println("\n지난 추 당첨 번호를 입력해 주세요.");
		int tryNum = 0;
		do {
			printErrorMessage(tryNum);
			winningNumber = getWinningNumber();
			Collections.sort(winningNumber);
			++tryNum;
		} while (isNotValid(winningNumber) || isNotWinningValidRange(winningNumber));
		return winningNumber;
	}

	public static boolean isAlready(Lotto winningNumber, int bonusNumber) {
		boolean result = false;
		for (int i = 0; i < LOTTO_NUM_LENGTH; ++i) {
			result |= (winningNumber.getNumbers().get(i) == bonusNumber);
		}

		return result;
	}

	public static boolean isNotBonusValidRange(int bonusNumber) {
		boolean result = false;
		if (bonusNumber > 45 || bonusNumber < 1) {
			return true;
		}
		return false;

	}

	public static int scanBonusNumber(Lotto winningNumber) {
		System.out.println("보너스 볼을 입력해주세요.");
		int bonusNumber = scan.nextInt();
		while (isAlready(winningNumber, bonusNumber) || isNotBonusValidRange(bonusNumber)) {
			System.out.println("당첨 숫자와 중복되는 수와 범위 밖 숫자는 입력할 수 없습니다.");
			System.out.println("다시 입력하십시오.");
			bonusNumber = scan.nextInt();
		}
		return bonusNumber;
	}

	public static int matchCondition(Rank userNum, Rank lottoNum) {
		if (userNum.equals(lottoNum)) {
			return 1;
		}
		return 0;
	}

	public static int matchCount(List<Rank> rankList, Rank rank) {
		int count = 0;
		for (int i = 0; i < rankList.size(); ++i) {
			count += matchCondition(rankList.get(i), rank);
		}
		return count;
	}

	public static void printBonus(Rank rank) {
		if (rank == Rank.SECOND) {
			System.out.print(", 보너스 볼 일치");
			return;
		}
		System.out.print(" ");
	}

	public static void printResult(List<Rank> rankList, int myPrice) {
		int count = 0;
		int totalReward = 0;
		Rank[] rankTypes = Rank.values();
		for (int i = LOTTO_WINNING_MIN_COUNT + 1; i >= 0; --i) {
			Rank rank = rankTypes[i];
			count = matchCount(rankList, rank);
			System.out.print(rank.getCountOfMatch() + "개 일치");
			printBonus(rank);
			System.out.println("(" + rank.getWinningMoney() + "원) - " + count + "개");
			totalReward += count * rank.getWinningMoney();
		}
		System.out.println("총 수익률은" + (double) totalReward / myPrice + "입니다.");
	}
}
