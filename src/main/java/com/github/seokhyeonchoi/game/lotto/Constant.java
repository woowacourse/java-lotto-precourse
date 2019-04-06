package com.github.seokhyeonchoi.game.lotto;

/**
 * 상수 class
 */
public class Constant {
	public static final int ONE_TICKET_AMOUNT = 1000;
	public static final int MIN_LOTTO_NUM = 1;
	public static final int MAX_LOTTO_NUM = 45;
	public static final int LOTTO_NUM_SIZE = 6;
	public static final String SPLIT_REGEX = ",";
	public static final String REMOVE_REGEX = "((\\.\\d+)|[^0-9,])";
	public static final String ROI_PRINT_FORMAT = "%.3f";
	
	public static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입 금액을 입력해주세요.";
	public static final String PURCHASE_ANNOUNCE_MESSAGE = "개를 구매했습니다.";
	public static final String WINNING_LOTTO_NUMBERS_INPUT_MESSAGE = "지난 주 당첨번호를 입력해주세요.";
	public static final String WINNING_BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해주세요.";
	public static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
	public static final String LINE_DIVIDE_MESSAGE = "---------------------";
	public static final String NUMBEROF_MESSAGE = "개 ";
	public static final String MATCH_NUMS_MESSAGE = "일치 ";
	public static final String OPEN_BRACKET_MESSAGE = "( ";
	public static final String CLOSE_BRACKET_MESSAGE = "원) - ";
	public static final String MATCH_BONUS_MESSAGE = ", 보너스 볼 일치 ";
	public static final String ROI_MESSAGE_PREFIX = "총 수익률은 ";
	public static final String ROI_MESSAGE_SUFFIX = "입니다. ";
}
