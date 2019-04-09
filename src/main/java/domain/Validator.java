package domain;

public class Validator {

    static final String WARNING_WHEN_INPUT_IS_NOT_INTEGER = "WARNING: 정수만 입력 가능합니다. 다시 입력해주세요.";
    static final int MAX_POSSIBLE_LOTTO_INPUT_LENGTH = 10;
    static final String WARNING_WHEN_LOTTO_INPUT_COUNT_OVER = "WARNING: 입력이 너무 깁니다. " + MAX_POSSIBLE_LOTTO_INPUT_LENGTH + "자리 아래로 다시 입력해주세요.";

    public static boolean checkIsInteger(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
            return true;
        } catch (Exception e) {
            System.out.println(WARNING_WHEN_INPUT_IS_NOT_INTEGER);
            return false;
        }
    }

    public static boolean checkInputLottoMoneyLengthIsTooLong(String lottoCountInput) {
        if (lottoCountInput.length() > MAX_POSSIBLE_LOTTO_INPUT_LENGTH) {
            System.out.println(WARNING_WHEN_LOTTO_INPUT_COUNT_OVER);
            return false;
        }
        return true;
    }
}
