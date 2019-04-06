package com.github.seokhyeonchoi.util.generation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {
	private static final Random RANDOM = new Random();

	public static List<Integer> generateRandomIntegerList(int min, int max, int size) {
		List<Integer> randomIntegerList = new ArrayList<Integer>();
		while (randomIntegerList.size() < size) {
			int randomNumber = RANDOM.nextInt(max) + min;
			if (!randomIntegerList.contains(randomNumber)) {
				randomIntegerList.add(randomNumber);
			}
		}
		return randomIntegerList;
	}
}
