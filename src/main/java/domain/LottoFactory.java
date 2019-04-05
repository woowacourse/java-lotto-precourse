package domain;

import domain.interfaces.LottoNumberGenerator;

import java.util.Arrays;

public class LottoFactory {

    private LottoNumberGenerator generator;

    public LottoFactory(LottoNumberGenerator generator) {
        this.generator = generator;
    }

    public Lotto createLotto() {
        Integer[] lottoNums = new Integer[LottoNumberGenerator.LOTTO_NUMS_LENGTH];
        generator.generateLottoNumberSet().toArray(lottoNums);
        return new Lotto(Arrays.asList(lottoNums));
    }
}
