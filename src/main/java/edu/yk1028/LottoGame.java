/*
 * LottoGame
 * 
 * version 1.0
 * 
 * 2019. 4. 6
 * 
 * Created by Wongeun Song
 */

package edu.yk1028;

/**
 * 로또 게임을 진행하는 객체
 * 
 * @author wongeunsong
 *
 */
public class LottoGame {
	private final String REQUEST_INPUT_MONEY = "구입 금액을 입력해 주세요.";

	private User user;

	public LottoGame(User user) {
		this.user = user;
	}

	public void play() {
		int receivedMoney;

		System.out.println(REQUEST_INPUT_MONEY);
		receivedMoney = user.inputMoney();
	}
}
