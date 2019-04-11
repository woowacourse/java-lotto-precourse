package domain;

import java.util.HashMap;
import java.util.List;

public class Result {
    private List<Lotto> lotto;
    private int myMoney;
    private int sumMoney;
    private WinningLotto winninglotto;
    private User user;
    private HashMap<Rank,Integer> lottoMap;
    public void buyLotto() {
        user = new User();
        myMoney = user.getPrice();
        lotto = user.getLotto(myMoney);
        for (Lotto getlotto : lotto) {
            System.out.println(getlotto.getNumbers());
        }
        List<Integer> getwinLotto = user.getWinningLotto();
        setWinningLotto(getwinLotto);
        System.out.println("총 수익률은 " + setRate() + "입니다.");
    }

}

