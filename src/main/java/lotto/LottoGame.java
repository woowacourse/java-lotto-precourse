package lotto;

import lotto.domain.*;
import lotto.utils.LottoRankChecker;
import lotto.utils.RandomNumberGenerate;
import lotto.view.InputConsoleView;
import lotto.view.OutputConsoleView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private InputConsoleView inputConsoleView;
    private LottoMachine lottoMachine;
    private WinPrice winPrice;

    public LottoGame() {
        inputConsoleView = new InputConsoleView();
        lottoMachine = new LottoMachine(new RandomNumberGenerate());
        winPrice = new WinPrice();
    }

    public void run(){
        LottoMoney purchaseAmount = new LottoMoney(inputConsoleView.inputPurchaseAmount());
        List<Lotto> purchasedLottos =  lottoMachine.buyLottos(purchaseAmount);
        OutputConsoleView.printLottos(purchasedLottos);

        WinningLotto winningLotto = getWinningLotto();

        List<Rank> purchasedLottosRanks = LottoRankChecker.getRanks(purchasedLottos, winningLotto);
        winPrice.addWinCount(purchasedLottosRanks);

        printResult(purchaseAmount);
    }

    private void printResult(LottoMoney purchaseAmount) {
        OutputConsoleView.printResult(winPrice);
        OutputConsoleView.printRateOfProfit(purchaseAmount, winPrice.getTotalWinPrice());
    }

    private WinningLotto getWinningLotto() {
        Lotto winningNumbers = new Lotto(toListOfInteger(split(inputConsoleView.inputWinningNumbers())));
        int bonusNo = inputConsoleView.inputBonusNo();
        return new WinningLotto(winningNumbers, bonusNo);
    }

    private List<Integer> toListOfInteger(String[] winningNumbers) {
        return Arrays.stream(winningNumbers).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
    }

    private String[] split(String winningNumbers) {
        return winningNumbers.split(",");
    }

}
