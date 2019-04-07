package com.codemcd.lotto;

import java.util.Scanner;

public class Game {

    private int moneyForLotto;

    public void start() {
        inputMoney();
    }

    private void inputMoney() {
        Scanner scanner = new Scanner(System.in);
        String inputMoneyForLotto;

        System.out.println("구입 금액을 입력해주세요.");
        inputMoneyForLotto = scanner.nextLine();
        // 입력 오류 처리
        moneyForLotto = Integer.parseInt(inputMoneyForLotto);
    }
}
