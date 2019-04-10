package domain;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoShop {
	private List<Integer> pickedNumbers;
	private List<Lotto> userLottos;
	private int numOfLotto;
	private Scanner sc;

	public LottoShop() {
		userLottos = new ArrayList<Lotto>();
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
	
	public void buyLotto() {
		for (int i = 0; i < numOfLotto; i++) {
			pickedNumbers = new Random().ints(LottoRule.BEGINNUM.getNum(), LottoRule.ENDNUM.getNum()).distinct()
					.limit(LottoRule.LottoLENGTH.getNum()).boxed().collect(Collectors.toList());
			userLottos.add(new Lotto(pickedNumbers));
		}
		printLottos();
	}
	
	private void printLottos() {
		System.out.println(numOfLotto + RequestMsg.Result.getMsg());
		for (Lotto lotto : userLottos) {
			lotto.printLotto();
		}
	}
	
	public List<Lotto> getUserLottos() {
		return userLottos;
	}
}
