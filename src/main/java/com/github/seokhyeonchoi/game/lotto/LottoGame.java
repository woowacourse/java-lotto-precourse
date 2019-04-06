package com.github.seokhyeonchoi.game.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.github.seokhyeonchoi.game.Game;
import com.github.seokhyeonchoi.util.conversion.StringToIntegerConverter;
import com.github.seokhyeonchoi.util.generation.RandomNumberGenerator;
import com.github.seokhyeonchoi.util.io.IOUtil;
import com.github.seokhyeonchoi.util.validation.DuplicationValidator;
import com.github.seokhyeonchoi.util.validation.LeastValueValidator;
import com.github.seokhyeonchoi.util.validation.ValueRangeValidator;

import static com.github.seokhyeonchoi.game.lotto.Constant.*;

/**
 * Main Logic
 */
public class LottoGame implements Game {
	private final DuplicationValidator<Integer> DUPLICATION_VALIDATOR = new DuplicationValidator<Integer>();
	private final ValueRangeValidator VALUE_RANGE_VALIDATOR = new ValueRangeValidator(MIN_LOTTO_NUM, MAX_LOTTO_NUM);
	private final LeastValueValidator LEAST_VALUE_VALIDATOR = new LeastValueValidator(ONE_TICKET_AMOUNT);

	private List<Lotto> lottoTickets;
	private int purchaseAmount;
	private WinningLotto winningLotto;

	public LottoGame() {
		init();
	}

	@Override
	public void start() {
		User user = new User(lottoTickets, winningLotto);
		user.printResult();
	}

	private void init() {
		purchaseAmount = getPurchaseAmount();
		
		int ticketSize = purchaseAmount / ONE_TICKET_AMOUNT;
		lottoTickets = getLottoTickets(ticketSize);
		printTickets();
		
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
		Lotto winningLottoNums = getWinningLottoNums();
		int winningBonusNum = getWinningBonusNum(winningLottoNums);

		return new WinningLotto(winningLottoNums, winningBonusNum);
	}

	private List<Lotto> getLottoTickets(int ticketSize) {
		List<Lotto> lottoTickets = new ArrayList<Lotto>();
		
		for (int i = 0; i < ticketSize; i++) {
			List<Integer> randomIntegerList = RandomNumberGenerator.generateRandomIntegerList(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_NUM_SIZE);
			Collections.sort(randomIntegerList);
			lottoTickets.add(new Lotto(randomIntegerList));
		}
		return lottoTickets;
	}

	private Lotto getWinningLottoNums() {
		List<Integer> winningLottoNums = new ArrayList<>();

		while (winningLottoNums.size() != LOTTO_NUM_SIZE 
				|| !DUPLICATION_VALIDATOR.valid(winningLottoNums)
				|| !VALUE_RANGE_VALIDATOR.valid(winningLottoNums)) {
			winningLottoNums = StringToIntegerConverter.toList(inputWinningLottoString(), SPLIT_REGEX, REMOVE_REGEX);
		}
		return new Lotto(winningLottoNums);
	}

	private int getWinningBonusNum(Lotto winningLotto) {
		int winningBonusNum = 0;
		List<Integer> winningLottoNums = winningLotto.getNumbers();

		while (!DUPLICATION_VALIDATOR.valid(winningLottoNums, winningBonusNum)
				|| !VALUE_RANGE_VALIDATOR.valid(winningBonusNum)) {
			winningBonusNum = inputWinningBonusNum();
		}
		return winningBonusNum;
	}

	private int inputPurchaseAmount() {
		IOUtil.writeln(PURCHASE_AMOUNT_INPUT_MESSAGE);

		return IOUtil.readInt();
	}

	private String inputWinningLottoString() {
		IOUtil.writeln(WINNING_LOTTO_NUMBERS_INPUT_MESSAGE);

		return IOUtil.readLine();
	}

	private int inputWinningBonusNum() {
		IOUtil.writeln(WINNING_BONUS_NUMBER_INPUT_MESSAGE);

		return IOUtil.readInt();
	}

	private void printTickets() {
		IOUtil.writeln();
		IOUtil.write(lottoTickets.size());
		IOUtil.writeln(PURCHASE_ANNOUNCE_MESSAGE);

		for (Lotto lotto : lottoTickets) {
			IOUtil.writeln(lotto.getNumbers());
		}
		IOUtil.writeln();
	}
}
