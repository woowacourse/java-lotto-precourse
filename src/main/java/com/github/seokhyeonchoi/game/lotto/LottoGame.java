package com.github.seokhyeonchoi.game.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.github.seokhyeonchoi.game.Game;
import com.github.seokhyeonchoi.util.conversion.StringToIntegerConverter;
import com.github.seokhyeonchoi.util.validation.DuplicationValidator;
import com.github.seokhyeonchoi.util.validation.LeastValueValidator;
import com.github.seokhyeonchoi.util.validation.ValueRangeValidator;

public class LottoGame implements Game {
	private final int LEAST_PURCHASE_AMOUNT = 1000;
	private final int MIN_LOTTO_NUM = 1;
	private final int MAX_LOTTO_NUM = 45;
	private final int LOTTO_NUM_SIZE = 6;
	private final String SPLIT_REGEX = ",";
	private final String REMOVE_REGEX = "((\\.\\d+)|[^0-9,])";
	private final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입 금액을 입력해주세요.";
	private final String WINNING_LOTTO_NUMBERS_INPUT_MESSAGE = "지난 주 당첨번호를 입력해주세요.";
	private final String WINNING_BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해주세요.";

	private final Scanner SCANNER = new Scanner(System.in);
	private final DuplicationValidator<Integer> DUPLICATION_VALIDATOR = new DuplicationValidator<Integer>();
	private final ValueRangeValidator VALUE_RANGE_VALIDATOR = new ValueRangeValidator(MIN_LOTTO_NUM, MAX_LOTTO_NUM);
	private final LeastValueValidator LEAST_VALUE_VALIDATOR = new LeastValueValidator(LEAST_PURCHASE_AMOUNT);

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
		purchaseAmount = getPurchaseAmount();
		winningLotto = getWinningLotto();
	}

	private int getPurchaseAmount() {
		int amount = 0;

		while (!LEAST_VALUE_VALIDATOR.valid(amount)) {
			amount = inputPurchaseAmount();
		}

		return amount;
	}

	private WinningLotto getWinningLotto() {
		Lotto lottoNums = getWinningLottoNums();
		int bonusNum = getWinningBonusNum(lottoNums);
		
		return new WinningLotto(lottoNums, bonusNum);
	}

	private Lotto getWinningLottoNums() {
		List<Integer> winningLottoNums = new ArrayList<>();
		
		while (winningLottoNums.size() != LOTTO_NUM_SIZE 
				&& !DUPLICATION_VALIDATOR.valid(winningLottoNums)
				&& !VALUE_RANGE_VALIDATOR.valid(winningLottoNums)) {
			winningLottoNums = StringToIntegerConverter.toList(inputWinningLottoString(), SPLIT_REGEX, REMOVE_REGEX);
		}
		return new Lotto(winningLottoNums);
	}
	
	private int getWinningBonusNum(Lotto winningLotto) {
		int winningBonusNum = 0;
		List<Integer> winningLottoNums = winningLotto.getNumbers();
		
		while(!DUPLICATION_VALIDATOR.valid(winningLottoNums, winningBonusNum)
				&& !VALUE_RANGE_VALIDATOR.valid(winningBonusNum)) {
			winningBonusNum = inputWinningBonusNum();
		}
		return winningBonusNum;
	}
	
	private int inputPurchaseAmount() {
		System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
		
		return SCANNER.nextInt();
	}
	
	private String inputWinningLottoString() {
		System.out.println(WINNING_LOTTO_NUMBERS_INPUT_MESSAGE);
		
		return SCANNER.nextLine();
	}
	
	private int inputWinningBonusNum() {
		System.out.println(WINNING_BONUS_NUMBER_INPUT_MESSAGE);
		
		return SCANNER.nextInt();
	}
}
