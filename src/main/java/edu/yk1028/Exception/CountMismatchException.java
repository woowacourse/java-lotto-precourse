/*
 * CountMismatchException
 * 
 * version 1.0
 * 
 * 2019. 4. 10
 * 
 * Created by Wongeun Song
 */
package edu.yk1028.Exception;

import edu.yk1028.LottoConstant;

public class CountMismatchException extends RuntimeException {
	private final String COUNT_MISMATCH_MESSAGE = "개수가 맞지 않습니다.(" 
													+ LottoConstant.NUMBER_OF_LOTTO_NUMBERS 
													+ "자리)";

	public CountMismatchException() {
		super();
		System.out.println(COUNT_MISMATCH_MESSAGE);
	}
}
