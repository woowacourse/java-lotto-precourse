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
        boolean matchBonus = false;
        List<Integer> numbers = userLotto.getNumbers();
        int cnt=0;
        for (int userNumber : numbers){
            if (lotto.getNumbers().contains(userNumber)){
                cnt++;
            }
            if (userNumber == bonusNo){
                matchBonus = true;
            }
        }
        return Rank.valueOf(cnt,matchBonus);
    }
}
