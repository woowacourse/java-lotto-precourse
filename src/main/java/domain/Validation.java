package domain;

import java.util.regex.Pattern;
import java.util.List;
import java.util.ArrayList;

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

    public static boolean isValidWinLottoInput(String str) {
        String[] winNum = str.split(",");
        List<String> temp = new ArrayList<>();
        if (!isValidWinNumberLength(winNum)) {
            System.out.println("길이 오류");
            return false;
        }
        if (!isValidWinLottoNumber(winNum)) {
            System.out.println("숫자 오류");
            return false;
        }
        for (String num : winNum) {
            if (temp.contains(num)) {
                System.out.println("중복오류");
                return false;
            }
            temp.add(num);
        }

        return true;
    }

    private static boolean isValidWinNumberLength(String[] str) {
        return str.length == LottoGame.LOTTO_NUMBER_COUNT;
    }

    private static boolean isValidWinLottoNumber(String[] str) {
        boolean finish = true;
        int idx = 0;
        while (finish && (idx < str.length)) {
            finish = isNumber(str[idx]);
            idx++;
        }

        return finish;
    }

    private static boolean isNumber(String str) {
        try {
            int num = Integer.parseInt(str);
            if (num < 1 || num > 45) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
