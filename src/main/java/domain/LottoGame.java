package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class LottoGame {
	static private Scanner sc = new Scanner(System.in);
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
	
	private boolean checkNumberOrNot(String strNumber) {
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
		return money / 1000;
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
    
    private ArrayList<Lotto> makeLotto() {
    	ArrayList<Lotto> lottoList = new ArrayList<Lotto>();
    	int money = inputMoney();
    	
    	for (int i = 0; i < purchaseLottoAmount(money); i++) {
    		lottoList.add(new Lotto(makeLottoNumberList()));
    	}

    	System.out.println("\n" + lottoList.size() + "개를 구매했습니다.");
    	
    	return lottoList;
    }

    
    private List<String> inputWinningNumber() {
    	String winningNumber = "";
    	List<String> splitedNumber = new ArrayList<>();
    	
    	do {
    		System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
    		winningNumber = sc.nextLine();
    		splitedNumber = splitStringByComma(winningNumber);
    	} while (!checkContainNotNumber(splitedNumber));
    	
    	return splitedNumber;
    }
    
    
    private List<Integer> checkValidation() {
    	List<String> splitedNumber = new ArrayList<>();
      	List<Integer> intWinningNumberList = new ArrayList<Integer>();
      	
    	do {
    		splitedNumber = inputWinningNumber();
    		intWinningNumberList = convertToIntList(splitedNumber);
    	} while (!(checkDuplicate(intWinningNumberList) && checkRange(intWinningNumberList)));
 
    	return intWinningNumberList;
    }
    
    private List<String> splitStringByComma(String winningNumber) {
    	String[] winningNumberArray = winningNumber.split(",");
    	List<String> splitedNumber = new ArrayList<String>();
    	
    	for (int i = 0; i < winningNumberArray.length; i++) {
    		splitedNumber.add(winningNumberArray[i].trim());
    	}
    	
    	return splitedNumber;
    }
    
    private boolean checkContainNotNumber(List<String> splitedNumberList) {
    	boolean containNotNumber = true;
    	
    	for (int i = 0; i < splitedNumberList.size(); i++) {
    		containNotNumber = (Pattern.matches(NUMBER_CHECK_REGEX, splitedNumberList.get(i)) && containNotNumber == true) ? true : false;
    	}
    	
    	return containNotNumber;
    }
    
    private List<Integer> convertToIntList(List<String> splitedNumberList) {
    	List<Integer> intWinningNumberList = new ArrayList<Integer>();
    	
    	for (int i = 0; i < splitedNumberList.size(); i++) {
    		intWinningNumberList.add(Integer.parseInt(splitedNumberList.get(i)));
    	}
    	
    	return intWinningNumberList;
    }
    
    private boolean checkDuplicate(List<Integer> splitedNumberList) {
    	HashSet<Integer> setForCheckDuplicate = new HashSet<Integer>(splitedNumberList);

    	return setForCheckDuplicate.size() == 6 ? true : false;
    }
    
    
    private boolean checkRange(List<Integer> numberList) {
    	boolean rightRange = true;
    	
    	for (int i = 0; i < numberList.size(); i++) {
    		rightRange = (numberList.get(i) >= 1 && numberList.get(i) <= 45 && rightRange == true) ? true : false;
    	}

    	return rightRange;
    }
    
    
    private int setBonusBall(List<Integer> winningNumber) {
    	String bonusBall = "";
    	
    	do {
    		System.out.println("보너스 볼을 입력해 주세요.");
    		bonusBall = sc.nextLine().trim();
    	} while (!validateBonusBall(bonusBall, winningNumber));

    	return Integer.parseInt(bonusBall);
    }
    
    private boolean validateBonusBall(String bonusBall, List<Integer> winningNumber) {
    	int intBonusBall = 0;
    	
    	if (checkNumberOrNot(bonusBall)) {
    		intBonusBall = Integer.parseInt(bonusBall);
    		return (checkRange(intBonusBall) && !checkContained(winningNumber, intBonusBall)) ? true : false;
    	}
    	
    	return false;
    }
    
    private boolean checkRange(int bonusBall) {
    	boolean inRange = (bonusBall > 0 && bonusBall < 46) ? true : false;
    	
    	if (!inRange) {
    		System.out.println("1부터 45까지의 숫자를 입력하세요.");
    		return inRange;
    	}

    	return inRange;
    }
    
    private boolean checkContained(List<Integer> winningNumber, int bonusBall) {
    	boolean isContained = winningNumber.contains(bonusBall);

    	if (isContained) {
    		System.out.println("당첨 번호와 중복되지 않는 값을 입력하세요.");
    		return isContained;
    	}
    	
    	return isContained;
    }
    
   
    
    public static void main(String[] args) {
    	// test용 main 함수
		LottoGame lg = new LottoGame();
		ArrayList<Lotto> lottos = lg.makeLotto();
		for (int i = 0; i < lottos.size(); i++) {
			System.out.println(lottos.get(i).toString());
		}
		
		List<Integer> winNum = lg.checkValidation();
		
		System.out.println(winNum.toString());
		System.out.println(lg.setBonusBall(winNum));
	}
    
}