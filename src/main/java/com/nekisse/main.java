package com.nekisse;

import com.nekisse.domain.Money;
import com.nekisse.view.InputView;
import com.nekisse.view.OutputView;

public class Main {

    public static void main(String[] args) {
        int inputAmount = InputView.getInputAmount();
        Money money = new Money(inputAmount);


        LottoMachine lottoMachine = new LottoMachine(new LottoRandomNumberGenerator());
        UserLottos userLottos = lottoMachine.buyLotto(money);
        OutputView.PrintUserBuyLottos(userLottos, money);

// 8개를구매했습니다.
//    [8,21,23,41,42,43]
//    [3,5,11,16,32,38]
//    [7,11,16,35,36,44]
//    [1,8,11,31,41,42]
//    [13,14,16,38,42,45]
//    [7,11,30,40,42,43]
//    [2,13,22,32,38,45]
//    [1,3,5,14,22,45]
//

    }
}
