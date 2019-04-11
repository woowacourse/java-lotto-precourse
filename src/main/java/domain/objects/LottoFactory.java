/*
 * LottoFactory Class
 *
 * @version 1
 *
 * @date 2019-04-11
 *
 * Copyright (c) 2019. Jihun oh
 * All rights reserved.
 */
package domain.objects;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class LottoFactory {
    private Random random;

    public LottoFactory() {
        random = new Random();
    }

    public Lotto createLotto() {
        return new Lotto(createLottoNums());
    }

    private List<Integer> createLottoNums() {
        List<Integer> lottoNums = new LinkedList<>();

        while (lottoNums.size() != Lotto.NUMS_COUNT) {
            addIfNotContainRandNumToLottoNums(lottoNums, createRandLottoNum());
        }
        return lottoNums;
    }

    private void addIfNotContainRandNumToLottoNums(List<Integer> lottoNums, int randLottoNum) {
        if (!lottoNums.contains(randLottoNum))
            lottoNums.add(randLottoNum);
    }

    private int createRandLottoNum() {
        return random.nextInt(Lotto.MAX_LOTTO_NUM - Lotto.MIN_LOTTO_NUM + 1) + Lotto.MIN_LOTTO_NUM;
    }
}
