package domain.interfaces;

import java.util.Set;

public interface LottoNumberGenerator {
    int LOTTO_NUM_MIN = 1;
    int LOTTO_NUM_MAX = 45;
    int LOTTO_NUMS_LENGTH = 6;

    Set<Integer> generateLottoNumberSet();
}
