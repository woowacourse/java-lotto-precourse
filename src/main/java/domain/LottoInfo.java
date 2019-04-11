package domain;

public class LottoInfo {
    public static final int LOTTO_NUM_START = 1;
    public static final int LOTTO_NUM_END = 45;
    public static final int LOTTO_LENGTH = 6;

    public static boolean isLottoNum(int num) {
        return LottoInfo.LOTTO_NUM_START <= num && num <= LottoInfo.LOTTO_NUM_END;
    }
}
