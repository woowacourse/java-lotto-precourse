package domain;

import java.util.Scanner;

/*
 * 지난 주 당첨 번호와 보너스 볼을 입력받아 당첨 로또를 생성하는 객체
 */
public class WinningLottoGenerator {
	Scanner scanner = new Scanner(System.in);

	private String inputWinningNumbersFromUser() {
		System.out.println("지난 주 당첨 번호를 입력해주세요.");
		return scanner.next();
	}
}
