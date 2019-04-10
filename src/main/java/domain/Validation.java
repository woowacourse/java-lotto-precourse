/*
 * 이 클래스는 입력에 대한 검증을 하기 위한 클래스입니다.
 *
 * 클래스 이름    Validation
 * 버전 정보     1.0
 * 날짜    2019/04/11
 * 저작권   권유상
 */

package domain;

import java.util.regex.Pattern;
import java.util.List;
import java.util.ArrayList;

public class Validation {

    private static final String PATTERN_NUMBER = "^[0-9]*$";
    private static final String MESSAGE_ERROR_INPUT_MONEY = "Error: " + LottoGame.LOTTO_PRICE + "보다 큰 숫자로 입력해 주세요";
    private static final String MESSAGE_ERROR_INPUT_WINNING_LOTTO = "Error: (,)를 기준으로 올바른 숫자를 입력해 주세요";

    public static boolean isValidInputMoney(String money) {
        if (!Pattern.matches(PATTERN_NUMBER, money)
                || Integer.parseInt(money) < LottoGame.LOTTO_PRICE) {
            System.out.println(MESSAGE_ERROR_INPUT_MONEY);
            return false;
        }
        return true;
    }

    public static boolean isValidWinLottoInput(String str) {
        String[] winNumbers = str.split(",");
        if (!isValidWinNumberLength(winNumbers)
                || !isValidWinLottoNumber(winNumbers)
                || !isValidWinLottoDuplication(winNumbers)) {
            System.out.println(MESSAGE_ERROR_INPUT_WINNING_LOTTO);
            return false;
        }
        return true;
    }

    private static boolean isValidWinNumberLength(String[] str) {
        return str.length == LottoGame.LOTTO_NUMBER_COUNT;
    }

    private static boolean isValidWinLottoNumber(String[] str) {
        boolean valid = true;
        int idx = 0;
        while (valid && (idx < str.length)) {
            valid = isNumber(str[idx]);
            idx++;
        }
        return valid;
    }

    private static boolean isValidWinLottoDuplication(String[] str) {
        boolean valid = true;
        int idx = 0;
        List<String> check = new ArrayList<>();
        while (valid && (idx < str.length)) {
            valid = !check.contains(str[idx]);
            check.add(str[idx]);
            idx++;
        }
        return valid;
    }

    public static boolean isNumber(String number) {
        boolean correctNumber;
        try {
            correctNumber = isLottoNumber(Integer.parseInt(number));
        } catch (NumberFormatException e) {
            return false;
        }
        return correctNumber;
    }

    private static boolean isLottoNumber(int number) {
        return (number >= LottoGame.MIN_LOTTO_NUMBER) && (number <= LottoGame.MAX_LOTTO_NUMBER);
    }
}
