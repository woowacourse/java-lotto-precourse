package domain;

import domain.handler.LottoInputHandler;

import java.util.List;
import java.util.ArrayList;

public class LottoEvent {

    private static final int LOTTO_PRICE = 1000;

    private final LottoInputHandler lottoInputHandler;
    private final LottoFactory lottoFactory;
    private final List<Lotto> lottoList;

    public LottoEvent() {
        lottoInputHandler = new LottoInputHandler();
        lottoFactory = new LottoFactory();
        lottoList = new ArrayList<>();
    }

    private void buyLotto() {
        int purchaseAmount = lottoInputHandler.getPurchaseAmount();
        buyLottoWithPurchaseAmount(purchaseAmount);
    }

    private void buyLottoWithPurchaseAmount(int purchaseAmount) {
        int numOfLottoToCreate = purchaseAmount / LOTTO_PRICE;
        while (numOfLottoToCreate > 0) {
            Lotto lotto = lottoFactory.getInstance();
            lottoList.add(lotto);
            numOfLottoToCreate--;
        }
    }
}
