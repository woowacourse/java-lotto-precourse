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
        int match_count = 0;
        boolean bonus_match;
        for(Integer num : userLotto.getNumbers()){
            match_count += checkMatch(num);
        }
        bonus_match = isBonusMatch(userLotto);
        return Rank.valueOf(match_count,bonus_match);
    }

    /**
     *  번호가 당첨번호에 해당되면 1을, 해당되지 않으면 0을 반환한다.
     */
    public int checkMatch(Integer user_num){
        if(lotto.getNumbers().contains(user_num))
            return 1;
        return 0;
    }

    public boolean isBonusMatch(Lotto userLotto){
        if(userLotto.getNumbers().contains(bonusNo))
            return true;
        return false;
    }
}
