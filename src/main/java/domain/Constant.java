package domain;

public class Constant {

    /* 1,000 의 배수 */
    public static final String MULTIPLE_THOUSAND_PATTERNS = "^[0-9]+000$";

    /* 쉼표(, )로 구분된 6개의 수 */
    public static final String SIX_NUMBERS_DIVIDED_COMMA_PATTERNS = "^([0-9]+,){5}[0-9]+$";

    public static final String BONUS_NUMBER_PATTERNS = "^[0-9]+$";

    public static final int LOTTO_NUMBER_SIZE = 6;

    public static final int MINIMUM_LOTTO_NUMBER = 1;

    public static final int MAXIMUM_LOTTO_NUMBER = 45;

    /* 금액 <-> 수량 변환 단위 */
    public static final int CONVERSION_LOTTO_AND_PRICE = 1000;
}
