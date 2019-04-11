import domain.*;

import java.util.List;

public class Application {
    private static UserInterface userInterface = new UserInterface();
    private static LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    private static LottoMachine lottoMachine = new LottoMachine(lottoNumberGenerator);

    public static void main(String[] args) {
        int purchasePrice = userInterface.getPurchasePrice();
        List<Lotto> purchasedLottos  = lottoMachine.createLottos(purchasePrice);
        userInterface.printLottos(purchasedLottos);

        WinningLotto winningLotto = userInterface.getWinningLotto();
        LottoRankAnalyzer lottoRankAnalyzer = new LottoRankAnalyzer(winningLotto);
        userInterface.printRankCount(lottoRankAnalyzer.getLottoRankCount(purchasedLottos));
        userInterface.printEarningRate(lottoRankAnalyzer.getEarningRate(purchasedLottos));
    }
}