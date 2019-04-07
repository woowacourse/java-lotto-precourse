package domain.validator;

import domain.LottoNumGenerator;

import java.util.List;
import java.util.Arrays;

public class WinningNumValidator implements Validator {

    private final List<String> lottoNumList;

    public WinningNumValidator(String[] lottoNums) {
        this.lottoNumList = Arrays.asList(lottoNums);
    }

    @Override
    public boolean doesValid() {
        return doesLottoNumIsNotNull() && doesLottoNumNotExceedBound();
    }

    boolean doesLottoNumIsNotNull() {
        long nullNum = lottoNumList.stream().filter((lottoNum) -> lottoNum == null).count();
        return nullNum == 0;
    }

    boolean doesLottoNumNotExceedBound() {
        int lowerBound = LottoNumGenerator.LOTTO_NUM_LOWER_BOUND;
        int upperBound = LottoNumGenerator.LOTTO_NUM_UPPER_BOUND;
        long exceedNum =  lottoNumList.stream().map(Integer::parseInt).
                filter((lottoNum) -> (lottoNum > upperBound) || (lottoNum < lowerBound)).count();

        return exceedNum == 0;
    }
}
