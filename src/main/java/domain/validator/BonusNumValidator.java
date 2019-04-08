package domain.validator;

import domain.LottoNumGenerator;

public class BonusNumValidator implements Validator {

    private final String bonusNum;

    public BonusNumValidator(String bonusNum) {
        this.bonusNum = bonusNum;
    }

    @Override
    public boolean doesValid() {
        return doesBonusNumNotExceedBound();
    }

    boolean doesBonusNumNotExceedBound() {
        int lowerBound = LottoNumGenerator.LOTTO_NUM_LOWER_BOUND;
        int upperBound = LottoNumGenerator.LOTTO_NUM_UPPER_BOUND;
        int num = convertStringToInt(bonusNum);

        return lowerBound <= num && num <= upperBound;
    }

    private int convertStringToInt(String str) {
        return Integer.parseInt(str);
    }
}
