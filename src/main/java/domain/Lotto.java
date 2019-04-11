/*
 * @(#)Lotto.java	1.8.0_191 2019/04/11
 * 
 * Copyright (c) 2019 Youngbae Son
 * ComputerScience, ProgrammingLanguage, Java, Busan, KOREA
 * All rights reserved.
 * 
 * */
package domain;

import java.util.Collections;
import java.util.List;

/**
 * 로또 한장을 의미하는 객체 Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
 * 
 */
public class Lotto {

	private final List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	/*로또는 기본적으로 정렬이 되어있는 상태로 저장되어 있다*/
	public void sort() {

		Collections.sort(numbers);
	}

	public void printLotto() {

		System.out.print("[");

		for (int i = 0; i < numbers.size(); i++) {
			System.out.print(numbers.get(i));
			if (i < numbers.size() - 1) {
				System.out.print(",");
			}
		}

		System.out.println("]");
	}

}
