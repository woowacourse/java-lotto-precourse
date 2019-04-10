import domain.LottoGame;

public class Main {


    public static void main(String[] args) {
        var game = new LottoGame(
                new FakeMoneyReader(),
                new FakeLottoFactory(),
                new FakeLottoReader(),
                new FakeLottoAnalyzer()
        );
        game.run();
    }
}
