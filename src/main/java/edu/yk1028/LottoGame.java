/*
 * LottoGame
 * 
 * version 1.0
 * 
 * 2019. 4. 7
 * 
 * Created by Wongeun Song
 */

package edu.yk1028;

import java.util.List;
import java.util.Scanner;

/**
 * 로또 당첨을 담당하는 객체
 */
public class LottoGame {
	private final int NUMBER_OF_LOTTO_NUMBERS = 6;
	private final String NUMBER_SEPARATOR = ",";
	private final String REQUEST_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
	private final String REQUEST_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
	private final String WRONG_INPUT = "1~45사이의 중복되지 않은 6개의 수를 입력해 주세요. 콤마(,)로 구분";
	private final String FAIL_GENERATEING_WINNING_LOTTO = "잘못된 당첨 번호입니다.";
	
	private WinningLotto winningLotto;
	
	public boolean generateWinningLotto() {
		try {
			inputWinningNumbers();
		} catch (Exception e) {
			System.out.println(FAIL_GENERATEING_WINNING_LOTTO);
			return false;
		}
		return true;
	}
	
	private String[] inputWinningNumbers() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(REQUEST_WINNING_NUMBERS);
		return scanner.nextLine().split(NUMBER_SEPARATOR);
	}
}
