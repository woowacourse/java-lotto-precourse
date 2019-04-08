/*
 * RandomNumberMaker.java
 */

package util;

import java.util.Random;

public class RandomNumberMaker {

	public static int getRandomNumber(int maxNumber, int minNumber) {
		Random random = new Random();
		return (random.nextInt(maxNumber) + minNumber);
	}
}
