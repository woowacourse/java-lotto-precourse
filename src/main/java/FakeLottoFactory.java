import domain.Lotto;
import domain.LottoFactory;

import java.util.ArrayList;

public class FakeLottoFactory implements LottoFactory {
    @Override
    public Lotto newLotto() {
        System.out.println("newLotto called");

        return new Lotto(new ArrayList<>());
    }
}
