package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import domain.Lotto;
import utils.AscendingInteger;

public class LottoGenerator {

	private List<Lotto> soldLottos;
	private Random random;

	public LottoGenerator(int count) {
		soldLottos = new ArrayList<>();
		random = new Random();
		makeLottos(count);
	}

	private void makeLottos(int count) {
		Lotto generatedLotto;
		while (count > 0) {
			generatedLotto = new Lotto(generatingLotto()); 
			soldLottos.add(generatedLotto);
			printLottos(generatedLotto);
			count--;
		}
	}

	private List<Integer> generatingLotto() {
		List<Integer> lotto = new ArrayList<>();
		for (int i = 0; i < InputWinningNumber.LOTTO_NUMBER_COUNT; i++) {
			int number = 1 + random.nextInt(InputWinningNumber.LOTTO_NUMBER_LIMIT);
			if (lotto.contains(number)) {
				i--;
				continue;
			}
			lotto.add(number);
		}
		Collections.sort(lotto, new AscendingInteger());
		return lotto;
	}

	private void printLottos(Lotto generatedLotto) {
			StringBuilder sb = new StringBuilder();
			sb.append(generatedLotto.getNumbers().toString());
			System.out.println(sb.toString());
	}

	public List<Lotto> getSoldLottos() {
		return this.soldLottos;
	}
}
