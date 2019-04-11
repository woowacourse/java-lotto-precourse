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

public class LottoGame {
		private static final String BLANK = "";	
		
		public void runGame() {
				getLottoPurchasePrice();
		}
		
		private void getLottoPurchasePrice() {
				String userPrice = BLANK;
				
				CommandLineInterface.printInputPurchasePrice();
				while (!Validator.isValidPrice(userPrice));
		}
}
