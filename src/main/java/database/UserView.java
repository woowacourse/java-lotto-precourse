package database;

public class UserView {

    public static final String COMMENT_WHEN_RECEIVE_INPUT_MONEY = "구입금액을 입력해 주세요.";
    public static final String COMMENT_WHEN_GET_WINNING_LOTTO_NUMBERS_FROM_USER = "지난 주 당첨 번호를 입력해주세요.";
    public static final String COMMENT_WHEN_GET_BONUS_NUMBER_FROM_USER = "보너스 볼을 입력해 주세요.";
    public static final String WARNING_WHEN_INPUT_IS_NOT_INTEGER = "WARNING: 정수만 입력 가능합니다. 다시 입력해주세요.";
    public static final int MAX_POSSIBLE_LOTTO_INPUT_LENGTH = 10;
    public static final String WARNING_WHEN_LOTTO_INPUT_COUNT_OVER = "WARNING: 입력이 너무 깁니다. " + MAX_POSSIBLE_LOTTO_INPUT_LENGTH + "자리 아래로 다시 입력해주세요.";
    public static final String WARNING_WHEN_LOTTO_INPUT_SMALL = "WARNING: 금액이 너무 적습니다. 1장의 금액은 " + GameSetting.PRICE_PER_1LOTTO + "원 입니다. 다시 입력해주세요.";
    public static final String WARNING_WHEN_LOTTO_NUMBER_COUNT_NOT_MATCHING = "WARNING: 로또넘버는 " + GameSetting.LOTTO_NORMAL_NUMBER_COUNT + "개 이어야 합니다. 다시 입력해주세요.";
    public static final String WARNING_WHEN_LOTTO_NUMBER_NOT_IN_RANGE = "WARNING:" + GameSetting.MIN_LOTTO_NUMBER + "~" + GameSetting.MAX_LOTTO_NUMBER + " 의 숫자들만 가능합니다. 다시 입력해주세요.";
    public static final String WARNING_WHEN_WINNING_LOTTO_NUMBER_HAS_DUPLICATION = "WARNING: 중복되는 숫자가 있으면 안됩니다. 다시 입력해주세요.";

}
