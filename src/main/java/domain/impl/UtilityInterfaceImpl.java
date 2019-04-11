/*
 * UtilityInterfaceImpl Class
 *
 * @version 1
 *
 * @date 2019-04-10
 *
 * Copyright (c) 2019. Jihun oh
 * All rights reserved.
 */
package domain.impl;

import domain.interfaces.UtilityInterface;

public class UtilityInterfaceImpl implements UtilityInterface {
    @Override
    public int[] convertStrArrToIntArr(String[] numArr) {
        int[] nums = new int[numArr.length];
        for(int th = 0 ; th < numArr.length ; th++){
            nums[th] = Integer.parseInt(numArr[th]);
        }
        return nums;
    }
}
