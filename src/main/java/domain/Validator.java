/*
 * @Validator.java      1.00 2019/04/10
 *
 * Copyright(c)2019     HwiJin Hong.
 * All right reserved.
 *
 * [ 우아한 테크코스 3주차 미션 ]
 * 로또 게임 프로그램
 */

package domain;

/**
 * 데이터에 대한 유효성을 검사해주는 클래스
 *
 * @version 1.00 2019년 4월 10일
 * @author 홍휘진
 *
 */
public class Validator {

    public static boolean isValidNumber(String numberScan) {
        try {
            Integer.parseInt(numberScan);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean notValidString(String lottoScan) {
        return !lottoScan.contains(",");
    }

}
