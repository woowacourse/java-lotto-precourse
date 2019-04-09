/*
 * @RandomLotto.java	1.00 2019/04/09
 * 
 * Copyright(c)2019		HwiJin Hong.
 * All right reserved.
 * 
 * [ 우아한 테크코스 3주차 미션 ]
 * 로또 게임 프로그램
 */

package domain;

import java.util.LinkedList;
import java.util.List;

/**
 * 로또 객체를 생성시켜주는 클래스
 * 1 ~ 45 까지의 6자리 숫자를 랜덤으로 뽑아서 객체를 생성한다.
 * 
 * @version 1.00 2019년 4월 9일
 * @author 홍휘진
 *
 */
public class RandomLotto {

	private static final int MAX_LOTTO_NUM = 45;

	private static final int MIN_LOTTO_NUM = 1;

	private static final int LOTTO_NUMBERS = 6;

	public Lotto makeRandomLotto() {
		List<Integer> numbers = new LinkedList<>();
		for (int i = 0; i < LOTTO_NUMBERS; i++) {
			numbers.add(makeRandomNumber());
		}
		return new Lotto(numbers);
	}

	private int makeRandomNumber() {
		return (int) (Math.random() * MAX_LOTTO_NUM) + MIN_LOTTO_NUM;
	}

}
