package domain;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LottoMakerTest {

	@Test
	public void getRandomLottoList() {
		LottoMaker lottoMaker = new LottoMaker(1, 45, 6);
		List<Lotto> lottoList = lottoMaker.getRandomLottoList(20);
		for (Lotto lotto : lottoList) {
			System.out.println(lotto);
		}
	}
}