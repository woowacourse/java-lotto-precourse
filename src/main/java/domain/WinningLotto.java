package domain;

import java.util.List;

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
        MatchInformation matchInformation = new MatchInformation();
        for (int number : userLotto.getNumbers()) {
            matchNumber(number, matchInformation);
        }
        return Rank.valueOf(matchInformation.getCountOfMatch(), matchInformation.getMatchBonus());
    }

    private void matchNumber(int number, MatchInformation matchInformation) {
        List<Integer> winningLottoNumbers = lotto.getNumbers();
        if (winningLottoNumbers.contains(number)) {
            matchInformation.matchNumber();
        }
        if (bonusNo == number) {
            matchInformation.matchBonusNumber();
        }
    }
}
