/*
 * @Utils.java     0.1 2019-04-10
 * Copyright(c) 2019 LeeYunSeop All rights reserved.
 * */

package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 다른 class와 성격이 다른 기능을 여기서 구현
 *
 * @author yun
 * @version 0.1
 */
public class Utils {

    /**
     * string[]를 List<Integer>로 변환
     * */
    public static List<Integer> convertString2Int(String[] rawWinningNumber) {
        List<Integer> intList = new ArrayList<>();
        for (String str : rawWinningNumber) {
            intList.add(Integer.parseInt(str));
        }
        return intList;
    }

    /**
     * Lotto 번호 생성
     *
     * @return 1 ~ 45 사이, 크기가 6인 List
     */
    public static List<Integer> generatingLottoNumber() {
        int lottoCount = 6; // Lotto 숫자 갯수
        int lottoNumberBegin = 1; // Lotto 숫자 범위, 시작
        int lottoNumberEnd = 45; // Lotto 숫자 범위, 끝
        List<Integer> lottoNumber = new ArrayList<>();
        for (int number = lottoNumberBegin; number <= lottoNumberEnd; number++) {
            lottoNumber.add(number);
        }
        Collections.shuffle(lottoNumber);
        return lottoNumber.subList(0, lottoCount);
    }
}