package domain;

import java.util.ArrayList;
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
        List<Rank> ranks =  MatchLottoNumbers();

        userOutput.PrintWinStatistics(ranks,purchaseAmount);
    }

    private List<Rank> MatchLottoNumbers() {
        WinningLotto winningLotto = LottoGenerator.getWinningLotto();
        List<Lotto> lottoes = LottoGenerator.getLottoList();
        List<Rank> ranks = new ArrayList<>();

        for (int i = 0; i < lottoes.size(); i++) {
            Rank rank = winningLotto.match(lottoes.get(i));
            ranks.add(rank);
        }

        return ranks;
    }

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.Start();
    }
}
