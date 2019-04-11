package lotto;

import java.util.ArrayList;
import java.util.List;

import static constants.LottoConstants.*;

public class BuyLotto {

    public List<Lotto> buying(int money) {
        int countOfLotto = countOfLotto(money);
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < countOfLotto; i++) {
            lottos.add(new Lotto(new RandomNumber().getNumbers()));
        }
        return lottos;
    }

    private int countOfLotto(int money) {
        checkZero(money);
        checkPrice(money);
        return money / LOTTO_PRICE;
    }

    private void checkZero(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(ZERO_ERROR_MESSAGE);
        }
    }

    private void checkPrice(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PRICE_ERROR_MESSAGE);
        }
    }
}
