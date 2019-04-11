import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import edu.yk1028.Rank;
import edu.yk1028.Result;

public class ResultTest {
	@Test
	public void calculateYieldTest() {
		// given
		Result result = new Result();
		
		// when
		long maximumNumberOfLottos = 9223372036854775L;
		for	(long i = 0; i < maximumNumberOfLottos; i++) {
			result.add(Rank.FIRST);
		}
		double yield = result.calculateYield();
		
		// then
		assertEquals(yield, 2000000);
	}
}
