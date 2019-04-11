package com.nekisse;

import com.nekisse.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.nekisse.domain.LottoNumber.MAXIMUM_LOTTO_NUMBER;
import static com.nekisse.domain.LottoNumber.MINIMUM_LOTTO_NUMBER;

public class LottoRandomNumberGenerator implements RandomNumberGenerator {

    public static final int LIMIT_LOTTO_NUMBER = 6;
    private List<Integer> lottoNumbers;

    public LottoRandomNumberGenerator() {
        this.lottoNumbers = setUpLottoNumbers();
    }


    private List<Integer> setUpLottoNumbers() {
        lottoNumbers = new ArrayList<>();
        for (int i = MINIMUM_LOTTO_NUMBER; i <= MAXIMUM_LOTTO_NUMBER; i++) {
            lottoNumbers.add(i);
        }
        return lottoNumbers;
    }

    @Override
    public List<LottoNumber> generate() {
        Collections.sort(lottoNumbers);
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> randomSixNumbers = new ArrayList<>();
        for (int i = MINIMUM_LOTTO_NUMBER; i <= LIMIT_LOTTO_NUMBER; i++) {
            randomSixNumbers.add(LottoNumber.getBasicNumber(lottoNumbers.get(i)));
        }
        return randomSixNumbers;
    }


}
