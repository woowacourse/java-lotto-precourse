package domain;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class LottoMarket {

	private static final Scanner SCANNER = new Scanner(System.in);
	private static final Random RANDOM = new Random();
	private static final String PURCHASE_PRICE_MESSAGE = "구입 금액을 입력해 주세요.";
	private static final String CHANGES_MESSAGE = "잔돈 : ";
	private static final String PURCHASE_MESSAGE = "\n%d개를 구매했습니다.\n";
	private static final int LOTTO_PAY = 1000;
	private static final int MAX_LOTTO_NUM = 45;
	private static final int MAX_LOTTO_SIZE = 6;

	private int purchasePrice;
	public ArrayList<Lotto> lottoList = new ArrayList<Lotto>();

	public int getPurchasePrice() {
		return this.purchasePrice; //나중에 수익률을 계산하기 위해 getter 생성
	}

	private void inputPurchasePrice() {
		System.out.println(PURCHASE_PRICE_MESSAGE);
		purchasePrice = SCANNER.nextInt();
		int changes = purchasePrice % LOTTO_PAY;
		if (changes != 0) {
			System.out.println(CHANGES_MESSAGE + changes);
			purchasePrice -= changes;
		}
	}

	private ArrayList<Integer> makeLottoNumbers() {
		SortedSet<Integer> lottoNumberSet = new TreeSet<Integer>();
		ArrayList<Integer> lottoNumberList = new ArrayList<Integer>();

		while (lottoNumberSet.size() < MAX_LOTTO_SIZE) {
			int randomlottoNumber = RANDOM.nextInt(MAX_LOTTO_NUM) + 1;
			lottoNumberSet.add(randomlottoNumber);
		}
		lottoNumberList.addAll(lottoNumberSet);
		return lottoNumberList;
	}
	
	private void makeLottoList(int lottoCount) {
		for (int num = 0; num < lottoCount; num++) {
			ArrayList<Integer> lottoNumbers = makeLottoNumbers();
			Lotto newLotto = new Lotto(lottoNumbers);
			lottoList.add(newLotto);
		}
	}
	
	public void purchaseLotto() {
		inputPurchasePrice();
		int lottoCount = purchasePrice / LOTTO_PAY;
		System.out.printf(PURCHASE_MESSAGE, lottoCount);
		makeLottoList(lottoCount);
		
		for (Lotto lotto : lottoList) {
			lotto.printNumbers();
		}
	}
	
	/* 테스트 코드 */
	public static void main(String[] args) {
		LottoMarket lottoMarket = new LottoMarket();
		lottoMarket.purchaseLotto();
	}
}
