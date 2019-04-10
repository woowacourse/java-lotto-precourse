package com.codemcd.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    public static int returnMoney() {
        int rightInput = -1;
        while (rightInput < 0) {
            rightInput = inputMoney();
        }
        return rightInput;
    }

    public static int inputMoney() {
        Scanner scanner = new Scanner(System.in);
        String inputMoney;
        System.out.println("구입 금액을 입력해주세요.");
        inputMoney = scanner.nextLine();
        inputMoney = inputMoney.replaceAll("\\s", "");
        // 입력 오류 처리
        String errorMsg = InputError.handleMoneyInputError(inputMoney);
        if (errorMsg.equals(""))
            return Integer.parseInt(inputMoney);
        System.out.println(errorMsg);
        return -1;
    }

    public static WinningLotto inputWinningAndBonusNumber() {
        return new WinningLotto(new Lotto(returnWinningNumber()),
                returnBonusNumber());
    }

    private static String inputWinningNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String inputWinningNumber = scanner.nextLine();
        inputWinningNumber = inputWinningNumber.replaceAll("\\s", "");
        String errorMsg = InputError.handleWinningLottoInputError(inputWinningNumber);
        if (errorMsg == "") {
            return inputWinningNumber;
        }
        System.out.println(errorMsg);
        return "";
    }

    private static List<Integer> returnWinningNumber() {
        String winningNumber = "";
        while (winningNumber == "") {
            winningNumber = inputWinningNumber();
        }

        List<Integer> splitWinningNumber = new ArrayList<>();
        for (String number : winningNumber.split(",")) {
            splitWinningNumber.add(Integer.parseInt(number));
        }
        return splitWinningNumber;
    }

    public static int returnBonusNumber() {
        int rightInput = -1;
        while (rightInput < 0) {
            rightInput = inputBonusNumber();
        }
        return rightInput;
    }

    private static int inputBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        String inputBonusNumber;
        System.out.println("보너스 볼을 입력해 주세요.");
        inputBonusNumber = scanner.nextLine();
        inputBonusNumber = inputBonusNumber.replaceAll("\\s", "");
        // 입력 오류 처리
        String errorMsg = InputError.handleBonusNumberInputError(inputBonusNumber);
        if (errorMsg.equals(""))
            return Integer.parseInt(inputBonusNumber);
        System.out.println(errorMsg);
        return -1;
    }
}
