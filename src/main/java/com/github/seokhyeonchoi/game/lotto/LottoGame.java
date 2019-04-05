package com.github.seokhyeonchoi.game.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.github.seokhyeonchoi.game.Game;

public class LottoGame implements Game {
	private final int LEAST_PURCHASE_AMOUNT = 1000;
	private final Scanner SCANNER = new Scanner(System.in);
	
	private List<Lotto> lottoNums;
	private int purchaseAmount;
	private WinningLotto winningLotto;

	public LottoGame() {
		lottoNums = new ArrayList<Lotto>();
		init();
	}

	@Override
	public void start() {

	}

	private void init() {

	}

	private int inputPurchaseAmount() {
		int amount = 0;
		
		while(!validPurchaseAmount(amount)) {
			amount = SCANNER.nextInt();
		}
		
		return amount;
	}

	private boolean validPurchaseAmount(int amount) {
		return (amount >= LEAST_PURCHASE_AMOUNT);
	}
}
