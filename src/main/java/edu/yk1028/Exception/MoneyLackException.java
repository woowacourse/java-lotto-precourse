/*
 * MoneyLackException
 * 
 * version 1.0
 * 
 * 2019. 4. 10
 * 
 * Created by Wongeun Song
 */
package edu.yk1028.Exception;

import edu.yk1028.LottoConstant;

public class MoneyLackException extends RuntimeException {
	private final String MONEY_LACK_MESSAGE = "돈이 부족합니다. (최소 금액: "
													+ LottoConstant.MIN_MONEY
													+ "원)";
	
	public MoneyLackException() {
		super();
		System.out.println(MONEY_LACK_MESSAGE);
	}
}
