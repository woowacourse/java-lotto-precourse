/**
 * LottoManager.class        1.00 2019/04/06
 *
 * <Copyright 2019. LeeNamJun. All rights reserved.>
 */
package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 클래스 설명
 *
 * @version 1.00
 * @author 이남준
 */
public class LottoManager implements Constants {
    LottoBuyer buyer = new LottoBuyer();

    public static List<Integer> MakeRandomNumber() {
        Random random = new Random();
        ArrayList<Integer> randomNumbers = new ArrayList<>();
        int randomNumber = random.nextInt(SIZE_OF_NUMBERS + 1) + 1;

        while (randomNumbers.size() != SIZE_OF_LOTTO) {
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
            randomNumber = random.nextInt(SIZE_OF_NUMBERS + 1) + 1;
        }
        return randomNumbers;
    }
}
