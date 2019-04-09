package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNo;

    public WinningLotto(Lotto lotto, int bonusNo) {
        this.lotto = lotto;
        this.bonusNo = bonusNo;
    }

    public Rank match(Lotto userLotto) {
        // TODO 로직 구현
        return null;
    }

    public static String askUserWinningNumbers() {
        boolean isUserInputRight = false;
        String userInput = "E @ askUserWinningNumbers";
        while(!isUserInputRight) {
            userInput = Lotto.askAndReceiveInput("지난 주 당첨 번호를 입력해주세요.");
            userInput = userInput.replaceAll("\\s+","");
            isUserInputRight = checkUserInputWinningNumbers(userInput);
        }
        return userInput;
    }

    private static boolean checkUserInputWinningNumbers(String userInput) {
        if (isThereEmptyString(userInput) || isNonNumericThere(userInput) || isDuplicate(userInput)
                || isNotBetween1And45(userInput) || isLengthNot6(userInput)) {
            return false;
        }
        return true;
    }

    private static boolean isThereEmptyString(String userInput) {
        List<String> list = Arrays.asList(userInput.split(","));
        List<String> list2 = new ArrayList<>();
        for (int i=0, n=list.size(); i<n; i++) {
            list2.add(list.get(i));
        }
        boolean isEmptyString =false;
        while(!isEmptyString && !list2.isEmpty()) {
            String currentStr = list2.get(0);
            list2.remove(0);
            isEmptyString = checkStr(currentStr);
        }
        return isEmptyString;
    }

    private static boolean checkStr(String currentStr) {
        if(currentStr.isEmpty()) {
            System.out.println("6개의 숫자를 입력해 주세요!");
            return true;
        }
        return false;
    }

    private static boolean isNonNumericThere(String userInput) {
        if (userInput.matches("[0-9,]+")) {
            return false;
        }
        System.out.println("당첨번호는 양수인 정수만 입력해주세요");
        return true;
    }

    private static boolean isDuplicate(String userInput) {
        List<String> listToCheckDuplicate = createListToCheckDuplicate(userInput);
        boolean isDuplicating = false;
        while (!isDuplicating && !listToCheckDuplicate.isEmpty()) {
            String current = listToCheckDuplicate.get(0);
            listToCheckDuplicate.remove(0);
            isDuplicating = checkDuplicate(current, listToCheckDuplicate);
        }
        return isDuplicating;
    }

    private static List<String> createListToCheckDuplicate(String userInput) {
        List<String> list = Arrays.asList(userInput.split(","));
        List<String> listToCheckDuplicate = new ArrayList<>();
        for (int i=0, n= list.size(); i<n; i++) {
            listToCheckDuplicate.add(list.get(i));
        }
        return listToCheckDuplicate;
    }

    private static boolean checkDuplicate(String current, List<String> list) {
        if(list.contains(current)) {
            System.out.println("당첨번호에 중복되는 숫자가 있습니다.");
            return true;
        }
        return false;
    }

    private static boolean isNotBetween1And45(String userInput) {
        List<Integer> intListToCheckBetween1And45 = createListToCheckBetween1And45(userInput);
        boolean overLimit = false;
        while (!overLimit && !intListToCheckBetween1And45.isEmpty()) {
            overLimit = checkLimit(intListToCheckBetween1And45.get(0));
            intListToCheckBetween1And45.remove(0);
        }
        return overLimit;
    }

    private static List<Integer> createListToCheckBetween1And45 (String userInput) {
        List<String> list = Arrays.asList(userInput.split(","));
        List<Integer> listToCheckBetween1And45 = new ArrayList<>();
        for (int i=0, n=list.size(); i<n; i++) {
            listToCheckBetween1And45.add(Integer.parseInt(list.get(i)));
        }
        return listToCheckBetween1And45;
    }

    private static boolean checkLimit(int currentNumber) {
        if(currentNumber < 1 || currentNumber > 45) {
            System.out.println("당첨번호는 1~45사이에 넣어주세요!");
            return true;
        }
        return false;
    }

    private static boolean isLengthNot6(String userInput) {
        List<String> list = Arrays.asList(userInput.split(","));
        int n = list.size();
        if (n != 6) {
            System.out.println("당첨번호는 6개를 입력해주세요");
            return true;
        }
        return false;
    }

    public static int askUserBonusNumber(String winningNumbers) {
        boolean isUserInputRight = false;
        String userInput = "E @ askBonusNumer()";
        while (!isUserInputRight) {
            userInput = Lotto.askAndReceiveInput("보너스 볼을 입력해 주세요.");
            isUserInputRight = checkUserInputBonus(userInput, winningNumbers);
        }
        return Integer.parseInt(userInput);
    }








}
