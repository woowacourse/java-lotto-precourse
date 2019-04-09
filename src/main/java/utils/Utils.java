/*
 * @Utils.java     0.1 2019-04-10
 * Copyright(c) 2019 LeeYunSeop All rights reserved.
 * */

package utils;

import java.util.ArrayList;
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
}