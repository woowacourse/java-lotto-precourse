import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import edu.yk1028.Lotto;
import edu.yk1028.Rank;
import edu.yk1028.WinningLotto;

public class WinningLottoTest {
	@Test
	public void matchTest() {
		// given
		Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		int bonusNumber = 7;
		WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
		Lotto firstLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lotto secondLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7));
		Lotto thirdLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8));
		Lotto fourthLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9));
		Lotto fifthLotto = new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10));
		Lotto missLotto = new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15));

		// when
		Rank firstRank = winningLotto.match(firstLotto);
		Rank secondRank = winningLotto.match(secondLotto);
		Rank thirdRank = winningLotto.match(thirdLotto);
		Rank fourthRank = winningLotto.match(fourthLotto);
		Rank fifthRank = winningLotto.match(fifthLotto);
		Rank missRank = winningLotto.match(missLotto);
		
		//then
		assertEquals(firstRank, Rank.FIRST);
		assertEquals(secondRank, Rank.SECOND);
		assertEquals(thirdRank, Rank.THIRD);
		assertEquals(fourthRank, Rank.FOURTH);
		assertEquals(fifthRank, Rank.FIFTH);
		assertEquals(missRank, Rank.MISS);

	}
}
