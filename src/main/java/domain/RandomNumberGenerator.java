package domain;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private List<Integer> lottoNumbers;

    RandomNumberGenerator() {
        lottoNumbers = new ArrayList<>();
    }

    public List<Integer> GenerateRandomNumbers() {
        lottoNumbers.clear();

        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            lottoNumbers.add(GenerateRandomNumber());
        }
        return lottoNumbers;
    }

    private int GenerateRandomNumber() {
        boolean isOverlap = true;
        int candidateLottoNumber = 0;

        while (isOverlap) {
            candidateLottoNumber = (int) ((Math.random() * MAX_LOTTO_NUMBER) + MIN_LOTTO_NUMBER);
            isOverlap = Validator.isOverlapLottoNumber(lottoNumbers, candidateLottoNumber);
        }

        return candidateLottoNumber;
    }

}
