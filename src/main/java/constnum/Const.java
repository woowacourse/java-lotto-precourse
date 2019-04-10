package constnum;

public class Const {
    public static final int ZERO = 0;

    public static final int PRICE_OF_SINGLE_LOTTO = 1000;

    public static final int MIN_PRICE_OF_LOTTO_BUY = PRICE_OF_SINGLE_LOTTO;
    public static final int MAX_PRICE_OF_LOTTO_BUY = 100000;

    public static final int MIN_NUM_OF_LOTTO_TO_SELECT = 1;
    public static final int MAX_NUM_OF_LOTTO_TO_SELECT = 45;

    public static final int LOTTO_NUM_CNT = 6;

    public static final String STR_ENTER_PAYMENT_TO_USER = "구매 금액을 입력해 주세요.\n(예 : 8000)";
    public static final String STR_NOTI_PAYMENTLOTTO_AMT = "개를 구매했습니다.";
    public static final String STR_ENTER_LAST_WIN_NUMBRES = "지난 주 당첨 번호를 입력해 주세요.\n(예: 1,2,3,4,5,6)";
    public static final String STR_ENTER_LAST_WIN_BONUS = "보너스 볼을 입력해 주세요.";

    public static final String EX_PAYMENT_ONLY_NUM_TO_USER = "띄어쓰기 없이 숫자만 입력해주세요.";
    public static final String EX_PAYMENT_CONDITION_TO_USER = "최소 구매 금액은 1000원, 최대 구매 금액은 10만원 입니다.";
    public static final String EX_WIN_ONLY_NUM_TO_USER = "띄어쓰기 없이 숫자만 입력해주세요.";
    public static final String EX_LOTTO_CONDITION_TO_USER = "1 ~ 45 사이의 숫자만 입력해주세요.";
    public static final String EX_WIN_NOT_OVERLAP_TO_USER = "중복되지 않는 숫자만 입력하세요.";
    public static final String EX_WIN_CNT_CONDITION_TO_USER = "로또 당첨 번호는 6개입니다. 다시 입력하세요.";
    public static final String EX_BONUS_ONLY_NUM_TO_USER = "숫자 하나만 입력해주세요";
    public static final String EX_BONUS_NOT_OVERLAP_TO_USER = "당첨 번호와 중복되지 않는 번호를 입력하세요.";

    public static final String RESULT_TITLE = "\n당첨 통계";
    public static final String RESULT_BAR = "---------";
    public static final String RESULT_RANK_STR_MATCH_COUNT = "개 일치";
    public static final String RESULT_RANK_STR_ROUND = " (";
    public static final String RESULT_RANK_STR_BONUS = ", 보너스볼 일치";
    public static final String RESULT_RANK_STR_PRIZE = "원) - ";
    public static final String RESULT_PRIZE_PERCENT_FRONT = "총 수익률은 ";
    public static final String RESULT_PRIZE_PERCENT_BACK = " 입니다.";

}
