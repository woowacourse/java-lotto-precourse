package domain;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
	public static Scanner scan = new Scanner(System.in);
	public static final int LOTTO_NUM_LENGTH = 6;

	public static void main(String[] args) {
		int price = getPrice();
		int lottoCount = price / 1000;
		System.out.println(lottoCount + "개를 구매했습니다.");
		List<Lotto> lottoList = makeLottoList(lottoCount);

	}

	public static int getPrice() {
		System.out.println("구입 금액을 입력해 주세요.");
		int price = scan.nextInt();
		return price;
	}

	public static List<Integer> getRandomNumber() {
		List<Integer> randomNumber = new ArrayList<Integer>();
		for (int i = 0; i < LOTTO_NUM_LENGTH; i++) {
			randomNumber.add((int) (Math.random() * 45) + 1);
		}
		return randomNumber;
	}

	public static boolean isValid(List<Integer> randomNumber) {
		boolean result = false;
		for (int i = 0; i < LOTTO_NUM_LENGTH - 1; i++) {
			result |= (randomNumber.get(i) == randomNumber.get(i + 1));
		}
		return result;
	}

	public static List<Integer> makeLotto() {
		List<Integer> lottoNum;
		do {
			lottoNum = getRandomNumber();
			Collections.sort(lottoNum);
		} while (isValid(lottoNum));
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

}
