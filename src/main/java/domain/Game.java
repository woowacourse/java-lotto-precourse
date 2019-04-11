package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {
	static final int LOTTO_MIN = 1;
	static final int LOTTO_MAX = 45;
	static final int LOTTO_SIZE = 6;
	static final int LOTTO_PRICE = 1000;
	
	private List<Lotto> lottoList;
	private WinningLotto winningNumbers;
	
	public void start() {
		lottoList = makeLotto();
		winningNumbers = checkLastLotto();
		HashMap<Rank, Integer> result = collectLottoResult(lottoList,winningNumbers);
		showResult(result);
	}

	private void showResult(HashMap<Rank, Integer> result) {
		// TODO Auto-generated method stub
		
	}

	private HashMap<Rank, Integer> collectLottoResult(List<Lotto> lottoList2, WinningLotto winningNumbers2) {
		// TODO Auto-generated method stub
		return null;
	}

	private WinningLotto checkLastLotto() {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Lotto> makeLotto() {
		List<Lotto> res = new ArrayList<Lotto>();
		int price = inputPrice();
		int size = price/LOTTO_PRICE;
		System.out.println("\n"+size+"개를 구매했습니다.");
		
		for (int i = 0; i < size; i++) {
			res.add(genLottoNumber());
			//res.get(i).printNumbers();
		}
		
		return res;
	}

	private Lotto genLottoNumber() {
		List<Integer> lottoNumbers = new ArrayList<Integer>();
		LinkedList<Integer> numberList = generateNumList();
		for (int i = 0; i < LOTTO_SIZE; i++) {
			int randIdx = (int) (Math.random()*numberList.size());
			int value = numberList.remove(randIdx);
			lottoNumbers.add(value);
		}
		lottoNumbers.sort(null);
		Lotto lotto = new Lotto(lottoNumbers);
		return lotto;
	}

	private LinkedList<Integer> generateNumList() {
		LinkedList<Integer> numList = new LinkedList<Integer>();
		for (int i = LOTTO_MIN; i <= LOTTO_MAX; i++) {
			numList.add(i);
		}
		return numList;
	}

	private int inputPrice() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("구입금액을 입력해주세요.");
		String price = sc.nextLine();

		if (!checkEffectivePrice(price)) {
			return inputPrice();
		}
		return Integer.parseInt(price);
	}

	private boolean checkEffectivePrice(String price) {
		if (!checkNumType(price)||!checkPricesize(price)) {			
			return false;
		}
		checkHasRemainder(Integer.parseInt(price));
		return true;
	}

	private void checkHasRemainder(int price) {
		int remainder = price%LOTTO_PRICE;
		
		if (remainder != 0) {
			System.out.println("잔돈"+remainder+"원을 제외한 금액으로 구매합니다.");
		}
	}

	private boolean checkPricesize(String price) {
		boolean res = true;
		int priceInt = Integer.parseInt(price);
		
		if (priceInt < LOTTO_PRICE) {
			System.out.println("금액이 모자랍니다.");
			res = false;
		}
		return res;
	}

	private boolean checkNumType(String num) {
		int priceInt;
		
		try {
			priceInt = Integer.parseInt(num);
		} catch (NumberFormatException e) {
			System.out.println("입력한 값이 숫자가 아닙니다.");
			return false;
		}
		return true;
	}
}
