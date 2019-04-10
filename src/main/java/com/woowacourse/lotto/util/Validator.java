/*
 *  클래스 이름 : Validator.java
 *
 *  버전 정보 : 1.0.0
 *
 *  날짜 : 2019-04-07
 *
 *  저작권 : 이예지
 */
package com.woowacourse.lotto.util;

import java.util.List;
import java.util.stream.Collectors;

import static com.woowacourse.lotto.domain.LottoFactory.LOTTO_PRICE;
import static com.woowacourse.lotto.util.RandomNumber.LOTTO_NUMBER_COUNT;

public class Validator {

	public static boolean checkPurchasingAmountValid(String amount) {
		if (!amount.matches("[1-9][0-9]+")) {
			return false;
		}
		if (Integer.parseInt(amount) < LOTTO_PRICE) {
			return false;
		}
		return true;
	}

	public static boolean checkOverlapNumber(int number, List<Integer> list) {
		if (list.contains(number)) {
			return false;
		}
		return true;
	}

	/* 입력한 숫자가 6개인지, 1이상 45이하의 숫자인지, 입력한 숫자 중에서 중복되는 수는 없는지 확인하는 메소드*/
	public static boolean checkWinningNumberListValid(List<String> winningNumberList) {
		if (winningNumberList.size() != LOTTO_NUMBER_COUNT) {
			return false;
		}

		if (!checkRangeWinningNumberList(winningNumberList)) {
			return false;
		}

		if (!checkOverlapNumberList(winningNumberList)) {
			return false;
		}
		return true;
	}

	public static boolean checkOverlapNumberList(List<String> winningNumberList) {
		if (winningNumberList.stream().distinct().collect(Collectors.toList()).size() != LOTTO_NUMBER_COUNT) {
			return false;
		}
		return true;
	}

	public static boolean checkRangeWinningNumberList(List<String> numberList) {
		boolean result = numberList.stream().allMatch(s -> s.matches("[1-9]|[1-3][0-9]|[4][0-5]"));
		return result;
	}


}