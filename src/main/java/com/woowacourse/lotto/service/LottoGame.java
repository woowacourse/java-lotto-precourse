/*
 *  클래스 이름 : LottoGame.java
 *
 *  버전 정보 : 1.0.0
 *
 *  날짜 : 2019-04-07
 *
 *  저작권 : 이예지
 */
package com.woowacourse.lotto.service;

import java.util.List;

import com.woowacourse.lotto.domain.Lotto;
import com.woowacourse.lotto.domain.LottoFactory;

public class LottoGame {
	private List<Lotto> lottoList;

	private void getLottoList() {
		UserInput userInput = new UserInput();
		LottoFactory lottoFactory = new LottoFactory();
		int lottoAmount = userInput.getPurchasingAmount();
		this.lottoList = lottoFactory.createLottoList(lottoAmount);
	}

	public void start() {
		getLottoList();

		/* 테스트를 위한 출력 */
		for (Lotto lotto : lottoList) {
			System.out.println(lotto);
		}
	}
}
