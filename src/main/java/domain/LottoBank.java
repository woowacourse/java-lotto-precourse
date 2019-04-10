package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LottoBank {
	
	private WinningLotto winLotto;
	private LottoShop lottoShop;
	private Scanner sc;
	private List<Integer> winnerLottoNumbers;
	
	public LottoBank(LottoShop lottoShop) {
		sc = new Scanner(System.in);
		this.lottoShop = lottoShop;
		winnerLottoNumbers = new ArrayList<Integer>();
	}

	public void setWinningLotto() {
		try {
			System.out.println(RequestMsg.WinningLotto.getMsg());
			parseWinnerLottoNums(checkValid(sc.nextLine()));
			System.out.println(RequestMsg.BonusNum.getMsg());
			bonusNo = checkValid(sc.nextInt());
		} catch (InputMismatchException e) {
			printAndfixErr(ErrMsg.InputMismatchErr.getMsg());
		}
		winLotto = new WinningLotto(new Lotto(winnerLottoNumbers), bonusNo);
	}
}
