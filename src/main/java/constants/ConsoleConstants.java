package constants;

public class ConsoleConstants {

    public static final String START_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBERS_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";
    public static final String BONUS_NUMBERS_MESSAGE = "보너스 볼을 입력해 주세요.";
    public static final String BUYING_MESSAGE = "개를 구매했습니다.";
    public static final String ENTER = "\n";
    public static final String REGEX_FOR_MONEY = "\\D";
    public static final String REGEX_FOR_WINNING_NUMBER= "[^\\d^,]";
    public static final String SEPARATOR = ",";
    public static final String RESULT_MASSAGE = "\n당첨통계\n----------";
    public static final String RESULT_MATCH_COUNT = "개 일치 ";
    public static final String RESULT_BONUS = ", 보너스 볼 일치 ";
    public static final String RESULT_OPEN_BRACKET = "(";
    public static final String RESULT_WON = "원";
    public static final String RESULT_CLOSE_BRACKET = ") - ";
    public static final String RESULT_COUNT = "개";
    public static final String RESULT_RATE_MESSAGE = "총 수익률은 ";
    public static final String RESULT_RATE_END_MESSAGE = "입니다.";

    private ConsoleConstants() {
    }
}
