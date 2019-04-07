package domain;

import java.util.*;

public class PlayLotto {
    public static int purchase_amount;
    public static Scanner sc;

    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        getPurchaseAmount();
    }

    public static void getPurchaseAmount() {
        sc = new Scanner(System.in);
        int purchase_money = 0;
        boolean flag = false;
        while (!flag) {
            System.out.println("구입금액을 입력해주세요");
            purchase_money = sc.nextInt();
            flag = isPurchaseMoneyValid(purchase_money);
        }
        purchase_amount = purchase_money / LOTTO_PRICE;
    }

    public static boolean isPurchaseMoneyValid(int amount) {
        if (amount <= 0)
            return false;
        else if (amount % LOTTO_PRICE == 0)
            return true;
        return false;
    }
}
