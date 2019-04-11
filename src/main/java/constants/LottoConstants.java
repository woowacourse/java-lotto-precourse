package constants;

public class LottoConstants {
    public static final String COUNT_ERROR_MESSAGE = "로또는 6개의 숫자가 필요합니다.";
    public static final String SAME_NUMBER_ERROR_MESSAGE = "로또는 6개의 숫자가 필요합니다.";
    public static final int LOTTO_PRICE = 1000;
    public static final String PRICE_ERROR_MESSAGE = "로또는 " + LOTTO_PRICE + "원 단위로 구매 할 수 있습니다.";
    public static final String ZERO_ERROR_MESSAGE = "로또는 최소한 1장을 구매해야 합니다.";
    public static final int COUNT_NUMBERS = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final String BONUS_NUMBER_ERROR = "보너스 넘버는 로또 번호와 중복될 수 없습니다.";

    private LottoConstants() {
    }
}
