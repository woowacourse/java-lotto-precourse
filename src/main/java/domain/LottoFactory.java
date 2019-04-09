package domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class LottoFactory {

    public static final int LOTTO_NUM_LENGTH = 6;

    private final LottoNumGenerator lottoNumGenerator;

    public LottoFactory() {
        lottoNumGenerator = new LottoNumGenerator();
    }

    public Lotto getInstance() {
        List<Integer> lottoNums = getLottoNums();
        return new Lotto(lottoNums);
    }

    public Lotto getInstance(List<Integer> lottoNums) {
        return new Lotto(lottoNums);
    }

    private List<Integer> getLottoNums() {
        List<Integer> lottoNums = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUM_LENGTH; i++) {
            int lottoNum = lottoNumGenerator.generateNonDuplicateLottoNum(lottoNums);
            lottoNums.add(new Integer(lottoNum));
        }
        return Collections.unmodifiableList(lottoNums);
    }
}
