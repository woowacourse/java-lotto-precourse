/*
 * class : LottoMaker.java
 *
 * version : 1.0.0
 *
 * date : 2019.04.08
 *
 * author : icarus8050
 */

package Util;

import domain.Lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 로또를 생성하는 객체
 */
public class LottoMaker {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_MAX_LENGTH = 6;

    public static List<Lotto> getLottos(int numberOfLotto) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLotto; i++) {
            lottos.add(getLotto());
        }
        return lottos;
    }

    public static Lotto getLotto() {
        List<Integer> lottoNumbers = new ArrayList<>(getUniqueNumberSet());
        return new Lotto(lottoNumbers);
    }

    private static Set<Integer> getUniqueNumberSet() {
        Set<Integer> uniqueNumberSet = new HashSet<>();

        while (uniqueNumberSet.size() != LOTTO_NUMBER_MAX_LENGTH) {
            uniqueNumberSet.add(getRandomNumber());
        }
        return uniqueNumberSet;
    }

    private static int getRandomNumber() {
        return ((int) (Math.random() * LOTTO_MAX_NUMBER) + LOTTO_MIN_NUMBER);
    }
}
