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

    public void setWinningLotto(String nums, String bonus) {
        List<Integer> list = new ArrayList<Integer>();
        for (String num : nums.split(",")) {
            list.add(Integer.parseInt(num));
        }

        int bonusNum = Integer.parseInt(bonus);

        this.winningLotto = new WinningLotto(new Lotto(list), bonusNum);
    }

    public void showLottos(){
        this.showMessage("\n총 "+this.userLottos.size()+"개를 구매했습니다.");
        Iterator<Lotto> it = this.userLottos.iterator();

        while(it.hasNext()){
            Lotto lotto = it.next();
            this.showMessage(String.valueOf(lotto.getLottoNumbers()));
        }
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }

}
