/*
 * NumberList
 * 
 * version 1.0
 * 
 * 2019. 4. 8
 * 
 * Created by Wongeun Song
 */

package edu.yk1028;

import java.util.ArrayList;
import java.util.List;

import edu.yk1028.Exception.DuplicateException;
import edu.yk1028.Exception.OutOfRangeException;

/**
 * 리스트에 추가시 유효성 검사를 하기 위한 객체
 * 
 * @author wongeunsong
 *
 */
public class NumberList {
	private List<Integer> list;

	public NumberList() {
		this.list = new ArrayList<Integer>();
	}

	public List<Integer> getList() {
		return this.list;
	}

	public void add(int number) throws Exception {
		if (list.contains(number)) {
			throw new DuplicateException();
		}
		if ((number < LottoConstant.MINIMUM_RANGE_OF_LOTTO_NUMBER)
				|| (LottoConstant.MAXIMUM_RANGE_OF_LOTTO_NUMBER < number)) {
			throw new OutOfRangeException();
		}
		list.add(number);
	}
}
