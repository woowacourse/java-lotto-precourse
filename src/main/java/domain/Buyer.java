package domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 송윤재
 * @version 1.0
 */
public class Buyer {
    private List<Lotto> lottos;
    private int money;

    private static final int MIN_MONEY = 1000;

    public Buyer(int money) {
        this.money = money;
        this.lottos = buyLottos();
    }

    private List<Lotto> buyLottos() {
        List<Lotto> lottoList = new ArrayList<>();
        int lottoCnt = money / MIN_MONEY;

        for (int i = 0; i < lottoCnt; i++) {
            lottoList.add(new Lotto(Lotto.generateLottoNumber()));
        }

        return lottoList;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
