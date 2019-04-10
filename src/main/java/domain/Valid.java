package domain;

public class Valid {

    public static boolean isInputHasChar(String[] input) {
        try {
            for (int i = 0; i < input.length; i++)
                Integer.parseInt(input[i]);

        } catch (Exception e) {
            return true;
        }
        return false;
    }
    public static boolean isMinusInput(String input) {
        return Integer.parseInt(input) < 0;
    }
    public static boolean isOneMoreInput(String input) {
        if (input.contains(Message.SPOT) || input.contains(Message.SPACE) || input.contains(Message.TAB)) {
            return true;
        }
        return false;
    }
    public static boolean isRemainder(int money) {
        return (money % Const.ONE_LOTTO_MONEY) != 0;
    }

    public static boolean isSplitException(String winningNumbers) {
        try {
            winningNumbers.split(Message.SPOT);
        } catch (Exception e) {
            return true;
        }
        return false;
    }
    public static boolean isWrongSizeOfWinningNumbers(String winningNumbers) {
        return winningNumbers.split(Message.SPOT).length != Const.CREATE_LOTTO_NUMBER_TIME;
    }
    public static boolean isContainOutOfLottoScope(String[] winningNumbers) {
        boolean outOfScope = false;
        for (int i = 0; i < winningNumbers.length; i++) {
            outOfScope = outOfScope || isOutOfScope(Integer.parseInt(winningNumbers[i]));
        }

        return outOfScope;
    }

    public static boolean isOutOfScope(int number) {
        return !(number >= Const.MIN_LIMIT_LOTTO_NUMBER && number <= Const.MAX_LIMIT_LOTTO_NUMBER);
    }

}
