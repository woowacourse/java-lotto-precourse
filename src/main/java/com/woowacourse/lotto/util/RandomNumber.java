/*
 *  클래스 이름 : RandomNumber.java
 *
 *  버전 정보 : 1.0.0
 *
 *  날짜 : 2019-04-07
 *
 *  저작권 : 이예지
 */
package com.woowacourse.lotto.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumber {
	static final int LOTTO_MAX_NUMBER = 45;
	static final int NUMBER_COUNT = 6;

	public List<Integer> createNumberList() {
		List<Integer> lottoNumberList = new ArrayList<>();

		for (int i = 0; i < NUMBER_COUNT; ++i) {
			addRandomNumber(lottoNumberList);
		}
		return lottoNumberList;
	}

	private void addRandomNumber(List<Integer> list) {
		Random random = new Random();
		int randomNumber = random.nextInt(LOTTO_MAX_NUMBER) + 1;

		list.add(randomNumber);
	}

}
