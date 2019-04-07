package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 로또 게임 configuration과 사용자 인터페이스를 담당하는 객체
 */
public class LottoManager {
    Scanner sc = new Scanner(System.in);
    Validator validator = new Validator();
    private int purchaseAmount;

    public int inputPurchaseAmount() {
        String purchaseAmount;

        do {
            System.out.println("구매 금액을 입력해주세요.");
            purchaseAmount = sc.nextLine();
        } while(!validator.isValidPurchase(purchaseAmount));

        this.purchaseAmount = Integer.parseInt(purchaseAmount);
        return this.purchaseAmount;
    }

    public List<Lotto> issueLottoOf(int purchasedMoney) {
        return new ArrayList<Lotto>();
    }

    public Lotto inputWinningNumber() {
        return new Lotto(new ArrayList<Integer>());
    }

    public int inputBonus() {
        return 0;
    }

    public void showEarningRate(HashMap<Lotto, Rank> matchResult) {

    }
}