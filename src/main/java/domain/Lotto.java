package domain;

import java.util.ArrayList;
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

    private static boolean checkUserInput(String userInput) {
        if (isItNonNumeric(userInput) || isItNotMultipleOf1000(userInput) || isSameAsOrSmallerThanZero(userInput)) {
            return false;
        }
        return true;
    }

    private static boolean isItNonNumeric(String userInput) {
        if (userInput.matches("[0-9]+")) {
            return false;
        }
        System.out.println("양수인 숫자만 입력가능합니다");
        return true;
    }

    private static boolean isItNotMultipleOf1000(String userInput) {
        int intUserInput = Integer.parseInt(userInput);
        if (intUserInput%PRICE_OF_ONE_LOTTO == 0) {
            return false;
        }
        System.out.println("입력금액은 1000원 단위로만 입력해주세요!");
        return true;
    }

    private static boolean isSameAsOrSmallerThanZero(String userInput) {
        int intUserInput = Integer.parseInt(userInput);
        if (intUserInput <= 0) {
            System.out.println("금액은 0보다 큰 금액으로 입력해주세요!");
            return true;
        }
        return false;
    }

    public static List<Lotto> makeListOfUserLottos(String userInput) {
        int intUserInput = Integer.parseInt(userInput);
        int quantitiesOfLottos = intUserInput/PRICE_OF_ONE_LOTTO;
        List<Lotto> listOfUserLottos = new ArrayList<>();
        for (int i=0; i<quantitiesOfLottos; i++) {
            Lotto currentLotto = new Lotto(makeListOfRandomNumbers());
            listOfUserLottos.add(currentLotto);
        }
        return listOfUserLottos;
    }

    private static List<Integer> makeListOfRandomNumbers() {
        List<Integer> listOf45 = makeListOf45();
        List<Integer> listOf6RandomNumbers = makeListOf6RandomNumbers(listOf45);
        return listOf6RandomNumbers;
    }

    private static List<Integer> makeListOf6RandomNumbers(List<Integer> listOf45) {
        List<Integer> listOf6RandomNumbers = new ArrayList<>();
        for (int i = STARTING_INDEX_OF_LOTTO_NUMBERS; i < ENDING_INDEX_OF_LOTTO_NUMBERS+1; i++) {
            int randomNumberIndex = (int) (Math.random()*listOf45.size());
            listOf6RandomNumbers.add(listOf45.get(randomNumberIndex));
            listOf45.remove(randomNumberIndex);
        }
        return listOf6RandomNumbers;
    }

    private static List<Integer> makeListOf45() {
        List<Integer>  listOf45 = new ArrayList<>();
        for (int i=LOTTO_MIN_NUMBER; i<LOTTO_MAX_NUMBER+1; i++) {
            listOf45.add(i);
        }
        return listOf45;
    }

}
