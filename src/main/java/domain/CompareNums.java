package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CompareNums {
	static Scanner in = new Scanner(System.in);

	private final int LOTTO_NUM_SELECT = 6;

	public int bonusNumber() {
		System.out.println("보너스 볼을 입력해 주세요.");
		int bonusBall = in.nextInt();
		return bonusBall;
	}

	public List<Integer> winningNumber() {
		System.out.println("지난 주 당첨 번호를 입력해 주세요.( 6개, 쉼표(,)로 구분 )");
		List<String> winNums_string = new ArrayList<String>(LOTTO_NUM_SELECT);
		String winNum = in.nextLine();
		winNums_string = Arrays.asList(winNum.split(","));
		List<Integer> winNums_int = new ArrayList<Integer>(LOTTO_NUM_SELECT);
		for (String s : winNums_string)
			winNums_int.add(Integer.parseInt(s));
		return winNums_int;
	}

	public void makeWinningLotto() {
		Lotto winning = new Lotto(winningNumber());
		WinningLotto winningLotto = new WinningLotto(winning, bonusNumber());
	}

}
