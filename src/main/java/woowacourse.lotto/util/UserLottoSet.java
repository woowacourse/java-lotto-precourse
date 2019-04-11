/*
 * UserLottoSet.java
 * version 1.0
 * 2019.04.11
 * Copyright (c) 2019 Hyunji Choi
 * This program is made available under the terms of the MIT License.
 */

package woowacourse.lotto.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * user에게 발급된 로또의 집합을 나타내는 객체
 */
class UserLottoSet {
    private ArrayList<Lotto> userLottoSet;

    UserLottoSet() {
        userLottoSet = new ArrayList<>();
    }

    void saveUserLotto(int numLotto) {
        Random rand = new Random();
        for (int i = 0; i < numLotto; i++) {
            Lotto oneRandomLotto = generateLotto(rand);
            userLottoSet.add(oneRandomLotto);
            oneRandomLotto.printLotto();
        }
    }

    void saveMatchResult(WinningLotto winningLotto,
                         ArrayList<Rank> matchedRanks) {
        for (Lotto userLotto : userLottoSet) {
            matchedRanks.add(winningLotto.match(userLotto));
        }
    }

    private Lotto generateLotto(Random rand) {
        List<Integer> numberSet = rand.ints(LottoShop.NUMBER_LOWER_BOUND,
                LottoShop.NUMBER_UPPER_BOUND).distinct()
                .limit(LottoShop.NUMBER_PER_LOTTO).boxed()
                .sorted().collect(Collectors.toList());
        return new Lotto(numberSet);
    }
}
