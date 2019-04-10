package domain.validator;

import domain.LottoFactory;

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
                && doesEachLottoNumInputIsValid()
                && doesEachLottoNumIsValid();
    }

    boolean doesLottoNumLengthIsValid() {
        return lottoNumList.size() == LottoFactory.LOTTO_NUM_LENGTH;
    }

    boolean doesEachLottoNumInputIsValid() {
        return !lottoNumList.stream()
                .map(LottoInputValidator::new)
                .anyMatch((inputValidator) -> !inputValidator.doesValid());
    }

    boolean doesEachLottoNumIsValid() {
        return !lottoNumList.stream()
                .map(LottoNumValidator::new)
                .anyMatch((lottoNumValidator) -> !lottoNumValidator.doesValid());
    }
}
