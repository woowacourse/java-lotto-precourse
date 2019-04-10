import domain.LottoGame;

import java.util.Random;

public class Main {


    public static void main(String[] args) {
        var game = new LottoGame(
                new FakeMoneyReader(),
                new MyLottoFactory(new NumberPickerByShuffling(new Random())),
                new FakeLottoReader(),
                new FakeLottoAnalyzer()
        );
        game.run();
    }
}
