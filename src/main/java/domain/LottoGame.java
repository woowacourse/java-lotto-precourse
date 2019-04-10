package domain;

import java.util.Scanner;

public class LottoGame {
    private static final String PURCHASE_GUIDE = "구입금액을 입력해주세요.";
    public static void main(String[] args) {
        LottoGame game = new LottoGame();
        int purchasingMoney = game.enterPurchasingMoney();
    }

    private int enterPurchasingMoney() {
        System.out.println(this.PURCHASE_GUIDE);
        Scanner prompt = new Scanner(System.in);
        int purchasingMoney = prompt.nextInt();
        return purchasingMoney;
    }
}
