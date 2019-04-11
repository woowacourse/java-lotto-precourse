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

    public void createLottos() {
        int cash = this.cashToBuyLotto;

        while (cash >= this.LOTTO_PRICE) {
            List<Integer> lottoNums = new LottoNumMaker().createLottoNums();
            this.userLottos.add(new Lotto(lottoNums));
            cash -= this.LOTTO_PRICE;
        }
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }

}
