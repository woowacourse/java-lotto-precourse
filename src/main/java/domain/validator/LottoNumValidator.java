package domain.validator;

import java.util.List;
import java.util.Arrays;

public class LottoNumValidator implements Validator {

    private final String[] lottoNums;

    public LottoNumValidator(String[] lottoNums) {
        this.lottoNums = lottoNums;
    }

    @Override
    public boolean doesValid() {
        return doesLottoNumIsNotNull();
    }

    boolean doesLottoNumIsNotNull() {
        List<String> lottoNumList = Arrays.asList(lottoNums);
        long nullNum = lottoNumList.stream().filter((lottoNum) -> lottoNum == null).count();
        return nullNum == 0;
    }
}
