import domain.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> lottoNumbers = new ArrayList<>();
        List<Rank> ranks = new ArrayList<>();
        Lotto lotto;
        WinningLotto winnerLotto;
        String[] winnerNumbers = new String[6];
        String purchaseAmountStr = "";
        String bonusBallStr = "";

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

        flag = false;
        while (!flag) {
            winnerNumbers = ui.inputWinnerNumbers();
            flag = ui.validateWinnerNumbers(winnerNumbers);
        }

        for (String winnerNumber : winnerNumbers) {
            lottoNumbers.add(Integer.parseInt(winnerNumber));
        }

        flag = false;
        while (!flag) {
            bonusBallStr = ui.inputBonusBall();
            flag = ui.validateBonusBall(lottoNumbers, bonusBallStr);
        }

        winnerLotto = new WinningLotto(new Lotto(lottoNumbers), Integer.parseInt(bonusBallStr));

        for (Lotto l : lottos) {
            ranks.add(winnerLotto.match(l));
        }

        ResultInformation resultInformation = new ResultInformation(ranks);
        ui.printWinStats(resultInformation);
    }
}
