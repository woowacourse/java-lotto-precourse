package domain;

import java.util.ArrayList;
import java.util.Scanner;

public class Playgame {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String buyMoney;
		int lottoCount = 0;

		/*구입금액 입력 검사*/
		while (true) {

			System.out.println("구입금액을 입력해 주세요.");
			buyMoney = scan.nextLine();

			if (checkInputMoney(buyMoney))
				break;
		}

		lottoCount = Integer.parseInt(buyMoney) / 1000;
		System.out.println();
		System.out.println(lottoCount + "개를 구매했습니다.");

		ArrayList<Integer> list;
		ArrayList<Lotto> lottoList = new ArrayList<>();
		
		Lotto lotto;

		for (int i = 0; i < lottoCount; i++) {

			list = new ArrayList<>();
			lotto = new Lotto(list);

			lotto.createLottoNumber();
			lotto.printlotto();
			lottoList.add(lotto);
		}

		/*당첨 번호 입력 검사*/
		while (true) {

			System.out.println("지난 주 당첨 번호를 입력해 주세요.");
			String inputWinningLotto = scan.nextLine();
			String[] str = split(inputWinningLotto);
			if (checkInputWinningLotto(str)) {
				break;
			}
		}

		/*보너스 볼 입력 검사*/
		while (true) {

			System.out.println("보너스 볼을 입력해 주세요.");
			String bonusNo = scan.nextLine();
			if (checkBonusNo(bonusNo)) {
				break;
			}
		}

	}

	private static boolean checkBonusNo(String bonusNo) {

		try {		
			int number = Integer.parseInt(bonusNo);
			if (number < 0 || number > 45)
				return false;

		} catch (Exception e) {

			return false;
		}

		return true;
	}

	private static String[] split(String inputWinningLotto) {

		String[] winningLotto = inputWinningLotto.split(",");
		return winningLotto;
		
	}

	private static boolean checkInputWinningLotto(String[] str) {

		if (str.length == 5) {

			for (int i = 0; i < str.length; i++) {

				try {
					Integer.parseInt(str[i]);
				} catch (Exception e) {
					return false;
				}
			}
			return true;
		}

		return false;
	}

	private static boolean checkInputMoney(String buyMoney) {

		try {
			int number = Integer.parseInt(buyMoney);
			if (number < 1000) 
				return false;
		} catch (Exception e) {
			return false; 
			}
		return true;
	}

}
