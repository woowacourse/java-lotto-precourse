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

    /**
     * Rank 계산 메쏘드
     *
     * 중복된 숫자의 크기: N(DUP)
     * 유일한 숫자의 크기: N(UNI)
     * 이라고 할 때,
     *
     * Lotto 들의 매칭 갯수 계산법: 각각의 로또 번호는들은 중복됨이 없으므로 로또 번호들을 서로 합하면, 그 크기는
     * N(DUP)x2 + N(UNI) 가 됩니다.
     * 여기에서 중복된 숫자 원소들을 지우면 크기가 N(DUP) + N(UNI) 가 되고,
     * 앞의 두 값을 다음 과 같이 빼면 매칭 개수를 구할 수 있습니다.
     *
     * (합한 숫자들의 크기) - (중복 제거된 숫자들의 크기) = (N(DUP)x2 + N(UNI)) - (N(DUP) + N(UNI)) = N(DUP)
     */
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
