package com.codemcd.lotto;

public class InputError {

    private static final int MIN_LOTTO_PRICE = 1000;
    private static final int COUNT_OF_COMMA = 5;
    private static final int COUNT_OF_NUMBER = 6;
    private static final int ZERO = 0;
    private static final int ONE = 1;

    static String[] winningLottoNumber;

    public static String handleMoneyInputError(String input) {
        if (!isNumeric(input)) {
            return "<입력 오류> 숫자 입력이 아닙니다.";
        }
        if (!isNaturalNumber(input)) {
            return "<입력 오류> 자연수 입력이 아닙니다.";
        }
        if (!isMinimumPrice(input)) {
            return "<입력 오류> 로또의 최소 가격은 1,000원입니다. 그 이상의 금액을 입력해주세요";
        }
        return "";
    }

    public static String handleWinningLottoInputError(String input) {
        if (!isRightNumberOfComma(input)) {
            return "<입력 오류> 입력 형식에 맞지 않습니다.(쉼표 개수를 확인하세요.)";
        }
        if (!isRightNumber(input)) {
            return "<입력 오류> 알맞은 숫자 입력이 아닙니다.(1 ~ 45 사이의 숫자를 입력하세요.)";
        }
        if (!isOverlapNumber(input)) {
            return "<입력 오류> 중복된 로또 번호가 있습니다.";
        }
        winningLottoNumber = input.split(",");
        return "";
    }

    public static String handleBonusNumberInputError(String input) {
        if (!isNumeric(input)) {
            return "<입력 오류> 숫자 입력이 아닙니다.";
        }
        if (!isNaturalNumber(input)) {
            return "<입력 오류> 자연수 입력이 아닙니다.";
        }
        if (!isRightNumberOfRange(input)) {
            return "<입력 오류> 1 ~ 45 사이의 숫자를 입력하세요.";
        }
        if (!checkOverlapNumberZero(input)) {
            return "<입력 오류> 로또 번호와 중복된 보너스 번호입니다.";
        }
        return "";
    }

    private static boolean isRightNumberOfComma(String input) {
        int countOfComma = 0;
        for (int i = 0; i < input.length(); ++i) {
            countOfComma += (input.charAt(i) == ',') ? 1 : 0;
        }
        return (countOfComma == COUNT_OF_COMMA);
    }

    private static boolean isRightNumber(String input) {
        String[] number = input.split(",");
        int countOfRightNumber = 0;
        for (int i = 0; i < number.length; ++i) {
            countOfRightNumber += (isNumeric(number[i])
                    && isNaturalNumber(number[i])
                    && isRightNumberOfRange(number[i]))
                    ? 1 : 0;
        }
        return (countOfRightNumber == COUNT_OF_NUMBER);
    }

    private static boolean isRightNumberOfRange(String input) {
        int number = Integer.parseInt(input);
        return (number >= 1 && number <= 45);
    }

    private static boolean isOverlapNumber(String input) {
        String[] number = input.split(",");
        int countOfNotOverlapNumber = 0;
        for (int i = 0; i < number.length; ++i) {
            countOfNotOverlapNumber +=
                    (checkOverlapNumberOne(number, number[i]))
                            ? 1 : 0;
        }
        return (countOfNotOverlapNumber == COUNT_OF_NUMBER);
    }

    private static boolean checkOverlapNumberOne(String[] numbers, String checkNumber) {
        int countOfOverlap = 0;
        for (int i = 0; i < numbers.length; ++i) {
            countOfOverlap += (numbers[i].contains(checkNumber)) ? 1 : 0;
        }
        return (countOfOverlap == ONE);
    }

    private static boolean checkOverlapNumberZero(String checkNumber) {
        int countOfOverlap = 0;
        for (int i = 0; i < winningLottoNumber.length; ++i) {
            countOfOverlap += (winningLottoNumber[i].contains(checkNumber)) ? 1 : 0;
        }
        return (countOfOverlap == ZERO);
    }

    private static boolean isMinimumPrice(String input) {
        if (Integer.parseInt(input) < MIN_LOTTO_PRICE)
            return false;
        return true;
    }

    private static boolean isNaturalNumber(String input) {
        // 소수점이 있는 경우
        if (input.contains("."))
            return false;
        // 숫자 0이거나 0부터 시작하는 숫자인 경우
        if (input.charAt(0) == '0')
            return false;
        // 음수인 경우
        if (Integer.parseInt(input) < 0)
            return false;
        return true;
    }

    private static boolean isNumeric(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
