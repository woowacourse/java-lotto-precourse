package com.github.seokhyeonchoi.util.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicationValidator<T> {
	
	public DuplicationValidator() {
		
	}

	public boolean valid(List<T> values) {
		if (values.size() < 1) {
			return false;
		}
		Set<T> set = new HashSet<T>(values);

		return (set.size() == values.size());
	}

	public boolean valid(List<T> values, T value) {
		if (values.size() < 1) {
			return false;
		}
		Set<T> set = new HashSet<T>(values);
		set.add(value);

		return (set.size() == values.size() + 1);
	}

}
