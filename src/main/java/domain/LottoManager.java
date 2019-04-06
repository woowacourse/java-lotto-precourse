package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 로또 게임 configuration과 사용자 인터페이스를 담당하는 객체
 */
public class LottoManager {
    private int purchaseAmount;

    public int inputPurchaseAmount() {
        return 0;
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