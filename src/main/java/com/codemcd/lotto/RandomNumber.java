package com.codemcd.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumber {

    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MAX_LOTTO_SIZE = 6;

    public static List<Integer> makeLottoNumber() {

        List<Integer> lottoNumber = new ArrayList<>();
        Random random = new Random();

        while(lottoNumber.size() < MAX_LOTTO_SIZE) {
            int number = random.nextInt(MAX_LOTTO_NUMBER ) + 1;
            addNumber(lottoNumber, number);
        }

        return lottoNumber;
    }

    private static void addNumber(List<Integer> lottoNumber, int number) {
        if(!lottoNumber.contains(number)) {
            lottoNumber.add(number);
        }
    }
}
