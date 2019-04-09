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
		Lotto winningNumber; 
		scan.nextLine();
		WinningLotto winLotto = new WinningLotto(winningNumber = new Lotto(scanWinningNumber()), scanBonusNumber(winningNumber));

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

	public static boolean isValid(List<Integer> temp) {
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
	
	public static List<Integer> getWinningNumber() {
		List<Integer> winningNumber = new ArrayList<Integer>();
		System.out.println("\n지난 추 당첨 번호를 입력해 주세요.");
		String[] input = scan.nextLine().split(",");
		
		for(int i=0; i<LOTTO_NUM_LENGTH; ++i) {
			winningNumber.add(Integer.parseInt(input[i]));
		}
		return winningNumber;
	}
	
	public static void printErrorMessage(int tryNum) {
		if(tryNum>0) {
			System.out.println("중복 숫자는 입력할 수 없습니다.");
		}
	}
	
	public static List<Integer> scanWinningNumber() {
		List<Integer> winningNumber;
		int tryNum=0;
		do {
			printErrorMessage(tryNum);
			winningNumber = getWinningNumber();
			Collections.sort(winningNumber);
			++tryNum;
		}while(isValid(winningNumber));
		
		return winningNumber;
	}
	
	
	public static boolean isAlready(Lotto winningNumber, int bonusNumber) {
		boolean result = false;
		for(int i=0; i<LOTTO_NUM_LENGTH; ++i) {
			result |= (winningNumber.getNumbers().get(i)==bonusNumber);
		}
		
		return result;
	}
	
	public static boolean isValidRange(int bonusNumber) {
		boolean result = false;
		if(bonusNumber>45||bonusNumber<1) {
			return true;
		}
		return false;
		
	}
	
	public static int scanBonusNumber(Lotto winningNumber) {
		System.out.println("보너스 볼을 입력해주세요.");
		int bonusNumber = scan.nextInt();
		while(isAlready(winningNumber, bonusNumber)||isValidRange(bonusNumber)) {
			System.out.println("1~45 범위내의 숫자가 아니거나 당첨 숫자와 중복됩니다.");
			System.out.println("다시 입력하십시오.");
			bonusNumber=scan.nextInt();
		}
		return bonusNumber;
	}


}
