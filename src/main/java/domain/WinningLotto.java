package domain;

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
        int countOfMatch = lottoMatchCount(userLotto);
        boolean bonusBall = isMatchBonus(userLotto);
        return Rank.valueOf(countOfMatch, bonusBall);
    }

    private int lottoMatchCount(Lotto userLotto){
        int countOfMatch = 0;
        for (int i = 0; i < 6; i++){
            int number = userLotto.getLottoNumber(i);
            if (lotto.lottoNumberExist(number)){
                countOfMatch += 1;
            }
        }
        return countOfMatch;
    }

    private boolean isMatchBonus(Lotto userLotto){
        return userLotto.lottoNumberExist(this.bonusNo);
    }
}
