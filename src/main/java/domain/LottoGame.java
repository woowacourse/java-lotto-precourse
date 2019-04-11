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

public class LottoGame {
		private static final String BLANK = "";	
		private static int theNumberOfLottoTicket;
		
		private List<Lotto> lottoTicket = new ArrayList<Lotto>();
		
		public void runGame() {
				getLottoPurchasePrice();
				notifyUserTheNumberOfLottoTicketAndNumbers();
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
}
