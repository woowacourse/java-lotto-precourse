package domain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputLottoInformation {
    private Scanner sc ;
    private final int lottoPrice = 1000;
    private void init() {
        sc = new Scanner(System.in);
    }

    public int getLottoPurchasePrice() {
        init();
        int purchasePrice = 0;
        do {
            purchasePrice = checkPriceOnlyNumber(purchasePrice);
        } while (checkPrice(purchasePrice));
        return purchasePrice;
    }

    private int checkPriceOnlyNumber(int purchasePrice) {
        try {
            System.out.println(Message.lottoInputMessage.get("INPUT_PURCHASEMONEY"));
            purchasePrice = sc.nextInt();
        } catch (InputMismatchException ime) {
            sc= new Scanner(System.in);
            System.out.println(Message.errorMessage.get("ERROR_ONLYNUMBER"));
            return getLottoPurchasePrice();
        }
        return purchasePrice;
    }

    private boolean checkPrice(int pirce) {
        if (pirce <lottoPrice) { // 1000보다 적음 못삼
            System.out.println(Message.errorMessage.get("ERROR_MONEYSHORT"));
            return true;
        }
        return false;
    }
}
