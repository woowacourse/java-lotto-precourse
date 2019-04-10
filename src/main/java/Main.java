import domain.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        Buyer buyer;
        List<Integer> lottoNumbers = new ArrayList<>();
        List<Rank> ranks = new ArrayList<>();
        WinningLotto winnerLotto;
        int[] winnerNumbers;
        int bonusBall;

        int purchaseAmount = ui.inputPurchaseAmount();
        buyer = new Buyer(purchaseAmount);

        ui.printBuyLotto(buyer.getLottos());

        winnerNumbers = ui.inputWinnerNumbers();
        for (Integer winnerNumber : winnerNumbers) {
            lottoNumbers.add(winnerNumber);
        }

        bonusBall = ui.inputBonusBall(winnerNumbers);
        winnerLotto = new WinningLotto(new Lotto(lottoNumbers), bonusBall);

        for (Lotto buyerLotto : buyer.getLottos()) {
            ranks.add(winnerLotto.match(buyerLotto));
        }

        ResultInformation resultInformation = new ResultInformation(ranks);
        ui.printWinStats(resultInformation);
    }
}
