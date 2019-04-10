package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class LottoGenerator {
	
	static private  Scanner sc = new Scanner(System.in);
	static private final String NUMBER_CHECK_REGEX = "^[0-9]+$";
	static private final int LOTTO_PRICE = 1000;
	static private final int LOTTO_BUY_LIMIT = 100000;
    static private final double LOTTO_TOTAL_NUMBER = 45;
	static private final int LOTTO_MAXIMUM_COUNT = 6;
	
	private int inputMoney() {
		String money = "0";
		
		do {
			System.out.println("구매금액을 입력해 주세요.");
			money = sc.nextLine().trim();
		} while(!checkNumberOrNot(money) || !devideByThousand(money));

		return Integer.parseInt(money);
	}
	
	public boolean checkNumberOrNot(String strNumber) {
		if (Pattern.matches(NUMBER_CHECK_REGEX, strNumber)) {
			return true;
		}
		
		System.out.println("0 이상의 숫자를 입력해주세요.");
		return false;
		
	}
	
	private boolean devideByThousand(String money) {
		if (Integer.parseInt(money) % LOTTO_PRICE != 0 || Integer.parseInt(money) > LOTTO_BUY_LIMIT) {
			System.out.println("100,000이하의 금액을 1,000원 단위로 입력해주세요.");
			return false;
		}
		return true; 
	}
	
	private int purchaseLottoAmount(int money) {
		return money / LOTTO_PRICE;
	}
	
	private int makeRandomNumber() {
    	int randomNumber = 0;
    	randomNumber = (int) (Math.random() * LOTTO_TOTAL_NUMBER) + 1;
    	return randomNumber;
    }
	
    private List<Integer> makeLottoNumberList() {
    	Set<Integer> lottoNumberList = new HashSet<Integer>();
    	
    	while (lottoNumberList.size() < LOTTO_MAXIMUM_COUNT) {
    		lottoNumberList.add(makeRandomNumber());
    	}
    	
    	List<Integer> numbers = new ArrayList<Integer>(lottoNumberList);
    	
    	return numbers;
    }
    
    // 로또 생성 함수
    public ArrayList<Lotto> makeLotto() {
    	ArrayList<Lotto> lottoList = new ArrayList<Lotto>();
    	int money = inputMoney();
    	
    	for (int i = 0; i < purchaseLottoAmount(money); i++) {
    		lottoList.add(new Lotto(makeLottoNumberList()));
    	}

    	System.out.println("\n" + lottoList.size() + "개를 구매했습니다.");
    	
    	return lottoList;
    }

}
