import domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoBuyer {
    private List<Lotto> list = new ArrayList<>();
    private int money;

    public void buyLottos(){
        int cost = LottoSeller.giveLottos(money,list);
        money -= cost;
    }

    public LottoBuyer(int money) {
        this.money = money;
    }
}
