package domain;

import java.util.List;

public class LottoGame {
    private UserInput userInput;
    private LottoGenerator lottoGenerator;
    private UserOutput userOutput;

    LottoGame(){
        userInput = new UserInput();
        lottoGenerator = new LottoGenerator();
        userOutput = new UserOutput();
    }

    public void Start(){
        int purchaseAmount = userInput.RecievePurchaseAmount();
        lottoGenerator.GenerateAutoLottos(purchaseAmount);
        userOutput.PrintPurchaseResults();
        List<Integer> winningNumbers = userInput.RecieveWinningNumber();
        int bonusNumber = userInput.RecieveBonusNumber();
    }

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.Start();
    }
}
