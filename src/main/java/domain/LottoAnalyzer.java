package domain;

import java.util.List;

public interface LottoAnalyzer {
    void analyze(WinningLotto winningLotto, List<Lotto> lottos, int usedMoney);
}
