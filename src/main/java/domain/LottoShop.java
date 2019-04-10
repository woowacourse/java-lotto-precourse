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
	
	private int checkValid(int userMoney) {
		if (userMoney < 0) {
			printAndfixErr(ErrMsg.InputTooSmallErr.getMsg());
		} else if (userMoney < LottoRule.PRICE.getNum()) {
			printAndfixErr(ErrMsg.NotEnoughMoneyErr.getMsg());
		}
		return userMoney;
	}
	
	private void printAndfixErr(String errMsg) {
		System.out.println(errMsg);
		if (errMsg.equals(ErrMsg.InputMismatchErr.getMsg()))
			sc.next();
		setNumOfLotto();
	}
}
