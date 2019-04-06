/*
 * User
 * 
 * version 1.0
 * 
 * 2019. 4. 6
 * 
 * Created by Wongeun Song
 */

package edu.yk1028;

import java.util.Scanner;

/**
 * 로또를 구매하는 사용자 객체
 * 
 * @author wongeunsong
 *
 */
public class User {
	public int inputMoney() {
		Scanner scanner = new Scanner(System.in);

		return scanner.nextInt();
	}
}
