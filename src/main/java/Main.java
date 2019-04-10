import domain.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        WinningLotto winnerLotto;
        Buyer buyer;
        List<Integer> lottoNumbers = new ArrayList<>();

        int purchaseAmount = ui.inputPurchaseAmount();
        buyer = new Buyer(purchaseAmount);

        ui.printBuyLotto(buyer.getLottos());

        int[] winnerNumbers = ui.inputWinnerNumbers();
        for (Integer winnerNumber : winnerNumbers) {
            lottoNumbers.add(winnerNumber);
        }

        int bonusBall = ui.inputBonusBall(winnerNumbers);
        winnerLotto = new WinningLotto(new Lotto(lottoNumbers), bonusBall);

        ResultInformation resultInformation = new ResultInformation(buyer.getLottos(), winnerLotto);
        ui.printWinStats(resultInformation);
    }
}
