package domain;

import java.util.ArrayList;
import java.util.List;

public class Check {
    private static List<Integer> userInputNumbers = new ArrayList<>();

    public static void isBonusNoValid(int bonusNo) throws Exception {
        if (userInputNumbers.contains(bonusNo)) {
            throw new NumberException("같은 숫자가 중복됩니다.");
        }
    }

    private static void isSixNumbers() throws Exception {
        if (userInputNumbers.size() != 6) {
            throw new NumberException("6개의 숫자가 필요합니다.");
        }
    }

    private static void limitValidity(int number) throws Exception {
        boolean isWithinLimit = (0 < number && number < 45);
        if (!isWithinLimit) {
            throw new NumberException("!~45까지 숫자만 입력하세요");
        }
    }

    private static void usedValidity(int number) throws Exception {
        boolean isUsed = userInputNumbers.contains(number);
        if (isUsed) throw new NumberException("중복된 숫자 입력하지 마세요");
    }


    private static void producingInteger(String s[]) throws Exception {
        userInputNumbers.clear();
        for (String tmp : s) {
            int number = Integer.parseInt(tmp);
            usedValidity(number);
            limitValidity(number);
            userInputNumbers.add(number);
        }
    }

    public static List<Integer> splitUserInput(String userInput) throws Exception {
        String[] s = userInput.replaceAll("\\s+", "").split(",");
        producingInteger(s);
        isSixNumbers();
        return userInputNumbers;
    }

}
