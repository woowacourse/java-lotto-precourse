package com.codemcd.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumber {

    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MAX_LOTTO_SIZE = 6;

    public static List<Integer> makeLottoNumber() {
        List<Integer> lottoNumbers = new ArrayList<>();
        Random random = new Random();
        while (lottoNumbers.size() < MAX_LOTTO_SIZE) {
            int number = random.nextInt(MAX_LOTTO_NUMBER) + 1;
            addLottoNumber(lottoNumbers, number);
        }
        return lottoNumbers;
    }

    private static void addLottoNumber(List<Integer> lottoNumbers, int number) {
        if (!lottoNumbers.contains(number)) {
            lottoNumbers.add(number);
        }
    }
}
