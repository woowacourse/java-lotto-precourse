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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * 로또 게임을 진행하는 객체
 * 
 * @author wongeunsong
 *
 */
public class LottoGame {
	private final int MIN_MONEY = 1000;
	private final int LOTTO_PRICE = 1000;
	private final int NUMBER_OF_LOTTO_NUMBERS = 6;
	private final int BOUND_OF_LOTTO_NUMBER = 45;
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
		user.receiveLottos(generateLotto(maximumNumberOfLotto(receivedMoney)));
	}

	private int maximumNumberOfLotto(int money) {
		return money / LOTTO_PRICE;
	}

	private List<Lotto> generateLotto(int count) {
		List<Lotto> lottoList = new ArrayList<Lotto>();

		for (int i = 0; i < count; i++) {
			lottoList.add(new Lotto(generateLottoNumbers()));
		}
		return lottoList;
	}

	private List<Integer> generateLottoNumbers() {
		List<Integer> numberList = new ArrayList<Integer>();
		Set<Integer> numberSet = new HashSet<Integer>();
		Random random = new Random();

		for (; numberSet.size() < NUMBER_OF_LOTTO_NUMBERS;
					numberSet.add(random.nextInt(BOUND_OF_LOTTO_NUMBER) + 1));
		numberList.addAll(numberSet);
		return numberList;
	}
}
