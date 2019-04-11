/*
 * @(#)LottoGame.java		2019/4/11
 * 
 * Copyright (c) 2019 Junmo Han.
 * All rights reserved.
 */

/**
 * LottoGame 클래스는 로또 게임이 전체적으로 진행되도록 합니다. 
 * 
 * @version			1.00 2019년 4월 11일
 * @author 			한준모
 */

package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoGame {
		private static final String BLANK = "";	
		private static int theNumberOfLottoTicket;
		private WinningLotto winningLotto;
		
		private List<Lotto> lottoTicket = new ArrayList<Lotto>();
		private static Scanner SCANNER = new Scanner(System.in);
		
		public void runGame() {
				getLottoPurchasePrice();
				notifyUserTheNumberOfLottoTicketAndNumbers();
				prepareWinningNumbers();
		}
		
		private void getLottoPurchasePrice() {
				String userPrice = BLANK;
				
				CommandLineInterface.printInputPurchasePrice();
				while (!Validator.isValidPrice(userPrice));
		}

		private void notifyUserTheNumberOfLottoTicketAndNumbers() {
				theNumberOfLottoTicket = Validator.purchasePrice 
										/ Validator.UNIT_PRICE_OF_LOTTO;
				
				LottoNumberGenerator.makeLottoNumbers();
				for (int i = 0; i < theNumberOfLottoTicket; i++) {
						List<Integer> lottoNumbers = LottoNumberGenerator.makeLottoNumbers();
						lottoTicket.add(new Lotto(lottoNumbers));
				}
				CommandLineInterface.printTheNumberOfLottoPurchase(theNumberOfLottoTicket);
				CommandLineInterface.printLottoTicket(lottoTicket);
		}

		private void prepareWinningNumbers() {
				List<Integer> winningNumbers = getWinningNumbers();
				int bonusBall = getBonusBall();
				Lotto luckyLotto = new Lotto(winningNumbers);
				winningLotto = new WinningLotto(luckyLotto, bonusBall);
		}

		private List<Integer> getWinningNumbers() {
				String userWinningNums = BLANK;
				
				CommandLineInterface.printInputWinningNumber();
				while(!Validator.isValidWinningNumber(userWinningNums));
				
				return Validator.winningNums;
		}
		
		private int getBonusBall() {
				String userBonusBall = BLANK;
				
				CommandLineInterface.printInputBonusBall();
				while(!Validator.isValidBonusBall(userBonusBall));
				SCANNER.close();
				
				return Validator.bonusBall;
		}
}
