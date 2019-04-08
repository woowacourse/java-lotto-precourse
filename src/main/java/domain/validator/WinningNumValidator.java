package domain.validator;

import domain.LottoFactory;
import domain.LottoNumGenerator;

import java.util.List;
import java.util.Arrays;

public class WinningNumValidator implements Validator {

    private final List<String> lottoNumList;

    public WinningNumValidator(String[] winningNums) {
        this.lottoNumList = Arrays.asList(winningNums);
    }

    @Override
    public boolean doesValid() {
        return doesLottoNumLengthIsValid()
                && doesLottoNumInputIsValid()
                && doesLottoNumNotExceedBound();
    }

    boolean doesLottoNumLengthIsValid() {
        return lottoNumList.size() == LottoFactory.LOTTO_NUM_LENGTH;
    }

    boolean doesLottoNumInputIsValid() {
        long numOfInvalidLottoNum = lottoNumList.stream()
                .map(LottoInputValidator::new)
                .filter((inputValidator) -> !inputValidator.doesValid())
                .count();
        return numOfInvalidLottoNum == 0;
    }

    boolean doesLottoNumNotExceedBound() {
        int lowerBound = LottoNumGenerator.LOTTO_NUM_LOWER_BOUND;
        int upperBound = LottoNumGenerator.LOTTO_NUM_UPPER_BOUND;
        long exceedNum = lottoNumList.stream()
                .map(Integer::parseInt)
                .filter((lottoNum) -> (lottoNum > upperBound) || (lottoNum < lowerBound))
                .count();
        return exceedNum == 0;
    }
}
