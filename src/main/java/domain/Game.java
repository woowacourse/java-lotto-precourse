package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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
		Lotto rightLotto = inputRightLotto();
		int bonusNo = inputBonusNo(rightLotto);
		WinningLotto res = new WinningLotto(rightLotto, bonusNo);
		
		return res;
	}

	private int inputBonusNo(Lotto lotto) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("보너스 볼을 입력해 주세요.");
		String bonus = sc.nextLine();
		if (!checkEffectiveBonus(bonus,lotto)) {
			return inputBonusNo(lotto);
		}
		return Integer.parseInt(bonus);
	}

	private boolean checkEffectiveBonus(String bonus, Lotto lotto) {
		int bonusInt;
		
		if(!checkNumType(bonus)) {
			return false;
		}
		bonusInt = Integer.parseInt(bonus);
		if (!isDistinctValue(lotto,bonusInt) ||	!isRightLottoRange(bonusInt)) {
			return false;
		}
		return true;
	}

	private boolean isRightLottoRange(int number) {
		boolean res = number >= LOTTO_MIN && number <= LOTTO_MAX;
		
		if (!res) {
			System.out.println("유효하지 않는 입력값입니다.");
		}
		return res;
	}

	private boolean isDistinctValue(Lotto lotto, int bonusInt) {
		boolean result = !lotto.contains(bonusInt);
		if (!result) {
			System.out.println("로또 당첨번호와 같은 값은 입력할 수 없습니다.");
		}
		return result;
	}

	private Lotto inputRightLotto() {
		Scanner sc = new Scanner(System.in);
		System.out.println("지난주 당첨 번호를 입력해 주세요.");
		String numbers = sc.nextLine();

		if (!checkEffectiveLotto(numbers)) {
			return inputRightLotto();
		}
		Lotto lotto = new Lotto(convertStrToInt(numbers));
		return lotto;
	}

	private List<Integer> convertStrToInt(String numbers) {
		List<Integer> numList;
		try {
			numList = Arrays.stream(numbers.split(",")).
			mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
		} catch (Exception e) {
			numList = null;
		}
		return numList;
	}

	private boolean checkEffectiveLotto(String numbers) {
		List<Integer> numbersInt = convertStrToInt(numbers);
		if (numbers.charAt(numbers.length()-1) == ',' || numbersInt == null) {
			System.out.println("값과 구분자 ',' 사이 공백없이 제대로 입력해주세요.");
			return false;
		}
		if (!checkEffectivenumber(numbersInt)) {
			return false;
		}
		return true;
	}

	private boolean checkEffectivenumber(List<Integer> numbersInt) {
		if (numbersInt.size() != LOTTO_SIZE) {
			System.out.println("6개의 값을 제대로 입력해주세요.");
			return false;
		}
		if (!hasEffectiveValues(numbersInt) || 
				!hasDistinctValues(numbersInt)) {			
			return false;
		}
		return true;
	}

	private boolean hasDistinctValues(List<Integer> numbersInt) {
		int[] numsOfNumber = new int[LOTTO_MAX+1];
		int max = -1;
		
		for (int i = 0; i < numbersInt.size(); i++) {
			numsOfNumber[numbersInt.get(i)] ++;
		}
		for (int i = 1; i < numsOfNumber.length; i++) {
			max = Math.max(max, numsOfNumber[i]);
		}
		return isValue1(max);
	}

	private boolean isValue1(int max) {
		boolean result = (max ==1);
		if (!result) {
			System.out.println("입력한 값 중, 중복 된 값이 존재합니다.");
		}
		return result;
	}

	private boolean hasEffectiveValues(List<Integer> numbersInt) {
		int max = -1;
		int min = 99;
		for (int i = 0; i < numbersInt.size(); i++) {
			max = Math.max(max, numbersInt.get(i));
			min = Math.min(min, numbersInt.get(i));
		}
		if (max > LOTTO_MAX || min < LOTTO_MIN) {
			System.out.println("입력한 값 중, 유효하지 않은 값이 있습니다.");
		}
		return (max <= LOTTO_MAX) && (min >= LOTTO_MIN); 
	}

	private List<Lotto> makeLotto() {
		List<Lotto> res = new ArrayList<Lotto>();
		int price = inputPrice();
		int size = price/LOTTO_PRICE;
		System.out.println("\n"+size+"개를 구매했습니다.");
		
		for (int i = 0; i < size; i++) {
			res.add(genLottoNumber());
			res.get(i).printNumbers();
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
