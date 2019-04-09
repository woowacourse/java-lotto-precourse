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


}
