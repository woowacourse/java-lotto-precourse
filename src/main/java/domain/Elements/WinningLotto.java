package domain.Elements;

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

    public Lotto getWinningLotto(){
        return this.lotto;
    }

    public int getBonusNumber(){
        return this.bonusNo;
    }

    public Rank match(Lotto userLotto) {
        int countOfMatch = setCountOfMatch(userLotto.getLottoNumber());
        Boolean matchBonus = userLotto.getLottoNumber().contains(this.bonusNo);
        return  Rank.valueOf(countOfMatch,matchBonus);
    }

    private int setCountOfMatch(List<Integer> lottoNumber){
        int countOfMatch = 0;
        for(int i =0; i<lottoNumber.size();i++){
            countOfMatch = (lottoNumber.contains(this.lotto.getLottoNumber().get(i))) ? countOfMatch + 1 : countOfMatch;
        }
        return countOfMatch;
    }
}
