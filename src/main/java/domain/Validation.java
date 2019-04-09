package domain;

import java.util.regex.Pattern;

public class Validation {

    private static final String PATTERN_NUMBER = "^[0-9]*$";
    private static final String MESSAGE_ERROR_INPUT_MONEY = "Error: 0보다 큰 숫자로 입력해 주세요";

    public static boolean isValidInputMoney(String money) {
        if (!Pattern.matches(PATTERN_NUMBER, money) || Integer.parseInt(money) < 0) {
            System.out.println(MESSAGE_ERROR_INPUT_MONEY);
            return false;
        }
        return true;
    }

}
