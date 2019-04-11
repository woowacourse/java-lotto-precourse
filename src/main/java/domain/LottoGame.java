package domain;

import java.util.ArrayList;
import java.util.List;
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
        _printLottos(lottos);

        var winningLotto = lottoReader.readWinningLotto();
        System.out.println(winningLotto.toString());
        lottoAnalyzer.analyze(winningLotto, lottos, numLottos * LOTTO_PRICE);
    }

    private void _printLottos(List<Lotto> lottos) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        lottos.forEach((lotto) -> System.out.println(lotto.toString()));
    }
}
