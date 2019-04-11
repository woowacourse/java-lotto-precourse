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
		
		public static void printInputPurchasePrice() {
				System.out.println(INPUT_PURCHASE_PRICE);			
		}
}





