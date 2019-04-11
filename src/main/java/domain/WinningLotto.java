package domain;

import java.util.List;

import static domain.Rank.valueOf;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private static final int EXIST = 1;
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    /*
     * 구매한 로또와 당첨 로또와의 매칭 정도 판단
     */
    public Rank match(Lotto userLotto) {
        int matchCount = countMatchNum(userLotto);
        boolean matchBonus = matchBonusNum(userLotto);

        return valueOf(matchCount, matchBonus);
    }

    /*
     * 당첨 로또의 특정 인덱스와 구매한 로또의 번호가 같은지 판단
     */
    public int countMoreMatchNum(Lotto userLotto, int index) {
        int count, answer = 0;
        List<Integer> lottoNumber = lotto.getNumbers();
        List<Integer> userLottoNumber = userLotto.getNumbers();

        for (int i = 0; i < userLottoNumber.size(); i++) {
            count = (userLottoNumber.get(i) == lottoNumber.get(index)) ? EXIST : 0;
            answer += count;
        }
        return answer;
    }

    /*
     * 당첨 로또와 구매한 로또의 번호가 얼마나 같은지 판단
     */
    public int countMatchNum(Lotto userLotto) {
        int count = 0;
        List<Integer> userLottoNumber = userLotto.getNumbers();
        for (int i = 0; i < userLottoNumber.size(); i++) {
            count += countMoreMatchNum(userLotto, i);
        }
        return count;
    }

    /*
     * 당첨 로또 번호 중 보너스 숫자와의 일치 여부
     */
    public boolean matchBonusNum(Lotto userLotto) {
        int judge, answer = 0;
        List<Integer> userLottoNumber = userLotto.getNumbers();

        for (int i = 0; i < userLottoNumber.size(); i++) {
            judge = (userLottoNumber.get(i) == bonusNo) ? EXIST : 0;
            answer += judge;
        }
        return (answer == EXIST) ? true : false;
    }
}
