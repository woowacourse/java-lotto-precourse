package domain;

import java.util.Scanner;

public class LottoGame {
    private static final String PURCHASE_GUIDE = "구입금액을 입력해주세요.";
    private static final String SHORTAGE_WARNING = "구입금액이 부족합니다. ";
    private static final String UNIT_WARNING = "1000원 단위로 구입하실 수 있습니다.";
    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        LottoGame game = new LottoGame();
        int purchasingMoney = game.enterPurchasingMoney();
    }

    private int enterPurchasingMoney() {
        int purchasingMoney;
        do {
            System.out.println(this.PURCHASE_GUIDE);
            Scanner prompt = new Scanner(System.in);
            purchasingMoney = prompt.nextInt();
        } while (!this.validatePurchasingMoney(purchasingMoney, this.LOTTO_PRICE));
        return purchasingMoney;
    }

    private boolean isMoreThan(int purchasingMoney, int lottoPrice) {
        return (purchasingMoney >= lottoPrice) ? true : false;
    }

    private boolean isMultipleOf(int purchasingMoney, int lottoPrice) {
        return (purchasingMoney % lottoPrice == 0) ? true : false;
    }

    private boolean validatePurchasingMoney(int purchasingMoney,
                                            int lottoPrice) {
        if (!this.isMoreThan(purchasingMoney, lottoPrice)) {
            System.out.println(this.SHORTAGE_WARNING);
            return false;
        }
        if (!this.isMultipleOf(purchasingMoney, lottoPrice)) {
            System.out.println(this.UNIT_WARNING);
            return false;
        }
        return true;
    }
}
