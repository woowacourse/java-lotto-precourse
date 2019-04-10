import domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        Buyer buyer;
        List<Integer> lottoNumbers = new ArrayList<>();
        List<Rank> ranks = new ArrayList<>();
        WinningLotto winnerLotto;
        String[] winnerNumbers = new String[6];
        String purchaseAmountStr = "";
        String bonusBallStr = "";

        boolean flag = false;

        while (!flag) {
            purchaseAmountStr = ui.inputPurchaseAmount();
            flag = ui.validatePurchaseAmount(purchaseAmountStr);
        }

        buyer = new Buyer(Integer.parseInt(purchaseAmountStr));

        ui.printBuyLotto(buyer.getLottos());

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

        for (Lotto buyerLotto : buyer.getLottos()) {
            ranks.add(winnerLotto.match(buyerLotto));
        }

        ResultInformation resultInformation = new ResultInformation(ranks);
        ui.printWinStats(resultInformation);
    }
}
