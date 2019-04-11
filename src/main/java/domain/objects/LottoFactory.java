/*
 * LottoFactory Class
 *
 * @version 2
 *
 * @date 2019-04-11
 *
 * Copyright (c) 2019. Jihun oh
 * All rights reserved.
 */
package domain.objects;

import java.util.*;

/**
 * 로또를 생산하는 객체
 * 1-45 사이의 중복하지 않는 6자리 번호를 부여한다.
 */
public class LottoFactory {
    private Random random;

    public LottoFactory() {
        random = new Random();
    }

    public Lotto create() {
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
