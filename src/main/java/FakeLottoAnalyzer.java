import domain.Lotto;
import domain.LottoAnalyzer;
import domain.WinningLotto;

import java.util.List;

public class FakeLottoAnalyzer implements LottoAnalyzer {
    @Override
    public void analyze(WinningLotto winningLotto, List<Lotto> lottos) {
        System.out.println("analyze called");
    }
}
