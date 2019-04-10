/*
 * DuplicateException
 * 
 * version 1.0
 * 
 * 2019. 4. 10
 * 
 * Created by Wongeun Song
 */
package edu.yk1028.Exception;

public class DuplicateException extends RuntimeException {
	private final String DUPLICATE_MESSAGE = "중복입니다.";

	public DuplicateException() {
		super();
		System.out.println(DUPLICATE_MESSAGE);
	}
}
