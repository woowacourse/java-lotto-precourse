package com.github.seokhyeonchoi.util.validation;

import java.util.Iterator;
import java.util.List;

public class ValueRangeValidator {
	private final int min;
	private final int max;

	public ValueRangeValidator(int min, int max) {
		this.min = min;
		this.max = max;
	}

	public boolean valid(int value) {
		return (value >= min && value <= max);
	}
	
	public boolean valid(List<Integer> values) {		
		int count = 0;
		Iterator<Integer> iterator = values.iterator();
		
		while(iterator.hasNext() && valid(iterator.next())) {
			count++;
		}
		
		return (!values.isEmpty() && count == values.size());
	}
}
