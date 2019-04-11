/*
 * @(#)LottoNumberGenerator.java		2019/4/11
 * 
 * Copyright (c) 2019 Junmo Han.
 * All rights reserved.
 */

/**
 * LottoNumberGenerator 클래스는 로또 번호는 생성해주는 기능을 합니다. 
 * 
 * @version			1.00 2019년 4월 11일
 * @author 			한준모
 */

package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

public class LottoNumberGenerator {
		public static final int THE_NUM_OF_LOTTO_NUMS = 6;
		public static final int MIN_RANDOM_NUMBER = 1;
		public static final int MAX_RANDOM_NUMBER = 45;
		
		private static final Random RANDOM = new Random();
		
		public static List<Integer> makeLottoNumbers() {
				ArrayList<Integer> lottoNumbers = new ArrayList<Integer>();
				
				while(lottoNumbers.size() < THE_NUM_OF_LOTTO_NUMS) {
						int randomNumber = RANDOM.nextInt(MAX_RANDOM_NUMBER) + MIN_RANDOM_NUMBER;
						isDuplication(lottoNumbers, randomNumber);
				}
				Collections.sort(lottoNumbers);
				
				return lottoNumbers;
		}
		
		private static void isDuplication(ArrayList<Integer> lottoNumbers, int randomNumber) {
				if (!lottoNumbers.contains(randomNumber)) {
						lottoNumbers.add(randomNumber);
				}
		}
}
