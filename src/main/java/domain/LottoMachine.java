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

        int balance = purchasePrice;
        while (canPurchase(balance)) {
            balance -= PRICE;
            Lotto lotto = purchaseLotto();
            purchasedLottos.add(lotto);
        }

        return purchasedLottos;
    }

    private boolean canPurchase(int remindMoney) {
        return remindMoney >= PRICE;
    }

    private Lotto purchaseLotto() {
        List<Integer> numbers = lottoNumberGenerator.makeLotto();
        return new Lotto(numbers);
    }
}
