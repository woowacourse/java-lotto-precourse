/*
 * RandomNumberMaker.java
 */

package util;

import java.util.Random;

public class RandomNumberMaker {
	private int minNum;
	private int maxNum;

	public RandomNumberMaker(int minNum, int maxNum) {
		this.minNum = minNum;
		this.maxNum = maxNum;
	}

	public int getRandomNumber() {
		Random random = new Random();
		return (random.nextInt(maxNum) + minNum);
	}
}
