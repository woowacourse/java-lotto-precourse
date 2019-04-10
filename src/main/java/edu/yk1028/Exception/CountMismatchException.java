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

public class CountMismatchException extends RuntimeException {
	private final String COUNT_MISMATCH_MESSAGE = "개수가 맞지 않습니다.(6자리)";

	public CountMismatchException() {
		super();
		System.out.println(COUNT_MISMATCH_MESSAGE);
	}
}
