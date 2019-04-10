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
        // TODO 로직 구현
        List<Integer> userNumbers = userLotto.getNumbers();
        List<Integer> winningNumbers = lotto.getNumbers();

        System.out.println(userNumbers.get(0));
        System.out.println(winningNumbers.get(0));

        return null;
    }

}
