package domain;

import java.util.Scanner;

public class LottoGame {
    public static boolean isStringNumber(String inputMoney) {
        try {
            Integer.parseInt(inputMoney);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void alertMoneyNotice(int inputMoney, int MIN, int MAX) {
        if (MIN >= inputMoney) {
            System.out.println("금액이 부족합니다.");
        }

        if (inputMoney >= MAX) {
            System.out.println("1인당 최대 10만원까지 구매 가능합니다.");
        }
    }

    public static boolean isProperMoney(int inputMoney) {
        int MIN_LOTTO_PRICE = 1000;
        int MAX_LOTTO_PRICE = 100000;

        alertMoneyNotice(inputMoney, MIN_LOTTO_PRICE, MAX_LOTTO_PRICE);

        if ((MIN_LOTTO_PRICE <= inputMoney)
                && (inputMoney <= MAX_LOTTO_PRICE)) {
            return true;
        }

        return false;
    }

    public static int payMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해주세요.");
        String inputMoney = scanner.nextLine();
        boolean isProper = isStringNumber(inputMoney);

        if (!isProper) {
            inputMoney = repayMoney();
        }

        return Integer.parseInt(inputMoney);
    }

    public static String repayMoney() {
        boolean isProper = false;
        String inputMoney = "";

        while (!isProper) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("구입금액을 제대로 입력해주세요.");
            inputMoney = scanner.nextLine();
            isProper = isStringNumber(inputMoney);
        }

        return inputMoney;
    }

    public static int receiveMoney() {
        boolean isProper = false;
        int paidMoney = 0;

        while (!isProper) {
            paidMoney = payMoney();
            isProper = isProperMoney(paidMoney);
        }

        return paidMoney;
    }

    public static void main(String[] args) {
        receiveMoney();
    }
}
