import domain.*;

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
        LottoRankAnalyzer lottoRankAnalyzer = new LottoRankAnalyzer();
        lottoRankAnalyzer.getLottoRankCount(lottos, winningLotto);

        userInterface.printRankCount(lottoRankAnalyzer.getLottoRankCount(lottos, winningLotto));
    }
}