/*
 * Class: Validator.java
 * Version: 1.0
 * Date: 2019-04-09
 * Author: Kibaek Yoo
 */

package Controller;

import database.GameSetting;
import database.UserView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    /**
     * 입력금액 문자열 유효성 검사
     *
     * @param lottoCountInput
     * @return
     */
    public static boolean checkInputLottoMoney(String lottoCountInput) {
        if (!checkIsInteger(lottoCountInput)) {
            return false;
        }
        int inputMoney = Integer.parseInt(lottoCountInput);
        if (checkInputLottoMoneyIsUnderMinvalue(inputMoney)) {
            return false;
        }
        return true;
    }

    private static boolean checkInputLottoMoneyIsUnderMinvalue(int inputMoney) {
        if (inputMoney < GameSetting.PRICE_PER_1LOTTO) {
            System.out.println(UserView.WARNING_WHEN_LOTTO_INPUT_SMALL);
            return true;
        }
        return false;
    }

    /**
     * 당첨로또 문자열 유효성 검사
     *
     * @param winningLottoInput
     * @return
     */
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
            System.out.println(UserView.WARNING_WHEN_LOTTO_NUMBER_COUNT_NOT_MATCHING);
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
            System.out.println(UserView.WARNING_WHEN_WINNING_LOTTO_NUMBER_HAS_DUPLICATION);
            return true;
        }
        return false;
    }

    private static boolean checkLottoNumbersHasDuplication(String[] numbers) {
        Set<String> tempAddedLottoNumbers = new HashSet<String>();

        for (int i = 0; (i < numbers.length); i++) {
            tempAddedLottoNumbers.add(numbers[i]);
        }
        if (tempAddedLottoNumbers.size() != numbers.length) {
            return true;
        }
        return false;
    }

    /**
     * 보너스번호 문자열 유효성 검사
     *
     * @param winningLottoNumbers
     * @param bonusNumberStringInput
     * @return
     */
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
            System.out.println(UserView.WARNING_WHEN_WINNING_LOTTO_NUMBER_HAS_DUPLICATION);
            return true;
        }
        return false;
    }

    /**
     * 단일 로또넘버 문자열 유효성 검사
     *
     * @param inputLottoNumber
     * @return
     */
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

    private static boolean checkIsInteger(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
            return true;
        } catch (Exception e) {
            System.out.println(UserView.WARNING_WHEN_INPUT_IS_NOT_INTEGER);
            return false;
        }
    }

    private static boolean checkIsLottoNumberInRange(int lottoInput) {
        if ((lottoInput < GameSetting.MIN_LOTTO_NUMBER) ||
                (lottoInput > GameSetting.MAX_LOTTO_NUMBER)) {
            System.out.println(UserView.WARNING_WHEN_LOTTO_NUMBER_NOT_IN_RANGE);
            return false;
        }
        return true;
    }
}
