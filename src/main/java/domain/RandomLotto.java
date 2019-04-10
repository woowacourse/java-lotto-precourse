/*
 * @RandomLotto.java	1.02 2019/04/11
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
 * @version 1.02 2019년 4월 11일
 * @author 홍휘진
 *
 */
public class RandomLotto {

	public static Lotto makeRandomLotto() {
		List<Integer> numbers;
		do {
			numbers = makeLottoNumber();
		} while (Lotto.duplicateNumberInLotto(numbers));
		return new Lotto(numbers);
	}

	private static List<Integer> makeLottoNumber() {
		List<Integer> numbers = new LinkedList<>();
		for (int i = 0; i < Lotto.LOTTO_NUMBER_SIZE; i++) {
			numbers.add(makeRandomNumber());
		}
		return numbers;
	}

	private static int makeRandomNumber() {
		return (int) (Math.random() * Lotto.MAX_LOTTO_NUM) + Lotto.MIN_LOTTO_NUM;
	}
}
