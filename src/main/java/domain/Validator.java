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
		private static final int DIVISIBLE = 0;
		private static final int FIRST_CHAR = 0;
		private static final int UNIT_WON = 1; 
		
		public static List<Integer> winningNums = new ArrayList<Integer>();
		private static Scanner SCANNER = new Scanner(System.in);		
		
		public static boolean isValidPrice(String userPrice) {
				try {
						userPrice = SCANNER.nextLine().trim();
						userPrice = isValidPurchasePriceAddedUnit(userPrice).trim();
						purchasePrice = Integer.parseInt(userPrice);
						return isValidPurchasePriceException(purchasePrice);
						
				} catch (NumberFormatException e) {
						CommandLineInterface.printPurchasePrcieNumberError();
						return false;
				}
		}
		
		/**
		 * 사용자로부터 입력받은 값에 '원'이라는 단위가 있는지 확인합니다.
		 */
		private static String isValidPurchasePriceAddedUnit(String userPrice) {
				if (userPrice.substring(userPrice.length()-UNIT_WON).equals("원")) {
						return (String) userPrice.substring(FIRST_CHAR, userPrice.length()-UNIT_WON);
				}
				return userPrice;
		}
		
		private static boolean isValidPurchasePriceException(int purchasePrice) {
			return (isValidPurchasePriceRange(purchasePrice)
					&& isDivisiblePurchasePriceByUnit(purchasePrice));
		}

		private static boolean isValidPurchasePriceRange(int purchasePrice) {
				if (MIN_PURCHASE_AMOUNT <= purchasePrice 
						&& purchasePrice <= MAX_PURCHASE_AMOUNT) {
					return true;
				}
				CommandLineInterface.printPurchasePriceRangeError();
				return false;
		}

		private static boolean isDivisiblePurchasePriceByUnit(int purchasePrice) {
				if (purchasePrice % UNIT_PRICE_OF_LOTTO == DIVISIBLE) {
						return true;
				}
				CommandLineInterface.printIndivisiblePurchasePriceError();
				return false;
		}
		
		public static boolean isValidWinningNumber(String userWinningNums) {
				try {
						userWinningNums = SCANNER.nextLine();
						String[] tmpWinningNums = userWinningNums.split(",");
						winningNums = isComposedNum(tmpWinningNums);
						return isValidWinningNumException(winningNums);
						
				} catch (NumberFormatException e) {
						CommandLineInterface.printWinningNumberError();
						return false;
				}
		}

		private static List<Integer> isComposedNum(String[] tmpWinningNums) {
				winningNums = new ArrayList<Integer>();
				
				for (int i = 0; i < tmpWinningNums.length; i++) {
						String elementString = tmpWinningNums[i].trim();
						int element = Integer.parseInt(elementString);
						winningNums.add(element);
						Collections.sort(winningNums);
				}
				return winningNums;
		}

		private static boolean isValidWinningNumException(List<Integer> winningNums) {
				return isValidWinningNumCount(winningNums) 
						&& isValidWinningNumRange(winningNums)
						&& isThereWinningNumDuplication(winningNums);
		}
}