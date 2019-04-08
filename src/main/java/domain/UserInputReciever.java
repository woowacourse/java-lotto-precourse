package domain;

import java.util.Scanner;

public class UserInputReciever {
    private static final int UNIT_OF_PURCHASE_AMOUNT = 1000;
    private Scanner scanner = new Scanner(System.in);
    int purchaseAmount;

    public void RecievePurchaseAmount() {
        try {
            TryToRecievePurchaseAmount();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            RecievePurchaseAmount();
        }
    }

    private void TryToRecievePurchaseAmount() throws IllegalArgumentException {
        System.out.println("구매금액을 입력해 주세요.");
        purchaseAmount = scanner.nextInt();

        if (purchaseAmount >= UNIT_OF_PURCHASE_AMOUNT && (purchaseAmount % UNIT_OF_PURCHASE_AMOUNT == 0) ) {
            return;
        }

        throw new IllegalArgumentException(purchaseAmount + "는 유효하지 않은 값입니다.");
    }
}
