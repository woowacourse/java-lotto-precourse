package domain;

import java.util.*;

public class LottoGame {

    private int cashToBuyLotto;
    private List<Lotto> userLottos;
    private WinningLotto winningLotto;

    private static final int LOTTO_PRICE = 1000;

    public LottoGame() {
        this.cashToBuyLotto = 0;
        this.userLottos = new ArrayList<Lotto>();
        this.winningLotto = null;
    }

    public void setCashToBuyLotto(String cash) {
        this.cashToBuyLotto = Integer.parseInt(cash);
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }

}
