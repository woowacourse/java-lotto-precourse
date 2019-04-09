package domain;

import java.util.List;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto implements Constants {
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        List<Integer> userNumbers = userLotto.getNumbers();
        List<Integer> winningNumbers = lotto.getNumbers();
        int countOfMatch = 0;
        boolean matchBonus = false;

        for (int i = 0; i < SIZE_OF_LOTTO; i++) {
            if (userNumbers.contains(winningNumbers.get(i))) {
                countOfMatch++;
            }
        }

        if (userNumbers.contains(bonusNo)) {
            matchBonus = true;
        }

        return Rank.valueOf(countOfMatch, matchBonus);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNo() {
        return bonusNo;
    }
}
