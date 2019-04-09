package domain;

import java.util.Scanner;

import static domain.Constants.*;

public class LottoGame {
    private Scanner scan = new Scanner(System.in);
    private Lotto[] lotto;
    private WinningLotto winningLotto;

    public static void main(String[] args) {
        LottoGame game = new LottoGame();
        game.doGame();
    }

    private void doGame() {
        int numOfLotto = getNumOfLotto();
    }

    private int getNumOfLotto() {
        return getPurchasePrice() / MIN_UNIT;
    }

    private int getPurchasePrice() {
        int purchasePrice;
        do {
            System.out.println("구입금액을 입력해 주세요.");
            purchasePrice = scan.nextInt();
        } while (!checkPriceValidity(purchasePrice));
        scan.nextLine();

        return purchasePrice;
    }

    private boolean checkPriceValidity(int purchasePrice) {
        return purchasePrice >= MIN_UNIT && purchasePrice <= MAX_SUM_OF_PRICE && purchasePrice % MIN_UNIT == 0;
    }
}
