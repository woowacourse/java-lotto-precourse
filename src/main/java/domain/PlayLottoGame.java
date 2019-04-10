/*
 * @PlayLottoGame.java  1.00 2019/04/10
 *
 * Copyright(c)2019     HwiJin Hong.
 * All right reserved.
 *
 * [ 우아한 테크코스 3주차 미션 ]
 * 로또 게임 프로그램
 */

package domain;

/**
 * 로또 게임을 실행하는 클래스
 *
 * @author 홍휘진
 * @version 1.00 2019년 4월 10일
 */
public class PlayLottoGame {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.lottoGameStart();
    }
}
