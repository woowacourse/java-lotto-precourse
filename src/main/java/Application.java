import domain.Lotto;
import domain.LottoMachine;
import domain.LottoNumberGenerator;
import domain.WinningLotto;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        int purchasePrice = userInterface.getPurchasePrice();

        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        LottoMachine lottoMachine = new LottoMachine(lottoNumberGenerator);
        List<Lotto> lottos = lottoMachine.purchaseLottos(purchasePrice);

        userInterface.printLottos(lottos);

        WinningLotto winningLotto = userInterface.getWinningLotto();
    }
}