package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
 * 구입 금액을 입력 받아 로또를 생성하는 객체
 */
public class LottoGenerator {
	static final int EACH_LOTTO_PRICE = 1000;
	static final int MIN_LOTTO_NUMBER = 1;
	static final int MAX_LOTTO_NUMBER = 45;
	static final int LOTTO_NUMBER_COUNT = 6;
	Scanner scanner = new Scanner(System.in);
	Random random = new Random();

	public int get_LOTTO_NUMBER_COUNT() {
		return LOTTO_NUMBER_COUNT;
	}

	public int get_MIN_LOTTO_NUMBER() {
		return MIN_LOTTO_NUMBER;
	}

	public int get_MAX_LOTTO_NUMBER() {
		return MAX_LOTTO_NUMBER;
	}

	public int get_EACH_LOTTO_PRICE() {
		return EACH_LOTTO_PRICE;
	}

	public int getLottoCount(int lottoPrice) {
		return (lottoPrice / EACH_LOTTO_PRICE);
	}

	public List<Lotto> generateUserLottos() {
		int lottoPrice = inputLottoPriceFromUser();
		int lottoCount = getLottoCount(lottoPrice);
		List<Lotto> userLotts = generateLotto(lottoCount);
		printLottos(lottoCount, userLotts);
		return userLotts;
	}

	private int inputLottoPriceFromUser() {
		int lottoPrice;
		do {
			System.out.println("구입금액을 입력해 주세요.");
			lottoPrice = changeTypeStringToInt(scanner.next());
		} while (!validateLottoPrice(lottoPrice));
		return lottoPrice;
	}

	private int changeTypeStringToInt(String inputLottoPrice) {
		int lottoPrice;
		try {
			lottoPrice = Integer.parseInt(inputLottoPrice);
		} catch (NumberFormatException e) {
			// 구입금액이 정수가 아닐 경우, -1를 반환하여 1000원 이상이라는 조건을 만족하지 않음
			return -1;
		}
		return lottoPrice;
	}

	private boolean validateLottoPrice(int lottoPrice) {
		if (lottoPrice < EACH_LOTTO_PRICE || lottoPrice % EACH_LOTTO_PRICE != 0) {
			System.out.println("구입금액이 잘못 되었습니다.");
			return false;
		}
		return true;
	}

	private List<Integer> makeLottoNumbers() {
		List<Integer> lottoNumbers = new ArrayList<Integer>();
		while (lottoNumbers.size() < LOTTO_NUMBER_COUNT) {
			int randomNumber = random.nextInt(MAX_LOTTO_NUMBER) + MIN_LOTTO_NUMBER;
			if (!lottoNumbers.contains(randomNumber)) {
				lottoNumbers.add(randomNumber);
			}
		}
		return lottoNumbers;
	}

	private List<Lotto> generateLotto(int lottoCount) {
		List<Lotto> userLottos = new ArrayList<Lotto>();
		while (userLottos.size() < lottoCount) {
			Lotto newLotto = new Lotto(makeLottoNumbers());
			userLottos.add(newLotto);
		}
		return userLottos;
	}

	private void printLottos(int lottoCount, List<Lotto> userLottos) {
		System.out.println();
		System.out.println(lottoCount + "개를 구매했습니다.");
		for (int i = 0; i < lottoCount; i++) {
			System.out.println(userLottos.get(i).getNumbers());
		}
	}
}
