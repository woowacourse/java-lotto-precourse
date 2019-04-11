package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoMoney;
import lotto.domain.WinningLotto;
import lotto.utils.RandomNumberGenerate;
import lotto.view.InputConsoleView;
import lotto.view.OutputConsoleView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private InputConsoleView inputConsoleView;
    private LottoMachine lottoMachine;

    public LottoGame() {
        inputConsoleView = new InputConsoleView();
        lottoMachine = new LottoMachine(new RandomNumberGenerate());
    }

    public void run(){
        LottoMoney purchaseAmount = new LottoMoney(inputConsoleView.inputPurchaseAmount());
        List<Lotto> purchasedLottos =  lottoMachine.buyLottos(purchaseAmount);
        OutputConsoleView.printLottos(purchasedLottos);

        WinningLotto winningLotto = getWinningLotto();
        
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
