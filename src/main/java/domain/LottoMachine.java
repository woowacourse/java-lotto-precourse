package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final static int PRICE = 1000;
    private LottoNumberGenerator lottoNumberGenerator;

    public LottoMachine(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> purchaseLottos(int purchasePrice) {
        List<Lotto> purchasedLottos = new ArrayList<>();
        validatePurchasePrice(purchasePrice);

        int balance = purchasePrice;
        while (canPurchase(balance)) {
            balance -= PRICE;
            Lotto lotto = purchaseLotto();
            purchasedLottos.add(lotto);
        }

        return purchasedLottos;
    }

    private void validatePurchasePrice(int purchasePrice) {
        if (purchasePrice % PRICE != 0) {
            throw new IllegalArgumentException("로또 구매 금액을 정확히 입력 해 주세요. 금액 : " + purchasePrice);
        }
    }

    private boolean canPurchase(int remindMoney) {
        return remindMoney >= PRICE;
    }

    private Lotto purchaseLotto() {
        List<Integer> numbers = lottoNumberGenerator.makeLotto();
        return new Lotto(numbers);
    }
}
