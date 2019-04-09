package domain;

import java.util.List;

public class LottoGame {
    private UserInput userInput;
    private LottoGenerator lottoGenerator;
    private UserOutput userOutput;

    LottoGame() {
        userInput = new UserInput();
        lottoGenerator = new LottoGenerator();
        userOutput = new UserOutput();
    }

    public void Start() {
        int purchaseAmount = userInput.RecievePurchaseAmount();
        lottoGenerator.GenerateLottoes(purchaseAmount);

        userOutput.PrintPurchaseResults();

        List<Integer> winningNumbers = userInput.RecieveWinningNumber();
        int bonusNumber = userInput.RecieveBonusNumber();
        lottoGenerator.GenerateWinningLotto(winningNumbers, bonusNumber);

        userOutput.PrintWinStatistics();
    }

    private void MatchLottoNumbers() {
        WinningLotto winningLotto = LottoGenerator.getWinningLotto();
        List<Lotto> lottoes = LottoGenerator.getLottoList();

        for (int i = 0; i < lottoes.size(); i++) {
            Rank rank = winningLotto.match(lottoes.get(i));
        }
    }

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.Start();
    }
}
