/*
 * @(#)LottoGame.java        0.1 2019/04/08
 *
 *
 */

package domain;

import java.util.Scanner;

/**
 * LottoGame을 담당하는 객체입니다.
 *
 * @author 반선호
 * @version 0.1 2019년 4월 08일
 */
public class LottoGame {
    private static final int TICKET_PRICE = 1000;

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int purchaseAmount = requestPurchaseAmount(scanner);
    }

    private int requestPurchaseAmount(Scanner scanner) {
        String purchaseAmount;

        do {
            System.out.println("구입 금액을 입력해 주세요.");
            purchaseAmount = scanner.nextLine();
        } while (!checkNumber(purchaseAmount) || !checkRightPurchaseAmount(purchaseAmount));
        return Integer.parseInt(purchaseAmount);
    }

    private boolean checkNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해 주세요.");
            return false;
        }
        return true;
    }

    private boolean checkRightPurchaseAmount(String purchaseAmount) {
        int amount = Integer.parseInt(purchaseAmount);

        if ((amount < TICKET_PRICE) || ((amount % TICKET_PRICE) != 0)) {
            System.out.println("구입 금액이 잘못 되었습니다. 티켓 한장의 가격은 1000원입니다.");
            return false;
        }
        return true;
    }
}
