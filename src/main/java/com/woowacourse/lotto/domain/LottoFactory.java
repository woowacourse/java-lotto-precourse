/*
 *  클래스 이름 : LottoFactory.java
 *
 *  버전 정보 : 1.0.0
 *
 *  날짜 : 2019-04-07
 *
 *  저작권 : 이예지
 */
package com.woowacourse.lotto.domain;

import java.util.ArrayList;
import java.util.List;

import com.woowacourse.lotto.util.RandomNumber;

public class LottoFactory {
	static final int LOTTO_PRICE = 1000;

	public List<Lotto> createLottoList(int amount) {
		int lottoCount = amount / LOTTO_PRICE;
		List<Lotto> lottoList = new ArrayList<>();

		while (lottoCount-- > 0) {
			lottoList.add(createLotto());
		}

		return lottoList;
	}

	private Lotto createLotto() {
		RandomNumber randomNumber = new RandomNumber();
		Lotto lotto = new Lotto(randomNumber.createNumberList());

		return lotto;
	}

}
