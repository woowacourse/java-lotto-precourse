import domain.Lotto;
import domain.MainApp;
import domain.WinningLotto;
import domain.Rank;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class WinningLottoTest extends TestCase {
    @Test
    public void testMatch() throws Exception {
        Lotto winning = new Lotto(Arrays.asList(MainAppTest.VALID_LOTTO_NUMBERS));
        int bonus = 10;

        WinningLotto winningLotto = new WinningLotto(winning, bonus);

        Rank firstRank = winningLotto.match(new Lotto(Arrays.asList(MainAppTest.VALID_LOTTO_NUMBERS)));
        assertEquals(Rank.FIRST, firstRank);
    }
}
