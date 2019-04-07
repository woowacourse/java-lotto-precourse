package domain;

import java.util.Scanner;

public class Config {
    public final int INITIAL_VALUE = 0;
    public final int LOTTO_PRICE = 1000;
    public final int LOTTO_NUMBER_SIZE = 6;
    public final int LOTTO_MAX_VALUE = 45;
    public final int LOTTO_MIN_VALUE = 0;

    public Scanner resetScanner() {
        System.out.println("유효하지 않는 값입니다.");
        Scanner scan = new Scanner(System.in);
        return scan;
    }
}
