package utils;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Integer> convertString2Int(String[] rawWinningNumber) {
        List<Integer> intList = new ArrayList<>();
        for (String str: rawWinningNumber) {
            intList.add(Integer.parseInt(str));
        }
        return intList;
    }
}