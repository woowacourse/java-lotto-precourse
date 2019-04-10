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
	private HashMap<Integer, Integer> matchResults;
	private int bonusNo;
	
	public LottoBank(LottoShop lottoShop) {
		sc = new Scanner(System.in);
		this.lottoShop = lottoShop;
		winnerLottoNumbers = new ArrayList<Integer>();
		matchResults = new HashMap<Integer, Integer>();
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
	
	private String checkValid(String winnerNums) {
		if(winnerNums.split(",").length != LottoRule.LottoLENGTH.getNum()) 
			printAndfixErr(ErrMsg.NumLengthErr.getMsg());
		for(String winnerNum : winnerNums.split(",")) {
			try {
				if((Integer.parseInt(winnerNum) < LottoRule.BEGINNUM.getNum()) || (Integer.parseInt(winnerNum) > LottoRule.ENDNUM.getNum())) 
					printAndfixErr(ErrMsg.OutOfRangeErr.getMsg());
			} catch(NumberFormatException e) {
				printAndfixErr(ErrMsg.InputMismatchErr.getMsg());
			}
		}
		return winnerNums;
	}
	
	private int checkValid(int bonusNo) {
		if((bonusNo < LottoRule.BEGINNUM.getNum()) || (bonusNo > LottoRule.ENDNUM.getNum())) {
			printAndfixErr(ErrMsg.OutOfRangeErr.getMsg());
		}
		return bonusNo;
	}
	
	private void printAndfixErr(String ErrMsg) {
		System.out.println(ErrMsg);
		setWinningLotto();
	}
	
	private void parseWinnerLottoNums(String winnerNums) {
		for (String winnerNum : winnerNums.split(",")) {
			winnerLottoNumbers.add(Integer.parseInt(winnerNum));
		}
	}
	
	public void matchUserLotto() {
		for (Lotto userLotto : lottoShop.getUserLottos()) {
			int matchReward = winLotto.match(userLotto).getWinningMoney();
			if (!matchResults.containsKey(matchReward))
				matchResults.put(matchReward, 1);
			else if (matchResults.containsKey(matchReward))
				matchResults.replace(matchReward, matchResults.get(matchReward) + 1);
		}
		showMatchResult();
	}	
	
	private void showMatchResult() {
		for (int i = 0; i < LottoRule.REWARDS.getNums().length; i++) {
			if (matchResults.containsKey(LottoRule.REWARDS.getNums()[i])) {
				System.out.print(LottoRule.RANKNAMES.getNames()[i]);
				System.out.println(matchResults.get(LottoRule.REWARDS.getNums()[i]) + "개");
			} else {
				System.out.print(LottoRule.RANKNAMES.getNames()[i]);
				System.out.println(0 + "개");
			}
		}
	}
	
	public void calUserProfit() {
		double totalProfit = 0;
		for (int lottoReward : LottoRule.REWARDS.getNums()) {
			if (matchResults.containsKey(lottoReward)) {
				totalProfit = totalProfit + matchResults.get(lottoReward) * lottoReward;
			}
		}
		totalProfit = totalProfit / (lottoShop.getUserLottos().size() * LottoRule.PRICE.getNum());
		System.out.println("총 수익률은 " + totalProfit + " 입니다.");
	}
}
