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
        long numOfInvalidLottoNumInput = lottoNumList.stream()
                .map(LottoInputValidator::new)
                .filter((inputValidator) -> !inputValidator.doesValid())
                .count();
        return numOfInvalidLottoNumInput == 0;
    }

    boolean doesEachLottoNumIsValid() {
        long numOfInvalidLottoNum = lottoNumList.stream()
                .map(BonusNumValidator::new)
                .filter((bonusNumValidator) -> !bonusNumValidator.doesValid())
                .count();
        return numOfInvalidLottoNum == 0;
    }
}
