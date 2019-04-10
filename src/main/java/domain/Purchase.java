package domain;

import java.util.ArrayList;
import java.util.List;

public class Purchase {
    private List<Lotto> lottoList;

    Purchase(int money) {

        lottoList = new ArrayList<>();
        run((money / Const.ONE_LOTTO_MONEY));
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    private void run(int purchaseNumber) {

        for (int i = 0; i < purchaseNumber; i++) {
            Lotto lotto = new Lotto(new ArrayList<>());
            lotto.create();
            lottoList.add(lotto);
        }
    }

    public void printLottoListOfUser() {
        System.out.format(Message.MAKE_MESSAGE, lottoList.size());

        for (Lotto lotto : lottoList) {
            System.out.println(lotto);
        }
    }
}
