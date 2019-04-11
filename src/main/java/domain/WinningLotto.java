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
        int MatchScore =0;
        boolean BonusScore=false;
        for(Integer ball : userLotto.GetLottoNumber())
        {
            if(lotto.GetLottoNumber().contains(ball))
            {
                MatchScore=MatchScore+1;
            }
        }

        if(userLotto.GetLottoNumber().contains(bonusNo))
        {
            BonusScore=true;
        }
        return Rank.valueOf(MatchScore,BonusScore);
    }
}
