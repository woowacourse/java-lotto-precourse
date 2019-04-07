package ExceptionCheck;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NoticeOfException {

    public int inputCostNOE(Scanner sc) {
        int cost = 0;
        try {
            cost = sc.nextInt();
            inputCostNOE(cost);
        } catch (InputMismatchException e) {
            printNotNumber();
        }
        return cost;
    }

    private void inputCostNOE(int cost) {
        if (cost < 1000) {
            System.out.println("금액이 부족합니다.");
            System.exit(0);
        }
    }

    private void printNotNumber() {
        System.out.println("잘못된 입력값 입니다! 숫자만 입력해주세요.");
        System.exit(0);
    }
}
