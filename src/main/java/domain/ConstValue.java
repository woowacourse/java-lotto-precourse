package domain;

public class ConstValue {

    /* 1,000 의 배수 */
    public static final String MULTIPLE_THOUSAND_PATTERNS = "^[0-9]+000$";

    /* 쉼표(, )로 구분된 6개의 수 */
    public static final String SIX_NUMBERS_DIVIDED_COMMA = "^([0-9]+,){5}[0-9]+$";

    public static final String NUMBER_PATTERNS = "^[0-9]+$";

    public static final int LOTTO_COUNT_SIZE = 6;

    public static final int MINIMUM_LOTTO_NUMBER = 1;

    public static final int MAXMUM_LOTTO_NUMBER = 45;
}
