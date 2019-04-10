package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class WinningLottoGenerator {
	
	// 당첨 번호 생성 함수
    private List<Integer> makeWinningNumber() {
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

    	return setForCheckDuplicate.size() == 6 ? true : false;
    }
    
    
    private boolean checkRange(List<Integer> numberList) {
    	boolean rightRange = true;
    	
    	for (int i = 0; i < numberList.size(); i++) {
    		rightRange = (numberList.get(i) >= 1 && numberList.get(i) <= 45 && rightRange == true) ? true : false;
    	}

    	return rightRange;
    }

}
