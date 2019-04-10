import java.util.ArrayList;
import java.util.Arrays;

import com.woowacourse.lotto.domain.Lotto;
import com.woowacourse.lotto.domain.Rank;
import com.woowacourse.lotto.domain.WinningLotto;
import org.junit.Assert;
import org.junit.Test;

/*
 *  클래스 이름 : WinningLottoTest.java
 *
 *  버전 정보 : 1.0.0
 *
 *  날짜 : 2019-04-10
 *
 *  저작권 : 이예지
 */
public class WinningLottoTest {
	@Test
	public void winningLottoMatch_1등() {
		//		Lotto lotto = new Lotto(new ArrayList<>(userInput.getWinningNumber()));
		Lotto userLotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
		WinningLotto winningLotto = new WinningLotto(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))), 7);
		Assert.assertEquals(Rank.FIRST, winningLotto.match(userLotto));
	}

	@Test
	public void winningLottoMatch_2등() {
		//		Lotto lotto = new Lotto(new ArrayList<>(userInput.getWinningNumber()));
		Lotto userLotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
		WinningLotto winningLotto = new WinningLotto(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7))), 6);
		Assert.assertEquals(Rank.SECOND, winningLotto.match(userLotto));
	}

	@Test
	public void winningLottoMatch_3등() {
		//		Lotto lotto = new Lotto(new ArrayList<>(userInput.getWinningNumber()));
		Lotto userLotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
		WinningLotto winningLotto = new WinningLotto(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7))), 8);
		Assert.assertEquals(Rank.THIRD, winningLotto.match(userLotto));
	}

	@Test
	public void winningLottoMatch_4등() {
		//		Lotto lotto = new Lotto(new ArrayList<>(userInput.getWinningNumber()));
		Lotto userLotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
		WinningLotto winningLotto = new WinningLotto(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 11, 12))), 6);
		Assert.assertEquals(Rank.FOURTH, winningLotto.match(userLotto));
	}

	@Test
	public void winningLottoMatch_5등() {
		//		Lotto lotto = new Lotto(new ArrayList<>(userInput.getWinningNumber()));
		Lotto userLotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
		WinningLotto winningLotto = new WinningLotto(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 12, 13, 14))), 6);
		Assert.assertEquals(Rank.FIFTH, winningLotto.match(userLotto));
	}

	@Test
	public void winningLottoMatch_MISS() {
		Lotto userLotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
		WinningLotto winningLotto = new WinningLotto(new Lotto(new ArrayList<>(Arrays.asList(1, 2, 11, 12, 13, 14))), 6);
		Assert.assertEquals(Rank.MISS, winningLotto.match(userLotto));
	}

}
