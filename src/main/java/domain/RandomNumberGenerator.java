package domain;

import java.util.ArrayList;
import java.util.List;

import static domain.Constant.*;

public class RandomNumberGenerator {

    private List<Integer> lottoNumbers;

    RandomNumberGenerator() {
        lottoNumbers = new ArrayList<>();
    }

    public List<Integer> GenerateRandomNumbers() {
        lottoNumbers.clear();

        for (int i = 0; i < LOTTO_SIZE; i++) {
            lottoNumbers.add(GenerateRandomNumber());
        }

        return lottoNumbers;
    }

    private int GenerateRandomNumber() {
        boolean isOverlap = true;
        int candidateLottoNumber = 0;

        while (isOverlap) {
            candidateLottoNumber = (int) ((Math.random() * MAX_LOTTO_NUMBER) + MIN_LOTTO_NUMBER);
            isOverlap = !Validator.isNotOverlapLottoNumber(lottoNumbers, candidateLottoNumber);
        }

        return candidateLottoNumber;
    }

}
