package lotto.utils;

import lotto.domain.Lotto;

public class RandomNumberGenerate implements NumberGenerator {
    @Override
    public int getNumber() {
        return (int) (Math.random() * Lotto.LOTTO_MAX_NUMBER) + Lotto.LOTTO_MIN_NUMBER;
    }
}
