package domain;

public class LottoGame {
    private UserInputReciever userInputReciever;
    private LottoGenerator lottoGenerator;

    LottoGame(){
        userInputReciever = new UserInputReciever();
        lottoGenerator = new LottoGenerator();
    }

    public void Start(){
        int purchaseAmount = userInputReciever.RecievePurchaseAmount();
        lottoGenerator.GenerateLottos(purchaseAmount);

    }

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.Start();
    }
}
