package domain;

import validate.Validator;

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
        Validator validator = new Validator();
        int matchCnt = 0;
        boolean matchBonus = false;
        for(Integer num : userLottoNumList){
            matchCnt += validator.isExistNumInList(num, winningLottoNumList);
            matchBonus = num.equals(this.bonusNo);
        }
        return Rank.valueOf(matchCnt, matchBonus);
    }
}
