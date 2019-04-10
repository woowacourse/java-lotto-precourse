import domain.Lotto;
import domain.LottoReader;
import domain.WinningLotto;

import java.util.ArrayList;

public class FakeLottoReader implements LottoReader {
    @Override
    public WinningLotto readWinningLotto() {
        System.out.println("readWinningLotto called");

        return new WinningLotto(new Lotto(new ArrayList()), 1);
    }
}
