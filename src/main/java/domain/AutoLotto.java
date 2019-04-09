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
        boolean isNotValidLottoNumber = true;

        while(isNotValidLottoNumber){
            GenerateRandomNumbers();
            isNotValidLottoNumber = Validator.isOverlapLottoNumbers(this.lottoNumbers);
        }

        return lottoNumbers;
    }

    private void GenerateRandomNumbers() {
        lottoNumbers.clear();

        for(int i=0 ; i< LOTTO_NUMBER_COUNT; i++){
            int candidateLottoNumber =(int) ((Math.random() * MAX_LOTTO_NUMBER) + MIN_LOTTO_NUMBER);
            lottoNumbers.add(candidateLottoNumber);
        }

    }

}
