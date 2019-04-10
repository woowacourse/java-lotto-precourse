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

public class OutOfRangeException extends RuntimeException {
	private final String OUT_OF_RANGE_MESSAGE = "범위를 벗어났습니다.(1 ~ 45)";
	
	public OutOfRangeException() {
		super();
		System.out.println(OUT_OF_RANGE_MESSAGE);	
	}
}
