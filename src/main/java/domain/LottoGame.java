package domain;

import java.util.Scanner;

public class LottoGame {
    public LottoGame() {

    }

    private int userInputPurchase() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입 금액을 입력해주세요");
        int purchase = scanner.nextInt();
        while (!userInputVerify(purchase)) {
            System.out.println("잘못된 금액을 입력하셧습니다.");
            purchase = scanner.nextInt();
        }
        return purchase;
    }

    public boolean userInputVerify(int userInput) {
        if (userInput <= 0 || userInput % 1000 != 0) {
            return false;
        }
        return true;
    }
}
