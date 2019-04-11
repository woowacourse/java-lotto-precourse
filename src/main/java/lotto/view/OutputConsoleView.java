package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputConsoleView {
    public static void printLottos(List<Lotto> purchasedLottos) {
        for(Lotto lotto : purchasedLottos)
            System.out.println(lotto.toString());
    }
}
