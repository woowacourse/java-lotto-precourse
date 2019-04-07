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
        MatchInformation matchInformation = new MatchInformation();
        for (int number : userLotto.getNumbers()) {
            matchNumber(number, matchInformation);
        }
        return Rank.valueOf(matchInformation.getCountOfMatch(), matchInformation.getMatchBonus());
    }

    public void matchNumber(int number, MatchInformation matchInformation) {
        List<Integer> winningLottoNumbers = lotto.getNumbers();
        if (winningLottoNumbers.contains(number)) {
            matchInformation.matchNumber();
        }
        if (bonusNo == number) {
            matchInformation.matchBonusNumber();
        }
    }
}
