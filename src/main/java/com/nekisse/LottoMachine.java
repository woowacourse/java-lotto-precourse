package com.nekisse;

import com.nekisse.domain.Lotto;
import com.nekisse.domain.Money;
import com.nekisse.domain.UserLottos;

public class LottoMachine {

    private RandomNumberGenerator randomNumberGenerator;

    public LottoMachine(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public UserLottos buyLotto(Money money) {
        UserLottos userLottos = new UserLottos();
        for (int i = 0; i < money.buyLottoCount(); i++) {
            userLottos.add(new Lotto(randomNumberGenerator.generate()));
        }
        return userLottos;
    }
}
