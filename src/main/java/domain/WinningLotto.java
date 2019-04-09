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

    public Lotto getWinningLotto(){
        return this.lotto;
    }

    public int getBonusNumber(){
        return this.bonusNo;
    }

    public Rank match(Lotto userLotto) {
        int countOfMatch = 0;
        for(int i =0; i<userLotto.getLottoNumber().size();i++){
            countOfMatch = (userLotto.getLottoNumber().contains(this.lotto.getLottoNumber().get(i))) ? countOfMatch + 1 : countOfMatch;
        }
        Boolean matchBonus = userLotto.getLottoNumber().contains(this.bonusNo);
        Rank rank = Rank.valueOf(countOfMatch,matchBonus);
        return rank;
    }
}
