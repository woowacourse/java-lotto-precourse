import domain.Lotto;
import domain.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto;
        String purchaseAmountStr = "";

        int lottoCnt = 0;
        boolean flag = false;

        while (!flag) {
            purchaseAmountStr = ui.inputPurchaseAmount();
            flag = ui.validatePurchaseAmount(purchaseAmountStr);
        }

        lottoCnt = (int) Integer.parseInt(purchaseAmountStr) / 1000;
        for (int i = 0; i < lottoCnt; i++) {
            lotto = new Lotto(Lotto.generateLottoNumber());
            lottos.add(lotto);
        }

        ui.printBuyLotto(lottos);
    }
}
