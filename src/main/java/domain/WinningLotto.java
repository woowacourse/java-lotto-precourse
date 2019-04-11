package domain;

import java.util.List;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        int countOfMatch = this.getCountOfMatch(userLotto);
        return null;
    }

    private int getCountOfMatch(Lotto userLotto) {
        int matchCount = 0;
        List<Integer> winningNumbers = this.lotto.getNumbers();
        List<Integer> userLottoNumbers = userLotto.getNumbers();
        for (Integer winningNumber : winningNumbers) {
            matchCount += isMatch(winningNumber, userLottoNumbers);
        }
        return matchCount;
    }

    private int isMatch(int lotteryNumber, List<Integer> winningNumbers) {
        return (winningNumbers.contains(lotteryNumber)) ? 1 : 0;
    }
}
