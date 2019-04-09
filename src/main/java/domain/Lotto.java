package domain;

import java.util.List;
import java.util.Scanner;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private static final int PRICE_OF_ONE_LOTTO = 1000;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int STARTING_INDEX_OF_LOTTO_NUMBERS = 0;
    private static final int ENDING_INDEX_OF_LOTTO_NUMBERS = 5;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // 추가 기능 구현
    public static String askAndReceiveInput(String sentence) {
        System.out.println(sentence);
        Scanner reader = new Scanner(System.in);
        String userInput = reader.nextLine();
        return userInput;
    }

    public static String askUserMoneyAmount() {
        boolean isUserInputRight = false;
        String userInputMoneyAmount = "ERROR:askUSerMoneyAmount()";
        while (!isUserInputRight) {
            userInputMoneyAmount = askAndReceiveInput("구입금액을 입력해 주세요.");
            userInputMoneyAmount = userInputMoneyAmount.replaceAll("\\s+","");
            isUserInputRight = checkUserInput(userInputMoneyAmount);
        }
        return userInputMoneyAmount;
    }


}
