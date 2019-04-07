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

public class Validator {

	static public boolean checkPurchasingAmountValid(String amount) {
		if (!amount.matches("[1-9][0-9]+")) {
			return false;
		}
		if (Integer.parseInt(amount) < 1000) {
			return false;
		}
		return true;
	}
}