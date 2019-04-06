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

import java.util.List;
import java.util.Scanner;

/**
 * 로또를 구매하는 사용자 객체
 * 
 * @author wongeunsong
 *
 */
public class User {
	List<Lotto> lottos;
	
	public int insertMoney() {
		Scanner scanner = new Scanner(System.in);

		while (!scanner.hasNextInt()) {
			scanner.next();
			System.out.println("정수가 아닙니다.");
		}
		return scanner.nextInt();
	}
	
	public void receiveLottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}
}
