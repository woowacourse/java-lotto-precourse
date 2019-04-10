/*
 * OutOfRangeException
 * 
 * version 1.0
 * 
 * 2019. 4. 10
 * 
 * Created by Wongeun Song
 */
package edu.yk1028.Exception;

import edu.yk1028.LottoConstant;

public class OutOfRangeException extends RuntimeException {
	private final String OUT_OF_RANGE_MESSAGE = "범위를 벗어났습니다.("
													+ LottoConstant.MINIMUM_RANGE_OF_LOTTO_NUMBER
													+ " ~ "
													+ LottoConstant.MAXIMUM_RANGE_OF_LOTTO_NUMBER
													+ ")";
	
	public OutOfRangeException() {
		super();
		System.out.println(OUT_OF_RANGE_MESSAGE);	
	}
}
