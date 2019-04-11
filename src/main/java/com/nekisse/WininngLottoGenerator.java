package com.nekisse;

import com.nekisse.domain.Lotto;
import com.nekisse.domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class WininngLottoGenerator {


    public static Lotto createLotto(String inputWinningLottoNumbers) {
        List<LottoNumber> winingNumbers = getLottoNumbers(inputWinningLottoNumbers);

        return new Lotto(winingNumbers);
    }

    private static List<LottoNumber> getLottoNumbers(String inputNumber) {
        List<LottoNumber> winingNumbers = new ArrayList<>();
        String[] split = inputNumber.trim().split(",");
        for (String str : split) {
            winingNumbers.add(LottoNumber.getBasicNumber(Integer.parseInt(str.trim())));
        }
        return winingNumbers;
    }



}
