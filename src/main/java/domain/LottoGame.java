package domain;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGame {
    public static final int LOTTO_PRICE = 1000;


    private MoneyReader moneyReader;
    private LottoFactory lottoFactory;
    private LottoReader lottoReader;
    private LottoAnalyzer lottoAnalyzer;

    public LottoGame(MoneyReader moneyReader,
                     LottoFactory lottoFactory,
                     LottoReader lottoReader,
                     LottoAnalyzer lottoAnalyzer) {
        this.moneyReader = moneyReader;
        this.lottoFactory = lottoFactory;
        this.lottoReader = lottoReader;
        this.lottoAnalyzer = lottoAnalyzer;
    }

    public void run() {
        var money = moneyReader.readMoney();
        var numLottos = money / LOTTO_PRICE;

        var lottos = Stream.generate(() -> lottoFactory.newLotto())
                .limit(numLottos)
                .collect(Collectors.toCollection(ArrayList::new));

        var winningLotto = lottoReader.readWinningLotto();

        lottoAnalyzer.analyze(winningLotto, lottos);
    }
}
