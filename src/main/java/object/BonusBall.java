/*
 *@(#)BonusBall.java           1.0 2019/04/11
 *Copyright (c) 2019 Hyogeon Kim.
 *Lotto Game, Java, Mungyeong, KOREA
 */

package object;

/**
 * 로또 게임에서 보너스 볼 하나를 나타내는 클래스
 * @author 김효건
 * @version 1.0 2019년 04월 011일
 */

public class BonusBall implements LottoNumber {
        public final int number;

        public BonusBall(int bonusBallNumber) {
                this.number = bonusBallNumber;
        }
}
