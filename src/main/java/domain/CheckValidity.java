package domain;

import java.util.List;

class CheckValidity {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    boolean checkIntegerFormat(String numberStr) {
        try {
            Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    boolean checkLottoNumberScope(int number) {
        return !((number < MIN_NUMBER) || (MAX_NUMBER < number));
    }

    boolean checkDouble(List<Integer> numArr, int number) {
        return numArr.contains(number);
    }
}
