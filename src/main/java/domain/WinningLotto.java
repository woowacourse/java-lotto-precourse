package domain;

import java.util.List;
import java.util.Random;

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
                List<Integer> userLottoList = userLotto.getNumbers();
                int countOfMatch = 0;
                boolean matchBonus;
                for (int number : userLottoList) {
                        countOfMatch = countLottoNumber(number, countOfMatch);
                }
                matchBonus = userLottoList.contains(bonusNo);
                return Rank.valueOf(countOfMatch, matchBonus);
        }

        private int countLottoNumber(int number, int countOfMatch) {
                if (lotto.getNumbers().contains(number)) {
                        countOfMatch++;
                }
                return countOfMatch;
        }

}
