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
	private final int MIN_MONEY = 1000;
	private final int LOTTO_PRICE = 1000;
	private final String REQUEST_MONEY = "구입 금액을 입력해 주세요.";
	private final String REQUEST_MONEY_OVER_MINIMUM = String.format("%d원 이상 입력해 주세요.", MIN_MONEY);

	private User user;

	public LottoGame(User user) {
		this.user = user;
	}

	public void play() {
		int receivedMoney;

		System.out.println(REQUEST_MONEY);
		while ((receivedMoney = user.insertMoney()) < MIN_MONEY) {
			System.out.println(REQUEST_MONEY_OVER_MINIMUM);
		}
	}

	private int maximumNumberOfLotto(int money) {
		return money / LOTTO_PRICE;
	}
}
