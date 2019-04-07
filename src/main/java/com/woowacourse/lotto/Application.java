/*
 *  클래스 이름 : Application.java
 *
 *  버전 정보 : 1.0.0
 *
 *  날짜 : 2019-04-07
 *
 *  저작권 : 이예지
 */
package com.woowacourse.lotto;

import com.woowacourse.lotto.service.LottoGame;

public class Application {

	public static void main(String[] args) {
		LottoGame lottoGame = new LottoGame();
		lottoGame.start();
	}
}