package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author soojin
 *
 * 지난주 당첨 로또를 생성하는 클래스입니다.
 */
public class WinningLottoGenerator {
	private static final String NUMBER_CHECK_REGEX = "^[0-9]+$";
	private static final int LOTTO_MINIMUM_NUMBER = 0;
	private static final int LOTTO_MAXIMUM_NUMBER = 45;
	private static final int MAXIMUM_SIZE = 6;
	
	LottoGenerator lg = new LottoGenerator();
	Scanner sc = new Scanner(System.in);
	
	/** 당첨 번호 생성 함수 */
    public List<Integer> makeWinningNumber() {
    	List<String> splitedNumber = new ArrayList<>();
      	List<Integer> intWinningNumberList = new ArrayList<Integer>();
      	
    	do {
    		splitedNumber = inputWinningNumber();
    		intWinningNumberList = convertToIntList(splitedNumber);
    	} while (!(checkDuplicate(intWinningNumberList) && checkRange(intWinningNumberList)));
 
    	return intWinningNumberList;
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
    	
    	return (setForCheckDuplicate.size() == MAXIMUM_SIZE && splitedNumberList.size() == MAXIMUM_SIZE) ? true : false;
    }
    
    
    private boolean checkRange(List<Integer> numberList) {
    	boolean rightRange = true;
    	
    	for (int i = 0; i < numberList.size(); i++) {
    		rightRange = (numberList.get(i) >= LOTTO_MINIMUM_NUMBER && numberList.get(i) <= LOTTO_MAXIMUM_NUMBER && rightRange == true) ? true : false;
    	}

    	return rightRange;
    }
    
    /** 보너스 번호 생성 함수 */
    public int makeBonusNumber(List<Integer> winningNumber) {
    	String bonusNumber = "";
    	
    	do {
    		System.out.println("보너스 볼을 입력해 주세요.");
    		bonusNumber = sc.nextLine().trim();
    	} while (!validateBonusBall(bonusNumber, winningNumber));

    	return Integer.parseInt(bonusNumber);
    }
    
    private boolean validateBonusBall(String bonusNumber, List<Integer> winningNumber) {
    	int intBonusNumber = 0;

    	if (lg.checkNumberOrNot(bonusNumber)) {
    		intBonusNumber = Integer.parseInt(bonusNumber);
    		return (checkRange(intBonusNumber) && !checkContained(winningNumber, intBonusNumber)) ? true : false;
    	}
    	
    	return false;
    }
    
    private boolean checkRange(int bonusNumber) {
    	boolean inRange = (bonusNumber >= LOTTO_MINIMUM_NUMBER && bonusNumber <= LOTTO_MAXIMUM_NUMBER) ? true : false;
    	
    	if (!inRange) {
    		System.out.println("1부터 45까지의 숫자를 입력하세요.");
    		return inRange;
    	}

    	return inRange;
    }
    
    private boolean checkContained(List<Integer> winningNumber, int bonusNumber) {
    	boolean isContained = winningNumber.contains(bonusNumber);

    	if (isContained) {
    		System.out.println("당첨 번호와 중복되지 않는 값을 입력하세요.");
    		return isContained;
    	}
    	
    	return isContained;
    }
}