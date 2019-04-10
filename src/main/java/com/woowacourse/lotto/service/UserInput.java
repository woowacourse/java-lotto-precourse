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

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.woowacourse.lotto.util.Validator;

public class UserInput {
	static final String DEMAND_PURCHASING_AMOUNT = "구입금액을 입력해주세요.";
	static final String DEMAND_USER_INPUT_AGAIN = "올바르지 않은 값입니다. 다시 입력해주세요.";
	static final String DEMAND_WINNING_NUMBER = "지난 주 당첨 번호를 입력해주세요.";

	private String inputValue() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

	public int getPurchasingAmount() {
		String amount;
		boolean result;

		System.out.println(DEMAND_PURCHASING_AMOUNT);
		do {
			amount = inputValue();
			result = getAmountValidResult(amount);
		}
		while (!result);
		return Integer.parseInt(amount);
	}

	private boolean getAmountValidResult(String amount) {
		if (!Validator.checkPurchasingAmountValid(amount)) {
			printUserInputAgain();
			return false;
		}
		return true;
	}

	private void printUserInputAgain() {
		System.out.println(DEMAND_USER_INPUT_AGAIN);
	}

	public List<Integer> getWinningNumber() {
		boolean result;
		List<String> winnigNumberList;
		System.out.println(DEMAND_WINNING_NUMBER);
		do{
			winnigNumberList = Arrays.asList(inputValue().split(","));
			result = getWinningNumberValidResult(winnigNumberList);
		}while(!result);
		return winnigNumberList.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
	}

	private boolean getWinningNumberValidResult(List<String> winnigNumberList){
		if(!Validator.checkWinningNumberListValid(winnigNumberList)){
			printUserInputAgain();
			return false;
		}
		return true;
	}

}