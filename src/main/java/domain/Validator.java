package domain;

public class Validator {

    static final String WARNING_WHEN_INPUT_IS_NOT_INTEGER = "WARNING: 정수만 입력 가능합니다. 다시 입력해주세요.";
    static final int MAX_POSSIBLE_LOTTO_INPUT_LENGTH = 10;
    static final String WARNING_WHEN_LOTTO_INPUT_COUNT_OVER = "WARNING: 입력이 너무 깁니다. " + MAX_POSSIBLE_LOTTO_INPUT_LENGTH + "자리 아래로 다시 입력해주세요.";
    static final String WARNING_WHEN_LOTTO_INPUT_SMALL = "WARNING: 금액이 너무 적습니다. 1장의 금액은 " + GameSetting.PRICE_PER_1LOTTO + "원 입니다. 다시 입력해주세요.";
    static final String WARNING_WHEN_LOTTO_NUMBER_COUNT_NOT_MATCHING = "WARNING: 로또넘버는 " + GameSetting.LOTTO_NORMAL_NUMBER_COUNT + "개 이어야 합니다. 다시 입력해주세요.";

    public static boolean checkInputLottoMoney(String lottoCountInput) {
        if (!checkInputLottoMoneyLengthIsTooLong(lottoCountInput) ||
                !checkIsInteger(lottoCountInput)) {
            return false;
        }
        int inputMoney = Integer.parseInt(lottoCountInput);
        if (checkInputLottoMoneyIsUnderMinvalue(inputMoney)) {
            return false;
        }
        return true;
    }

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

    public static boolean checkInputLottoMoneyIsUnderMinvalue(int inputMoney) {
        if (inputMoney < GameSetting.PRICE_PER_1LOTTO) {
            System.out.println(WARNING_WHEN_LOTTO_INPUT_SMALL);
            return true;
        }
        return false;
    }

    //
    public static boolean checkLottoNumbersInputLengthIsValid(String winningLottoInput) {
        String[] numbers = winningLottoInput.split(",");

        if (numbers.length != GameSetting.LOTTO_NORMAL_NUMBER_COUNT) {
            System.out.println(WARNING_WHEN_LOTTO_NUMBER_COUNT_NOT_MATCHING);
            return false;
        }
        return true;
    }
}
