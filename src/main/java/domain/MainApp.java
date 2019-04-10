package domain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
    }


    /**
     * 사용자가 입력한 로또 구입 금액이 적절한지 판단하는 메소드
     */
    public static boolean isValidMoneyToBuyLotto(int money) {
        return ((money > 0) && (money % 1000 == 0));
    }

    /**
     * 사용자에게 정수를 입력받아 반환하는 메소드
     */
    public static int getIntegerFromUser() throws InputMismatchException {
        Scanner rd = new Scanner(System.in);
        return rd.nextInt();
    }

}
