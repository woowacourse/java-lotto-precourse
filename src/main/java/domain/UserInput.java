package domain;

import java.lang.reflect.Array;
import java.util.*;

public class UserInput {
    static final String SEPARATOR = ",";



    private static boolean isNumber(char character) {
        return character >= '0' && character <= '9';
    }

    private static boolean isZeroOrPositiveNumber(String string) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            count = incrementsIfTrue(count, isNumber(string.charAt(i)));
        }

        return count == string.length() && string.length() != 0;
    }

    private static int incrementsIfTrue(int count, boolean bool) {
        if (bool) {
            count = count + 1;
        }
        return count;
    }

    public static boolean isInRange(String string, int bottom, int top) {
        int number;

        if (!isZeroOrPositiveNumber(string)) {

            return false;
        }
        number = Integer.parseInt(string);
        return number >= bottom && number <= top;
    }

    public static boolean isInRange(String string, int bottom) {
        int number;

        if (!isZeroOrPositiveNumber(string)) {
            return false;
        }
        number = Integer.parseInt(string);

        return number >= bottom;
    }

    public static List<Integer> convertsToLottoNumbers(String string) {
        List<Integer> integerList = new ArrayList<>();
        List<String> strings = Arrays.asList(string.split(SEPARATOR));

        for (String s : strings
        ) {
            addNumberToLottoNumberList(integerList, s.trim());
        }
        return integerList;
    }

    private static void addNumberToLottoNumberList(List<Integer> integerList, String string) {
        if (isInRange(string, Lotto.BOTTOM, Lotto.TOP)) {
            integerList.add(Integer.parseInt(string));
        }

        return;
    }

    public static boolean hasRepeatedNumbers(List<Integer> integerList) {
        Set<Integer> set = new HashSet<>(integerList);

        return set.size() != integerList.size();
    }


}
