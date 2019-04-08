package domain;

import java.util.Scanner;

public class LottoGame {
    public static int payMoney() {
        boolean isProperMoney = false;
        int inputMoney = 0;

        while (!isProperMoney) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("구입금액을 입력해주세요. \n");
            inputMoney = scanner.nextInt();
        }

        return inputMoney;
    }

    public static void main(String[] args) {
        payMoney();
    }
}
