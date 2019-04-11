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

import java.util.List;

public class CommandLineInterface {
		private static final String INPUT_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
		private static final String NUMBER_ERROR = "숫자로 이루어진 값을 하나만 입력해 주세요.(','를 제거해주세요.)";
		private static final String PRICE_RANGE_ERROR = Validator.MIN_PURCHASE_AMOUNT
													  + " 이상 "
													  + Validator.MAX_PURCHASE_AMOUNT
													  + " 이하의 값을 입력해 주세요.";
		private static final String INDIVISIBLE_PRICE_ERROR 
												= Validator.UNIT_PRICE_OF_LOTTO
												+ " 단위의 값을 입력해 주세요.";
		private static final String PREDICATE_OF_LOTTO_PURCHASE = "개를 구매했습니다.";
		private static final String SPACING_ONE_LINE = "\n";
		private static final String INPUT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
		private static final String WINNING_NUMBER_ERROR = "올바른 당첨 번호를 입력해 주세요.";
		private static final String WINNING_NUMBER_COUNT_ERROR = "6개의 당첨 번호를 입력해 주세요.";
		private static final String NUMBER_RANGE_ERROR 
												= LottoNumberGenerator.MIN_RANDOM_NUMBER 
												+ " 이상 "
												+ LottoNumberGenerator.MAX_RANDOM_NUMBER
												+ " 이하의 번호를 입력해 주세요.";
		private static final String NUMBER_DUPLICATION_ERROR 
													= "중복되지 않은 번호를 입력해 주세요.";
		private static final String INPUT_BONUS_BALL = "보너스 볼을 입력해 주세요.";
		private static final String TITLE_WIN_STATICS = "당첨 통계\n---------";
		private static final String STATIC_STRING_1_1= "개 일치, 보너스볼 일치(";
		private static final String STATIC_STRING_1_2= "개 일치 (";
		private static final String STATIC_STRING_2= "원) - ";
		private static final String STATIC_STRING_3= "개";
		private static final String STATIC_STRING_4= "총 수익률은 ";
		private static final String STATIC_STRING_5= "입니다.";
		private static final String STRING_FORMATTING = "%,.3f";
		
		public static void printInputPurchasePrice() {
				System.out.println(INPUT_PURCHASE_PRICE);			
		}
		
		public static void printPurchasePrcieNumberError() {
				System.out.println(NUMBER_ERROR);
		}
		
		public static void printPurchasePriceRangeError() {
				System.out.println(PRICE_RANGE_ERROR);
		}
		
		public static void printIndivisiblePurchasePriceError() {
				System.out.println(INDIVISIBLE_PRICE_ERROR);
		}
		
		public static void printTheNumberOfLottoPurchase(int theNumberOfLottoTicket) {
				System.out.println(SPACING_ONE_LINE + theNumberOfLottoTicket 
									+ PREDICATE_OF_LOTTO_PURCHASE);
		}
		
		public static void printLottoTicket(List<Lotto> lottoTicket) { 
				for (Lotto lottoLine : lottoTicket) {
						System.out.println(lottoLine.getNumbers());
				}
				System.out.println(SPACING_ONE_LINE);
		}
		
		public static void printInputWinningNumber() {
				System.out.println(INPUT_WINNING_NUMBER);
		}
		
		public static void printWinningNumberError() {
				System.out.println(WINNING_NUMBER_ERROR);
		}
		
		public static void printWinningNumberCountError() {
				System.out.println(WINNING_NUMBER_COUNT_ERROR);
		}
		
		public static void printWinningNumberRangeError() {
				System.out.println(NUMBER_RANGE_ERROR);
		}
		
		public static void printWinningNumberDuplicationError() {
				System.out.println(NUMBER_DUPLICATION_ERROR);
		}
		
		public static void printInputBonusBall() {
				System.out.println(INPUT_BONUS_BALL);
		}
		
		public static void printBonusBallNumberError() {
				System.out.println(NUMBER_ERROR);
		}
		
		public static void printBonusBallNumberRangeError() {
				System.out.println(NUMBER_RANGE_ERROR);
		}
		
		public static void printBonusBallDuplicationError() {
				System.out.println(NUMBER_DUPLICATION_ERROR);
		}
		
		public static void printWinningStaticsResult() {
				printTitleWinStatics();
				for (int i = 4; i >= 0; i--) {
						Rank rank = Rank.values()[i];
						printWinningStaticMatchingInformation(rank);
				}
		}
		
		private static void printTitleWinStatics() {
				System.out.println(SPACING_ONE_LINE + TITLE_WIN_STATICS);
		}
		
		private static void printWinningStaticMatchingInformation(Rank rank) {
				if (rank == Rank.SECOND) {
						System.out.println(rank.getCountOfMatch() + STATIC_STRING_1_1 
											+ rank.getWinningMoney() + STATIC_STRING_2 
											+ LottoGame.winningInformation.get(rank) + STATIC_STRING_3);
						return;
				} 
				System.out.println(rank.getCountOfMatch() + STATIC_STRING_1_2 
									+ rank.getWinningMoney() + STATIC_STRING_2 
									+ LottoGame.winningInformation.get(rank) + STATIC_STRING_3);
				return;
		}
		
		public static void printRatesOfProfit() {
				System.out.println(STATIC_STRING_4 
									+ String.format(STRING_FORMATTING, LottoGame.ratesOfProfit) 
									+ STATIC_STRING_5);
		}
}