package domain;

import java.util.HashMap;
import java.util.List;

public class LottoStatistics {
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
    }

    private void setWinningLotto(List<Integer> getwinLotto) {
        int bonusno = user.getBonusNo();
        Lotto winlotto = new Lotto(getwinLotto);
    }
}
