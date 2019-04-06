package domain;

import java.util.Scanner;

public class LottoGame {
    public LottoGame() {
        int userInput = userInputPurchase();
    }

    private int userInputPurchase() {
        int purchase = userInputStringToInt();
        while (!userInputVerify(purchase)) {
            System.out.println("잘못된 금액을 입력하셧습니다.");
            purchase = userInputStringToInt();
        }
        return purchase;
    }

    private boolean userInputVerify(int userInput) {
        if (userInput <= 0 || userInput % 1000 != 0) {
            return false;
        }
        return true;
    }

    private int userInputStringToInt() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("구입 금액을 입력해주세요");
            String userInput = scanner.nextLine();
            int result = Integer.parseInt(userInput);
            return result;
        } catch (NumberFormatException ex) {
            return -1;
        }
    }
}
