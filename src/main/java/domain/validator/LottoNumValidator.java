package domain.validator;

import domain.LottoNumGenerator;

public class LottoNumValidator implements Validator {

    private final String lottoNum;

    public LottoNumValidator(String lottoNum) {
        this.lottoNum = lottoNum;
    }

    @Override
    public boolean doesValid() {
        return doesBonusNumNotExceedBound();
    }

    boolean doesBonusNumNotExceedBound() {
        int lowerBound = LottoNumGenerator.LOTTO_NUM_LOWER_BOUND;
        int upperBound = LottoNumGenerator.LOTTO_NUM_UPPER_BOUND;
        int num = convertStringToInt(lottoNum);

        return lowerBound <= num && num <= upperBound;
    }

    private int convertStringToInt(String str) {
        return Integer.parseInt(str);
    }
}
