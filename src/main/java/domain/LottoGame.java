package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoGame {
    private static final String PURCHASE_GUIDE = "구입금액을 입력해주세요.";
    private static final String SHORTAGE_WARNING = "구입금액이 부족합니다. ";
    private static final String UNIT_WARNING = "1000원 단위로 구입하실 수 있습니다.";
    private static final String QUANTITY_GUIDE = "개를 구매했습니다.";
    private static final int LOTTO_PRICE = 1000;

    private int purchasingMoney;
    private List<Lotto> lotteries = new ArrayList<>();

    public static void main(String[] args) {
        LottoGame game = new LottoGame();
        game.purchasingMoney = game.enterPurchasingMoney();
        int purchasingQuantity = game.getPurchasingQuantity();
        System.out.println(purchasingQuantity + QUANTITY_GUIDE);
        game.purchaseLottery();
    }

    private int enterPurchasingMoney() {
        int purchasingMoney;
        do {
            System.out.println(PURCHASE_GUIDE);
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
            System.out.println(SHORTAGE_WARNING);
            return false;
        }
        if (!this.isMultipleOf(purchasingMoney, lottoPrice)) {
            System.out.println(UNIT_WARNING);
            return false;
        }
        return true;
    }

    private int getPurchasingQuantity() {
        int quantity = this.purchasingMoney / LOTTO_PRICE;
        return quantity;
    }

    private void purchaseLottery() {
        List<Integer> lottoNumbers;
        int purchasingQuantity = this.getPurchasingQuantity();
        for (int i = 0; i < purchasingQuantity; i++) {
            lottoNumbers = Lotto.generateLottoNumbers();
            Lotto lottery = new Lotto(lottoNumbers);
            this.lotteries.add(lottery);
        }
        for (int i = 0; i < lotteries.size(); i++) {
            System.out.println(this.lotteries.get(i).getNumbers());
        }
    }
}
