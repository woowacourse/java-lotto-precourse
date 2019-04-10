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
        int countOfMatch=userLotto.matchNumber(lotto);
        boolean matchBonus=false;

        if(userLotto.isContainWinningLotto(lotto,bonusNo)==1){
            matchBonus=true;
        }
        return Rank.valueOf(countOfMatch,matchBonus);
    }
}
