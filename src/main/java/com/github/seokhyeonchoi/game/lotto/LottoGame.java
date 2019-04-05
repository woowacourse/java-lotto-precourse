package com.github.seokhyeonchoi.game.lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.github.seokhyeonchoi.game.Game;
import com.github.seokhyeonchoi.util.validation.DuplicationValidator;
import com.github.seokhyeonchoi.util.validation.LeastValueValidator;
import com.github.seokhyeonchoi.util.validation.ValueRangeValidator;

public class LottoGame implements Game {
	private final int LEAST_PURCHASE_AMOUNT = 1000;
	private final int MIN_LOTTO_NUM = 1;
	private final int MAX_LOTTO_NUM = 45;
	private final int LOTTO_NUM_SIZE = 6;
	private final String SPLIT_REGEX = ",";

	private final Scanner SCANNER = new Scanner(System.in);
	private final DuplicationValidator<Integer> DUPLICATION_VALIDATOR = new DuplicationValidator();
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

	}

	private int inputPurchaseAmount() {
		int amount = 0;

		while (!LEAST_VALUE_VALIDATOR.valid(amount)) {
			amount = SCANNER.nextInt();
		}

		return amount;
	}

	private Lotto inputWinningLottoNums() {
		String nums = "";
		List<Integer> winningLottoNums = new ArrayList<>();

		while (winningLottoNums.size() != LOTTO_NUM_SIZE && !VALUE_RANGE_VALIDATOR.valid(winningLottoNums)) {
			nums = SCANNER.nextLine();
			winningLottoNums = toList(nums, SPLIT_REGEX);
		}
		return new Lotto(winningLottoNums);
	}

	private List<Integer> toList(String inputString, String regex) {
		List<Integer> list = new ArrayList<Integer>();
		String[] strArray = inputString.split(regex);

		for (String str : strArray) {
			list.add(Integer.parseInt(str));
		}

		return list;
	}
}
