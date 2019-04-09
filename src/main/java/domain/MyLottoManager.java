/*
 * @MyLottoManager.java	1.00 2019/04/10
 * 
 * Copyright(c)2019		HwiJin Hong.
 * All right reserved.
 * 
 * [ 우아한 테크코스 3주차 미션 ]
 * 로또 게임 프로그램
 */

package domain;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 내 로또를 매니지먼트 하는 클래스
 * 
 * @version 1.00 2019년 4월 10일
 * @author 홍휘진
 *
 */
public class MyLottoManager {

	private static final String MONEY_INSUFFICIENT = "돈이 부족해서 로또를 살 수 없습니다.";
	
	private static final String BUY_MESSAGE = "개를 구매했습니다.";
	
	private static final int EXIT_CODE = 0;
	
	private static final int LOTTO_PRICE = 1000;
	
	private RandomLotto randomLotto;
	
	private List<Lotto> lottoList;
	
	private int lottoListSize;

	public MyLottoManager() {
		lottoList = new LinkedList<>();
		randomLotto = new RandomLotto();
	}

	public void buyLotto(int money) {
		if (notEnoughMoney(money)) {
			System.out.println(MONEY_INSUFFICIENT);
			System.exit(EXIT_CODE);
		}
		lottoListSize = money / LOTTO_PRICE;
		System.out.println(lottoListSize + BUY_MESSAGE);
		addLottoToList();
	}

	private void addLottoToList() {
		for (int i = 0; i < lottoListSize; i++) {
			Lotto lotto = randomLotto.makeRandomLotto();
			lottoList.add(lotto);
			System.out.println(lotto);
		}
	}

	private boolean notEnoughMoney(int money) {
		return (money < LOTTO_PRICE) ? true : false;
	}
	
	public HashMap<Rank, Integer> matchWithWinningLotto(WinningLotto winningLotto) {
		HashMap<Rank, Integer> rankList = new HashMap<>();
		initRankList(rankList);
		Rank rank;
		for (Lotto lotto : lottoList) {
			rank = winningLotto.match(lotto);
			rankList.replace(rank, rankList.get(rank) + WinningLotto.MATCH);
		}
		return rankList;
	}

	private void initRankList(HashMap<Rank, Integer> rankList){
		for (Rank rank : Rank.values()){
			rankList.put(rank, WinningLotto.NOT_MATCH);
		}
	}
}
