package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import domain.Lotto;
import utils.AscendingInteger;

public class LottoGenerator {
	private static final String PURCHASED_COUNT = "%d개를 구매했습니다.";
	private List<Lotto> soldLottos;
	private Random random;
	
	public LottoGenerator(int count) {
		this.soldLottos = new ArrayList<>();
		this.random = new Random();
		makeLottos(count);
	}

	private void makeLottos(int count) {
		System.out.println(String.format(PURCHASED_COUNT, count));
		while (count > 0) {
			Lotto generatedLotto = new Lotto(generatingLotto());
			this.soldLottos.add(generatedLotto);
			printLottos(generatedLotto);
			count--;
		}
	}

	private List<Integer> generatingLotto() {
		List<Integer> lottoNumbers = generatingNumber();
		Collections.sort(lottoNumbers, new AscendingInteger());
		return lottoNumbers;
	}

	private List<Integer> generatingNumber() {
		List<Integer> lottoNumbers = new ArrayList<>();
		while (lottoNumbers.size() < InputWinningNumber.LOTTO_NUMBER_COUNT) {
			setNumber(lottoNumbers);
		}
		return lottoNumbers;
	}
	
	private void setNumber(List<Integer> lottoNumbers) {
		int number = 1 + random.nextInt(InputWinningNumber.LOTTO_NUMBER_LIMIT);
		if (!lottoNumbers.contains(number)) {
			lottoNumbers.add(number);
		}
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
