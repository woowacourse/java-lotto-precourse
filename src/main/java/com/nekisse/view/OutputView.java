package com.nekisse.view;

import com.nekisse.domain.Lotto;
import com.nekisse.domain.Money;
import com.nekisse.domain.UserLottos;

public class OutputView {
    public static void PrintUserBuyLottos(UserLottos userLottos, Money money) {
        System.out.println(money.buyLottoCount() + "개를 구매했습니다.");
        for (Lotto userLotto : userLottos.getUserLottos()) {
            System.out.println(userLotto);
        }
    }

}
