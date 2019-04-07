import domain.Lotto;
import domain.UserInterface;
import domain.WinningLotto;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        List<Lotto> lottos = new ArrayList<>();
        List<Integer> lottoNumbers = new ArrayList<>();
        Lotto lotto;
        WinningLotto winnerLotto;
        String[] winnerNumbers = new String[6];
        String purchaseAmountStr = "";
        String bonusBallStr = "";

        int lottoCnt = 0;
        int bonusBall;
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

        for(String winnerNumber : winnerNumbers){
            lottoNumbers.add(Integer.parseInt(winnerNumber));
        }
        lotto = new Lotto(lottoNumbers);

        flag = false;
        while (!flag) {
            bonusBallStr = ui.inputBonusBall();
            flag = ui.validateBonusBall(lottoNumbers, bonusBallStr);
        }
        bonusBall = Integer.parseInt(bonusBallStr);

        winnerLotto = new WinningLotto(lotto, bonusBall);

        ui.printWinStats();


    }
}
