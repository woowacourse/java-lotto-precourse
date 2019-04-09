package domain;

public class LottoGame {
    private UserInputReciever userInputReciever;
    private LottoGenerator lottoGenerator;
    private UserOutput userOutput;

    LottoGame(){
        userInputReciever = new UserInputReciever();
        lottoGenerator = new LottoGenerator();
        userOutput = new UserOutput();
    }

    public void Start(){
        int purchaseAmount = userInputReciever.RecievePurchaseAmount();
        lottoGenerator.GenerateLottos(purchaseAmount);
        userOutput.PrintPurchaseResults();
    }

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.Start();
    }
}
