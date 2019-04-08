package domain;

import java.util.Scanner;

public class Playgame {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String buyMoney;
		int lottoCount = 0;

		while (true) {

			System.out.println("구입금액을 입력해 주세요.");
			buyMoney = scan.nextLine();

			if (inputMoney(buyMoney))
				break;
		}
		
		lottoCount = Integer.parseInt(buyMoney) / 1000;
		System.out.println();
		System.out.println(lottoCount + "개를 구매했습니다.");
		
	}

	private static boolean inputMoney(String buyMoney) {

		try {
			int number = Integer.parseInt(buyMoney);
			
			if(number < 1000)
				return false;
			
		} catch (Exception e) {

			return false;
		}

		return true;
	}

}
