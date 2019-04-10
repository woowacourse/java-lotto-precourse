package domain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp {
    static final int MIN_VALID_MONEY_TO_BUY_LOTTO = 1000;
    static final int LOTTO_PRICE = 1000;


    public static void main(String[] args) {
    }


    /**
     * 사용자가 입력한 로또 구입 금액이 적절한지 판단하는 메소드
     */
    public static boolean isValidMoneyToBuyLotto(int money) {
        return ((money >= MIN_VALID_MONEY_TO_BUY_LOTTO) && (money % LOTTO_PRICE == 0));
    }

    /**
     * 사용자에게 정수를 입력받아 반환하는 메소드
     */
    public static int getIntegerFromUser() {
        Scanner rd = new Scanner(System.in);
        while(true) {
            try {
                return rd.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 1000으로 나누어 떨어지는 양의 정수를 입력해 주세요.");
                rd.nextLine();
            }
        }
    }

}
