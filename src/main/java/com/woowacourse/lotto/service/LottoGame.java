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
import com.woowacourse.lotto.domain.WinningLotto;

public class LottoGame {
	static final String PRINT_USER_LOTTO_COUNT = "%s개를 구매하셨습니다.\n";

	private List<Lotto> lottoList;
	private LottoFactory lottoFactory;
	private UserInput userInput;

	public LottoGame() {
		lottoFactory = new LottoFactory();
		userInput = new UserInput();
	}

	private void getLottoList() {
		int lottoAmount = userInput.getPurchasingAmount();
		this.lottoList = lottoFactory.createLottoList(lottoAmount);
	}

	private void printLottoList() {
		System.out.printf(PRINT_USER_LOTTO_COUNT, lottoList.size());
		for (Lotto lotto : lottoList) {
			System.out.println(lotto);
		}
	}

	private WinningLotto getWinningLotto() {
		Lotto lotto = new Lotto(userInput.getWinningNumber());
		WinningLotto winningLotto = new WinningLotto(lotto, userInput.getBonusBall(lotto));
		return winningLotto;
	}

	public void start() {
		getLottoList();
		printLottoList();
		getWinningLotto();
	}
}
