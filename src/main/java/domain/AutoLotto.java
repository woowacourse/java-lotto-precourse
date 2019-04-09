package domain;

import java.util.ArrayList;
import java.util.List;

public class AutoLotto {
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private List<Integer> lottoNumbers;

    AutoLotto() {
        lottoNumbers = new ArrayList<>();
    }

    public List<Integer> GenerateAuttoLotto() {

        for(int i=0 ; i< LOTTO_NUMBER_COUNT; i++){
            lottoNumbers.add(GenerateRandomNumber());
        }

        return lottoNumbers;
    }

    private int GenerateRandomNumber() {
        boolean isNotValidLottoNumber = true;
        int candidateLottoNumber = 0;

        while (isNotValidLottoNumber) {
            candidateLottoNumber = (int) ((Math.random() * MAX_LOTTO_NUMBER) + MIN_LOTTO_NUMBER);
            isNotValidLottoNumber = isOverlapLottoNumber(candidateLottoNumber);
        }

        return candidateLottoNumber;
    }

    private boolean isOverlapLottoNumber(int candidateLottoNumber) {
        return lottoNumbers.contains(candidateLottoNumber) ? true : false;
    }
}
