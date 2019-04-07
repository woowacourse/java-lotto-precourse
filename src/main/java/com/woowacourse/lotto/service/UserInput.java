/*
 *  클래스 이름 : UserInput.java
 *
 *  버전 정보 : 1.0.0
 *
 *  날짜 : 2019-04-07
 *
 *  저작권 : 이예지
 */
package com.woowacourse.lotto.service;

import java.util.Scanner;

public class UserInput {
	static final String DEMAND_PURCHASING_AMOUNT = "구입금액을 입력해주세요.";

	private String inputValue() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	public int getPurchasingAmount() {

		System.out.println(DEMAND_PURCHASING_AMOUNT);
		String amount = inputValue();

		return Integer.parseInt(amount);
	}

}