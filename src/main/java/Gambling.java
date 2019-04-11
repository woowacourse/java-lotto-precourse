import domain.Console;
import lotto.BuyLotto;
import lotto.Lotto;
import lotto.WinningLotto;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Gambling {
    private Console console;

    Gambling(){
        console = new Console();
    }

    public void start() throws IOException {
        List<Lotto> lottos = makeLottos();
        WinningLotto winningLotto = makeWinningLotto();
    }

    private List<Lotto> makeLottos() throws IOException {
        int money = console.readMoney();
        List<Lotto> lottos = new BuyLotto().buying(money);
        console.writeLottos(lottos);
        return lottos;
    }

    private WinningLotto makeWinningLotto() throws IOException {
        Lotto winningNumber = winningNumber();
        int bonusNumber = console.readBonusNumber();

        return new WinningLotto(winningNumber, bonusNumber);
    }

    private Lotto winningNumber() throws IOException {
        return new Lotto(Arrays.stream(console.readWinningNumbers())
                .boxed()
                .collect(Collectors.toList()));
    }
}
