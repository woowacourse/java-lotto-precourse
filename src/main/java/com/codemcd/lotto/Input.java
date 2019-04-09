package com.codemcd.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    public static int inputMoneyAndReturn() {
        Scanner scanner = new Scanner(System.in);
        String inputMoneyForLotto;
        System.out.println("구입 금액을 입력해주세요.");
        inputMoneyForLotto = scanner.nextLine();
        // 입력 오류 처리
        return Integer.parseInt(inputMoneyForLotto);
    }

    private static List<Integer> inputWinningNumberAndReturn() {
        Scanner scanner = new Scanner(System.in);
        String winningNumber;
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        winningNumber = scanner.nextLine();
        // 오류 처리
        List<Integer> splitWinningNumber = new ArrayList<>();
        for (String number : winningNumber.split(",")) {
            splitWinningNumber.add(Integer.parseInt(number));
        }
        return splitWinningNumber;
    }

    private static int inputBonusNumberAndReturn() {
        Scanner scanner = new Scanner(System.in);
        String bonusNumber;
        System.out.println("보너스 볼을 입력해 주세요.");
        bonusNumber = scanner.nextLine();
        // 오류 처리
        return Integer.parseInt(bonusNumber);
    }

    public static WinningLotto inputWinningAndBonusNumber() {
        return new WinningLotto(new Lotto(inputWinningNumberAndReturn()),
                inputBonusNumberAndReturn());
    }
}
