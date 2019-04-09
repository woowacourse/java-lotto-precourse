package com.molt3nrock.lotto;

import java.util.List;
import java.util.stream.Stream;

/**
 * 당첨 번호를 담당하는 객체
 */
class WinningLotto {

    private final Lotto lotto;
    private final int bonusNo;

    WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    Rank match(Lotto userLotto) {
        List<Integer> winningNumbers = this.lotto.getNumbers();
        List<Integer> userNumbers = userLotto.getNumbers();
        int totalCount = winningNumbers.size() + userNumbers.size();
        int uniqueCount = (int) Stream.concat(winningNumbers.stream(), userNumbers.stream())
            .distinct()
            .count();
        return Rank.valueOf(totalCount - uniqueCount,
                            userNumbers.stream().anyMatch(i -> i.equals(this.bonusNo)));
    }
}
