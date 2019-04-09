package domain;

public class Validator {

    static final String WARNING_WHEN_INPUT_IS_NOT_INTEGER = "WARNING: 정수만 입력 가능합니다. 다시 입력해주세요.";

    public static boolean checkIsInteger(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
            return true;
        } catch (Exception e) {
            System.out.println(WARNING_WHEN_INPUT_IS_NOT_INTEGER);
            return false;
        }
    }
}
