package domain;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LottoShop {
	private int numOfLotto;
	private Scanner sc;

	public LottoShop() {
		sc = new Scanner(System.in);
	}

	public void setNumOfLotto() {
		try {
			System.out.println(RequestMsg.SetNum.getMsg());
			numOfLotto = checkValid(sc.nextInt()) / LottoRule.PRICE.getNum();
		} catch (InputMismatchException e) {
			printAndfixErr(ErrMsg.InputMismatchErr.getMsg());
		}
	}
}
