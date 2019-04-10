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
        List<Integer> winningLottoNumList = this.lotto.getLottoNumbers();
        List<Integer> userLottoNumList = userLotto.getLottoNumbers();
        int matchCnt = 0;
        boolean matchBonus = false;
        for(Integer num : userLottoNumList){
            matchCnt += checkNumInList(num, winningLottoNumList);
            matchBonus = num.equals(this.bonusNo);
        }
        return Rank.valueOf(matchCnt, matchBonus);
    }

    private int checkNumInList(Integer num, List<Integer> list){
        if(list.contains(num)){
            return 1;
        }
        return 0;
    }
}
