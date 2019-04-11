/*
 * TooMuchMoneyException
 * 
 * version 1.0
 * 
 * 2019. 4. 11
 * 
 * Created by Wongeun Song
 */
package edu.yk1028.Exception;

import edu.yk1028.LottoConstant;

public class TooMuchMoneyException extends RuntimeException {
	private final String TOO_MUCH_MONEY_MESSAGE = LottoConstant.MAX_MONEY + "원 이하만 구매가능합니다.";
	
	public TooMuchMoneyException() {
		super();
		System.out.println(TOO_MUCH_MONEY_MESSAGE);
	}
}
