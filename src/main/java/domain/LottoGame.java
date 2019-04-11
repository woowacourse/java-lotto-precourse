package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private ExceptionHandler exceptionHandler;
    private LottoGenerator lottoGenerator;
    private UserOutput userOutput;

    LottoGame() {
        exceptionHandler = new ExceptionHandler();
        lottoGenerator = new LottoGenerator();
        userOutput = new UserOutput();
    }

    public void Start() {
        int purchaseAmount = exceptionHandler.RecievePurchaseAmount();
        lottoGenerator.GenerateLottoes(purchaseAmount);

        userOutput.PrintPurchaseResults();

        List<Integer> winningNumbers = exceptionHandler.RecieveWinningNumber();
        int bonusNumber = exceptionHandler.RecieveBonusNumber();
        lottoGenerator.GenerateWinningLotto(winningNumbers, bonusNumber);
        List<Rank> ranks = Calculator.MatchLottoNumbers();

        userOutput.PrintWinStatistics(ranks, purchaseAmount);
    }


    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.Start();
    }
}
