/*
 * @(#)Validator.java		2019/4/11
 * 
 * Copyright (c) 2019 Junmo Han.
 * All rights reserved.
 */

/**
 * Validator 클래스는 사용자로부터 입력받는 숫자들의 유효성을 검사하는 기능을 합니다.
 * 
 * @version			1.00 2019년 4월 11일
 * @author 			한준모
 */

package domain;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.TreeSet;

public class Validator {
		public static final int MIN_PURCHASE_AMOUNT = 1000;
		public static final int MAX_PURCHASE_AMOUNT = 100000;
		public static final int UNIT_PRICE_OF_LOTTO = 1000;
		public static final int MIN_RANDOM_NUMBER = LottoNumberGenerator.MIN_RANDOM_NUMBER;
		public static final int MAX_RANDOM_NUMBER = LottoNumberGenerator.MAX_RANDOM_NUMBER;
		public static final int LIST_FIRST_ELEMENT = 0;
		public static final int LIST_LAST_ELEMENT = 5;
		public static int purchasePrice;
		public static int bonusBall;
		
		public static List<Integer> winningNums = new ArrayList<Integer>();
		private static Scanner SCANNER = new Scanner(System.in);		
		
		
		public static boolean isValidPrice(String userPrice) {
				try {
						userPrice = SCANNER.nextLine().trim();
						purchasePrice = Integer.parseInt(userPrice);
						return isValidPurchasePriceException(purchasePrice);
						
				} catch (NumberFormatException e) {
						CommandLineInterface.printPurchasePrcieNumberError();
						return false;
				}	
		}
}