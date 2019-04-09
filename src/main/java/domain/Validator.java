package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    static final String WARNING_WHEN_INPUT_IS_NOT_INTEGER = "WARNING: 정수만 입력 가능합니다. 다시 입력해주세요.";
    static final int MAX_POSSIBLE_LOTTO_INPUT_LENGTH = 10;
    static final String WARNING_WHEN_LOTTO_INPUT_COUNT_OVER = "WARNING: 입력이 너무 깁니다. " + MAX_POSSIBLE_LOTTO_INPUT_LENGTH + "자리 아래로 다시 입력해주세요.";
    static final String WARNING_WHEN_LOTTO_INPUT_SMALL = "WARNING: 금액이 너무 적습니다. 1장의 금액은 " + GameSetting.PRICE_PER_1LOTTO + "원 입니다. 다시 입력해주세요.";
    static final String WARNING_WHEN_LOTTO_NUMBER_COUNT_NOT_MATCHING = "WARNING: 로또넘버는 " + GameSetting.LOTTO_NORMAL_NUMBER_COUNT + "개 이어야 합니다. 다시 입력해주세요.";
    static final String WARNING_WHEN_LOTTO_NUMBER_NOT_IN_RANGE = "WARNING:" + GameSetting.MIN_LOTTO_NUMBER + "~" + GameSetting.MAX_LOTTO_NUMBER + " 의 숫자들만 가능합니다. 다시 입력해주세요.";
    static final String WARNING_WHEN_WINNING_LOTTO_NUMBER_HAS_DUPLICATION = "WARNING: 중복되는 숫자가 있으면 안됩니다. 다시 입력해주세요.";

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

    private static boolean checkIsInteger(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
            return true;
        } catch (Exception e) {
            System.out.println(WARNING_WHEN_INPUT_IS_NOT_INTEGER);
            return false;
        }
    }

    private static boolean checkInputLottoMoneyLengthIsTooLong(String lottoCountInput) {
        if (lottoCountInput.length() > MAX_POSSIBLE_LOTTO_INPUT_LENGTH) {
            System.out.println(WARNING_WHEN_LOTTO_INPUT_COUNT_OVER);
            return false;
        }
        return true;
    }

    private static boolean checkInputLottoMoneyIsUnderMinvalue(int inputMoney) {
        if (inputMoney < GameSetting.PRICE_PER_1LOTTO) {
            System.out.println(WARNING_WHEN_LOTTO_INPUT_SMALL);
            return true;
        }
        return false;
    }

    public static boolean checkWinningLottoNumbers(String winningLottoInput) {
        if (!checkLottoNumbersInputLengthIsValid(winningLottoInput)) {
            return false;
        }
        String[] numbers = winningLottoInput.split(",");
        if (checkDuplicationIfHasPrintWarning(numbers) ||
                !checkLottoNumbersInputHasNoInvalidValue(numbers)) {
            return false;
        }
        return true;
    }

    private static boolean checkLottoNumbersInputLengthIsValid(String winningLottoInput) {
        String[] numbers = winningLottoInput.split(",");

        if (numbers.length != GameSetting.LOTTO_NORMAL_NUMBER_COUNT) {
            System.out.println(WARNING_WHEN_LOTTO_NUMBER_COUNT_NOT_MATCHING);
            return false;
        }
        return true;
    }

    private static boolean checkLottoNumbersInputHasNoInvalidValue(String[] numbers) {
        boolean invalidValueNotFound = true;
        for (int i = 0; (i < numbers.length) && (invalidValueNotFound); i++) {
            invalidValueNotFound = checkIsLottoNumberValid(numbers[i]);
        }
        return invalidValueNotFound;
    }

    private static boolean checkDuplicationIfHasPrintWarning(String[] numbers) {
        // numbers에 중복된 문자열이 있었다면, numbers의 길이와 Set의 길이가 다름을 이용
        if (checkLottoNumbersHasDuplication(numbers)) {
            System.out.println(WARNING_WHEN_WINNING_LOTTO_NUMBER_HAS_DUPLICATION);
            return true;
        }
        return false;
    }

    private static boolean checkLottoNumbersHasDuplication(String[] numbers) {
        Set<String> tempAddedLottoNumbers = new HashSet<String>();

        for (int i = 0; (i < numbers.length); i++) {
            tempAddedLottoNumbers.add(numbers[i]);
        }
        if(tempAddedLottoNumbers.size() != numbers.length){
            return true;
        }
        return false;
    }

    public static boolean checkIsLottoNumberValid(String inputLottoNumber) {
        if (!checkIsInteger(inputLottoNumber)) {
            return false;
        }
        int inputNumberInt = Integer.parseInt(inputLottoNumber);
        if (!checkIsLottoNumberInRange(inputNumberInt)) {
            return false;
        }
        return true;
    }

    private static boolean checkIsLottoNumberInRange(int lottoInput) {
        if ((lottoInput < GameSetting.MIN_LOTTO_NUMBER) ||
                (lottoInput > GameSetting.MAX_LOTTO_NUMBER)) {
            System.out.println(WARNING_WHEN_LOTTO_NUMBER_NOT_IN_RANGE);
            return false;
        }
        return true;
    }

    public static boolean checkBonusLottoNumberValid(List<Integer> winningLottoNumbers, String bonusNumberStringInput) {
        if (!checkIsLottoNumberValid(bonusNumberStringInput)) {
            return false;
        }
        int bonusNumber = Integer.parseInt(bonusNumberStringInput);
        if (checkIsAlreadyInLottoNumbers(winningLottoNumbers, bonusNumber)) {
            return false;
        }
        return true;
    }

    private static boolean checkIsAlreadyInLottoNumbers(List<Integer> winningNumberList, int lottoInput) {
        if (winningNumberList.contains(lottoInput)) {
            System.out.println(WARNING_WHEN_WINNING_LOTTO_NUMBER_HAS_DUPLICATION);
            return true;
        }
        return false;
    }
}
