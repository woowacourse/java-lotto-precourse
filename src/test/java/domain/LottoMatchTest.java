package domain;

import logic.LottoMaker;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LottoMatchTest {

	@Test
	public void lottoMatch() {
		Integer ans[] = {1, 2, 3, 4, 5, 6};
		Integer first[] = {1, 2, 3, 4, 6, 5};
		Integer second[] = {1, 2, 3, 4, 5, 7};
		Integer third[] = {2, 1, 3, 5, 4, 8};
		Integer fourth[] = {2, 6, 5, 4, 25, 30};
		Integer fifth[] = {6, 3, 8, 9, 2, 20};
		Integer miss[] = {7, 8, 9 , 10, 21, 33};
		int bonusNum = 7;
		WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(ans)), bonusNum);
		Lotto exLotto = new Lotto(Arrays.asList(miss));

		assertEquals(Rank.MISS, winningLotto.match(exLotto));

		LottoMaker lottoMaker = new LottoMaker(1, 45, 6);
		List<Lotto> lottoList = lottoMaker.getRandomLottoList(5000);
		for (Lotto lotto : lottoList) {
			Rank rank = winningLotto.match(lotto);
			System.out.println(rank.getCountOfMatch() + "개 " + rank.getWinningMoney() + "원");
		}
	}
}