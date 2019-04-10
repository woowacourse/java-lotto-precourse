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
        int match = 0;
        boolean isBonusSame = false;
        for(int userNum : userLotto.getNumbers()){
            match = isSameNumber(userNum, match);
        }
        isBonusSame = isSameBonus(userLotto.getNumbers());
        Rank rank = Rank.valueOf(match,isBonusSame);
        return Rank.valueOf(match,isBonusSame);
    }

    private int isSameNumber(int num, int match){
        if(lotto.getNumbers().contains(num)){
            return ++match;
        }
        return match;
    }

    private boolean isSameBonus(List<Integer> userLotto){
        if(userLotto.contains(bonusNo)){
            return true;
        }
        return false;
    }
}
