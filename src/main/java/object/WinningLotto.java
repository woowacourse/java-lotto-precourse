package object;

import domain.Rank;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto implements LottoNumber {
        private final Lotto lotto;
        private final int bonusNo;

        public WinningLotto(Lotto lotto, int bonusNo) {
                this.lotto = lotto;
                this.bonusNo = bonusNo;
        }

        public Rank match(Lotto userLotto) {
                return null;
        }

        private int matchOfNumber(Lotto userLotto){
                for(int i=0;userLotto.)
        }

        private int matchOfBonusBall(){

        }

}
