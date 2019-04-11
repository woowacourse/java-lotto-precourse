import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import edu.yk1028.Lotto;

public class LottoTest {
	@Test
	public void hasDuplicateTest() {
		// given
		Lotto lotto = new Lotto(Arrays.asList(1, 1, 2, 3, 4, 5));

		// when
		boolean result = lotto.hasDuplicate();

		// then
		assertEquals(result, true);
	}

	@Test
	public void matchCountTest() {
		// given
		Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lotto anotherLotto1 = new Lotto(Arrays.asList(6, 5, 4, 3, 2, 1));
		Lotto anotherLotto2 = new Lotto(Arrays.asList(1, 7, 3, 8, 5, 9));

		// when
		int result1 = lotto.matchCount(anotherLotto1);
		int result2 = lotto.matchCount(anotherLotto2);

		// then
		assertEquals(result1, 6);
		assertEquals(result2, 3);
	}
}
