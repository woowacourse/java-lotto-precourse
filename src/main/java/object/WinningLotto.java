/*
 *@(#)InputUtil.java           1.0 2019/04/11
 *Copyright (c) 2019 Hyogeon Kim.
 *Lotto Game, Java, Mungyeong, KOREA
 */

package object;

import domain.Rank;

/**
 * 로또 게임에서 지난 주 당첨 번호, 보너스 번호에 대한 정보를 갖고 있는 클래스
 * @author 김효건
 * @version 1.0 2019년 04월 011일
 */

public class WinningLotto implements LottoNumber {
        private final Lotto lotto;
        private final int bonusNo;

        public WinningLotto(Lotto lotto, int bonusNo) {
                this.lotto = lotto;
                this.bonusNo = bonusNo;
        }

        public Rank match(Lotto userLotto) {
                return Rank.valueOf(matchOfNumber(userLotto), matchOfBonusBall(userLotto));
        }

        private int matchOfNumber(Lotto userLotto) {
                return userLotto.requestCountMatchNumber(this.lotto);
        }

        private boolean matchOfBonusBall(Lotto userLotto) {
                return userLotto.hasBonusBall(this.bonusNo);
        }

}
