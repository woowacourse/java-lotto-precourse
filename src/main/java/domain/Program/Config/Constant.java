package domain.Program.Config;

public interface Constant {
    final static int PRICE_MAX = Integer.MAX_VALUE;
    final static int PRICE_MIN = 0;
    final static int LOTTO_PRICE = 1000;
    final static int LOTTO_MAX = 45;
    final static int LOTTO_MIN = 1;
    final static String LOTTO_REGEX_PIECE = "([1-9]{1}|[1-3]{1}[0-9]{1}|4{1}[0-5]{1})";
    final static String LOTTO_REGEX_CHECK =
            LOTTO_REGEX_PIECE+","+LOTTO_REGEX_PIECE+","+LOTTO_REGEX_PIECE+","+
                    LOTTO_REGEX_PIECE+","+LOTTO_REGEX_PIECE+","+LOTTO_REGEX_PIECE;
}
