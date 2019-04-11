package lotto.view;

import java.util.Scanner;

public class InputConsoleView {

    public long inputPurchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");

        return new Scanner(System.in).nextLong();
    }

    public String inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new Scanner(System.in).nextLine();
    }

    public int inputBonusNo() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new Scanner(System.in).nextInt();
    }
}
