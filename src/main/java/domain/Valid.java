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

}
