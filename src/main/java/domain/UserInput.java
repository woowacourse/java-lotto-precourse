package domain;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInput {

    private static final String SEPARATOR = ",";
    private String input;

    public UserInput() {
        Scanner s = new Scanner(System.in);
        input = s.nextLine().trim();
    }

    private boolean isNumber(char character) {
        return character >= '0' && character<= '9';
    }

    private boolean isZeroOrPositiveNumber(String string) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            count =  incrementsIfTrue(count, isNumber(string.charAt(i)));
        }

        return count == string.length() && string.length() != 0;
    }

    private int incrementsIfTrue(int count, boolean bool) {
        if(bool) {
            count = count + 1;
        }
        return count;
    }

    public boolean isInRange(String string, int bottom, int top) {
        int number;

        if(!isZeroOrPositiveNumber(string)) {
            return false;
        }
        number = Integer.parseInt(string);

        return number >= bottom && number <= top;
    }

    public boolean isInRange(String string, int bottom) {
        int number;

        if(!isZeroOrPositiveNumber(string)) {
            return false;
        }
        number = Integer.parseInt(string);

        return number >= bottom;
    }

    public List<Integer> convertsToLottoNumbers() {
        List<Integer> integerList = new ArrayList<>();
        List<String> strings = Arrays.asList(input.split(","));

        for (String s : strings
             ) {
            addNumberToLottoNumberList(integerList, s.trim());
        }
        return integerList;
    }

    private void addNumberToLottoNumberList(List<Integer> integerList, String string) {
        if(isInRange(string, Lotto.BOTTOM, Lotto.TOP)) {
            integerList.add(Integer.parseInt(string));
        }

        return;
    }



}
