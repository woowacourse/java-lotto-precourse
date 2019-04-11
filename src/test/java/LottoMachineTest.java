import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.yk1028.Lotto;
import edu.yk1028.LottoMachine;

public class LottoMachineTest {
	@Test
	public void cellLottosTest() {
		// given
		LottoMachine lottoMachine = new LottoMachine();
		List<Lotto> lottos = new ArrayList<Lotto>();
		List<Boolean> duplicateCheckList = new ArrayList<Boolean>();

		// when
		try {
			lottos = lottoMachine.cellLottos(10000000000L);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (Lotto lotto : lottos) {
			duplicateCheckList.add(lotto.hasDuplicate());
		}

		// then
		for	(boolean isDuplicate : duplicateCheckList) {
			assertEquals(isDuplicate, false);
		}
	}
}
