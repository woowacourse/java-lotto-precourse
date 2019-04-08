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
		if(list.contains(number) || number < 1 || 45 < number) {
			throw new Exception();
		}
		list.add(number);
	}
}
