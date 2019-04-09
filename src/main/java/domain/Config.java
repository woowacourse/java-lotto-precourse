package domain;

import java.util.Scanner;

/**
 * 다른 클래스에서 공통으로 사용하는 변수와 메소드를 담은 class
 */
public class Config {
    public static final int INITIAL_VALUE = 0;
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final int LOTTO_MAX_VALUE = 45;
    public static final int LOTTO_MIN_VALUE = 0;

    public static Scanner resetScanner() {
        System.out.println("유효하지 않는 값입니다.");
        Scanner scan = new Scanner(System.in);
        return scan;
    }
}
