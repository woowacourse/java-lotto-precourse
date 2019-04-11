package lotto.view;

import java.util.Scanner;

public class InputConsoleView {
    public long inputPurchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");

        return new Scanner(System.in).nextLong();
    }
}
