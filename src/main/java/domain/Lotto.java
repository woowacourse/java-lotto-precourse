/*
 * @(#)Lotto.java		2019/4/11
 * 
 * Copyright (c) 2019 Junmo Han.
 * All rights reserved.
 */

/**
 * Lotto 클래스는 로또 한 장의 숫자들을 반환하는 기능을 합니다.
 * 
 * @version			1.00 2019년 4월 11일
 * @author 			한준모
 */

package domain;

import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
		private final List<Integer> numbers;
		
		public Lotto(List<Integer> numbers) {
    			this.numbers = numbers;
    	}

    	// 추가 기능 구현
    	public List<Integer> getNumbers() {
    			return numbers;
    	}
}	
