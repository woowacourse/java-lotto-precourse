import domain.LottoGame;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        var game = new LottoGame(
                new MoneyReaderFromUser(),
                new MyLottoFactory(new NumberPickerByShuffling(new Random())),
                new LottoReaderFromUser(),
                new MyLottoAnalyzer()
        );
        game.run();
    }
}
