package domain;

import java.util.Scanner;

public class UserInput {
    private String input;

    public UserInput() {
        Scanner s = new Scanner(System.in);
        input = s.nextLine();
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

    public boolean isInRange(int bottom, int top) {
        int number;

        if(!isZeroOrPositiveNumber(input)) {
            return false;
        }
        number = Integer.parseInt(input);

        return number >= bottom && number <= top;
    }

    public boolean isInRange(int bottom) {
        int number;

        if(!isZeroOrPositiveNumber(input)) {
            return false;
        }
        number = Integer.parseInt(input);

        return number >= bottom;
    }




}
