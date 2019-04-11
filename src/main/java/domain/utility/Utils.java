/*
 * Utils Class
 *
 * @version 1
 *
 * @date 2019-04-10
 *
 * Copyright (c) 2019. Jihun oh
 * All rights reserved.
 */
package domain.utility;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<Integer> convertStrArrToIntList(String[] numArr) {
        List<Integer> nums = new ArrayList<>();
        for (int th = 0; th < numArr.length; th++) {
            nums.add(Integer.parseInt(numArr[th]));
        }
        return nums;
    }
}
