package domain;

import java.util.HashSet;
import java.util.Set;

public class InputException {

    private static final int LOTTO_SIZE = 6;
    private Set<String> checkBonus;

    private InputException() {
        checkBonus = new HashSet<>();
    }

    private static class InputExceptionHolder {
        public static final InputException INSTANCE = new InputException();
    }

    public static InputException getInstance() {
        return InputExceptionHolder.INSTANCE;
    }

    public boolean isMinusNumberException(String input){
        if (Integer.parseInt(input) < 0){
            System.out.println(ErrorMessage.HAS_MINUS_MESSAGE.getMessage());
            return true;
        }
        return false;
    }

    public boolean hasNumberOfChiperException(String input) {
        if (Integer.parseInt(input) % 1000 != 0) {
            System.out.println(ErrorMessage.HAS_NUMBER_OF_CHIPER_MESSAGE.getMessage());
            return true;
        }
        return false;
    }

    public boolean hasBlankException(String input){
        if (input.contains(" ") || "".equals(input)) {
            System.out.println(ErrorMessage.HAS_BLANK_MESSAGE.getMessage());
            return true;
        }
        return false;
    }

    public boolean isNumberFormatException(String input){
        char[] charArray = input.toCharArray();
        if(charArray[0] != 45){
            if(charArray[0] < 48 || charArray[0] > 57) {
                System.out.println(ErrorMessage.INPUT_MISS_MATCH_EXCEPTION_MESSAGE.getMessage());
                return true;
            }
        }
        for(int i = 1 ; i < charArray.length ; i++){
            if(charArray[i] < 48 || charArray[i] > 57) {
                System.out.println(ErrorMessage.INPUT_MISS_MATCH_EXCEPTION_MESSAGE.getMessage());
                return true;
            }
        }
        return false;
    }

    public boolean hasCheckLottoNumberException(String input){
        if(Integer.parseInt(input) < 1 || Integer.parseInt(input) > 45){
            System.out.println(ErrorMessage.OUT_OF_LOTTO_NUMBER_MESSAGE.getMessage());
            return true;
        }
        return false;
    }

    public boolean assignOverlapNumber(String[] inputNumber) {
        for (int i = 0; i < inputNumber.length; i++) {
            String compareNumber = inputNumber[i];
            if (checkOverlapNumber(compareNumber, inputNumber, i)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkOverlapNumber(String compareNumber, String[] inputNumber, int i) {
        for (int j = 0; j < i; j++) {
            if (compareNumber.equals(inputNumber[j])) {
                System.out.println(ErrorMessage.OVERLAP_NUMBER_MESSAGE.getMessage());
                return true;
            }
        }
        return false;
    }

    public boolean checkSizeWinningNumber(String[] inputNumber){
        if(inputNumber.length != LOTTO_SIZE){
            System.out.println(ErrorMessage.SIZELESS_WINNING_NUMBER_MESSAGE.getMessage());
            return true;
        }
        return false;
    }

    public boolean blankWinningLotto(String[] inputNumber) {
        for (String number : inputNumber) {
            if (number.length() != number.replaceAll(" ", "").length() || "".equals(number)) {
                System.out.println(ErrorMessage.HAS_BLANK_MESSAGE.getMessage());
                return true;
            }
        }
        return false;
    }

    public boolean checkRangeNumber(String[] inputNumber){
        for(String number : inputNumber){
            if(Integer.parseInt(number) < 1 || Integer.parseInt(number) > 45){
                System.out.println(ErrorMessage.OUT_OF_LOTTO_NUMBER_MESSAGE.getMessage());
                return true;
            }
            checkBonus.add(number);
        }
        return false;
    }

    public boolean checkNonNumber(String inputNumber){
        char[] charArray = inputNumber.toCharArray();
        for(char array : charArray){
            if(array == 44){
                continue;
            }
            if(array < 48 || array > 57) {
                System.out.println(ErrorMessage.OUT_OF_LOTTO_NUMBER_MESSAGE.getMessage());
                return true;
            }
        }
        return false;
    }

    public boolean overlapBonusNumber(String bonusNumber){
        if(checkBonus.contains(bonusNumber)){
            System.out.println(ErrorMessage.BONUS_NUMBER_OVERLAP_MESSAGE.getMessage());
            return true;
        }
        return false;
    }
}
