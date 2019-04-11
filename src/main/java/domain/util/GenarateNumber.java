package domain.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class GenarateNumber {
    public static List<Integer> genarateUserNumber(int amountOfNumbers) {
        List<Integer> numbersList = new ArrayList<>();
        while (numbersList.size() < amountOfNumbers) {
            int randomNumber = getRandomNum();
            addingNumberToList(numbersList, randomNumber);
        }
        Collections.sort(numbersList);
        return numbersList;
    }

    public static void addingNumberToList(List<Integer> numberList, int addNum) {
        if (!numberList.contains(addNum)) {
            numberList.add(addNum);
        }
    }

    public static int getRandomNum() {
        int randomNum = (int) (Math.random() * Constant.MAX_LOTTO_NUM + Constant.MIN_LOTTO_NUM);
        return randomNum;
    }
}
