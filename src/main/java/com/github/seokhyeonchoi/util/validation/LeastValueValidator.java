package com.github.seokhyeonchoi.util.validation;

public class LeastValueValidator {
	private final int leastValue;

	public LeastValueValidator(int leastValue) {
		this.leastValue = leastValue;
	}

	public boolean valid(int value) {
		return (value >= leastValue);
	}
}
