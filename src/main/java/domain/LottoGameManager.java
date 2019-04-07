package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGameManager {
    private InputLottoInformation inputlottoinformation ;
    private List<Lotto> lotto ;

    private void init() {
        inputlottoinformation = new InputLottoInformation();
        lotto = new ArrayList<>();
    }

    public void lottoPurchase() {
        init();
        int money = inputlottoinformation.getLottoPurchasePrice();
        lotto = inputlottoinformation.getGeneratedLottoNumber(money);
        System.out.println(lotto.size()+Message.lottoOutputMessage.get("OUTPUT_BUYLOTTO"));
    }

    private void outputLottoNumber() {
        for (Lotto li : lotto ) {
            System.out.println(li.getNumbers());
        }
    }


}
