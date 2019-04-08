package domain;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 어플리케이션 객체
 */
public class App {
    static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        final int number = validateAmountAndBuy(inputAmount());

    }

    private static int inputAmount() {
        final int amount;

        System.out.println("구입금액을 입력해 주세요.");
        try {
            amount = input.nextInt();
            return amount;
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private static int validateAmountAndBuy(final int amount) {
        if (0 <= amount && amount < 1000) {
            throw new IllegalArgumentException("금액이 부족합니다.");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return amount / 1000;
    }
}