/*
 * @(#)CommandLineInterface.java		2019/4/11
 * 
 * Copyright (c) 2019 Junmo Han.
 * All rights reserved.
 */

/**
 * CommandLineInterface 클래스는 Console 창에 정보를 출력하여 사용자와 상호작용을 하는 기능을 합니다. 
 * 
 * @version			1.00 2019년 4월 11일
 * @author 			한준모
 */

package domain;

public class CommandLineInterface {
		private static final String INPUT_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
		private static final String NUMBER_ERROR = "숫자로 이루어진 값을 하나만 입력해 주세요.(','를 제거해주세요.)";
		private static final String PRICE_RANGE_ERROR = Validator.MIN_PURCHASE_AMOUNT
													  + " 이상 "
													  + Validator.MAX_PURCHASE_AMOUNT
													  + " 이하의 값을 입력해 주세요.";
		
		public static void printInputPurchasePrice() {
				System.out.println(INPUT_PURCHASE_PRICE);			
		}
		
		public static void printPurchasePrcieNumberError() {
				System.out.println(NUMBER_ERROR);
		}
		
		public static void printPurchasePriceRangeError() {
				System.out.println(PRICE_RANGE_ERROR);
		}
}