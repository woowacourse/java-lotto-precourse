package util;

import domain.Lotto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author delf
 */
public class LottoNumberGenerator extends UniqueRandomNumberGenerator {
    public List<Integer> generateLottoNumbers(){
        return new ArrayList<>(getUniqueNumbers(Lotto.PICK_NUM, Lotto.MIN_NUM, Lotto.MAX_NUM));
    }
}
