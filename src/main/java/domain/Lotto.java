package domain;

import java.util.*;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private static final int PRICE_OF_ONE_LOTTO = 1000;
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    private static final int STARTING_INDEX_OF_LOTTO_NUMBERS = 0;
    private static final int ENDING_INDEX_OF_LOTTO_NUMBERS = 5;
    public static final int LOTTO_NUMBERS_LENGTH = 6;
    public static final int FIRST_ELEMENT_INDEX = 0;
    private static final int LOTTO_MONEY_AMOUNT_MINIMUM = 0;

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
            userInputMoneyAmount = askAndReceiveInput("구입금액을 입력해 주세요.").replaceAll("\\s+", "");
            isUserInputRight = checkUserInput(userInputMoneyAmount);
        }
        return userInputMoneyAmount;
    }

    private static boolean checkUserInput(String userInput) {
        if (isMoreThanOne(userInput) || isThereComma(userInput) || isItNonNumeric(userInput)
                || isItNotMultipleOf1000(userInput) || isSameAsOrSmallerThanZero(userInput)) {
            return false;
        }
        return true;
    }

    private static boolean isThereComma(String userInput) {
        if (userInput.contains(",")) {
            System.out.println("금액은 쉼표없이 입력해주세요");
            return true;
        }
        return false;
    }

    private static boolean isMoreThanOne(String userInput) {
        List<String> listToCheckMoreThanOne = makeListToCheck(userInput);
        if (listToCheckMoreThanOne.size() > 1) {
            System.out.println("금액은 하나만 입력해 주세요. 또는, 쉼표없이 입력해 주세요");
            return true;
        }
        return false;
    }

    public static boolean isItNonNumeric(String userInput) {
        List<String> listToCheckNonNumeric = makeListToCheck(userInput);
        boolean isNonNumeric = false;
        while (!isNonNumeric && !listToCheckNonNumeric.isEmpty()) {
            String currentUserInput = listToCheckNonNumeric.get(0);
            listToCheckNonNumeric.remove(0);
            isNonNumeric = checkNonNumberic(currentUserInput);
        }
        return isNonNumeric;
    }

    private static boolean checkNonNumberic(String userInput) {
        if (userInput.matches("[0-9]+")) {
            return false;
        }
        System.out.println("양수인 숫자만 입력가능합니다!");
        return true;
    }

    public static List<String> makeListToCheck(String userInput) {
        List<String> list = Arrays.asList(userInput.split(","));
        List<String> listToCheck = new ArrayList<>();
        for (int i = 0, n = list.size(); i < n; i++) {
            listToCheck.add(list.get(i));
        }
        return listToCheck;
    }

    private static boolean isItNotMultipleOf1000(String userInput) {
        int intUserInput = Integer.parseInt(userInput);
        if (intUserInput % PRICE_OF_ONE_LOTTO == 0) {
            return false;
        }
        System.out.println("입력금액은 1000원 단위로만 입력해주세요!");
        return true;
    }

    private static boolean isSameAsOrSmallerThanZero(String userInput) {
        int intUserInput = Integer.parseInt(userInput);
        if (intUserInput <= LOTTO_MONEY_AMOUNT_MINIMUM) {
            System.out.println("금액은 0보다 큰 금액으로 입력해주세요!");
            return true;
        }
        return false;
    }

    public static List<Lotto> makeListOfUserLottos(String userInput) {
        int quantitiesOfLottos = Integer.parseInt(userInput) / PRICE_OF_ONE_LOTTO;
        List<Lotto> listOfUserLottos = new ArrayList<>();
        for (int i = 0; i < quantitiesOfLottos; i++) {
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
        for (int i = STARTING_INDEX_OF_LOTTO_NUMBERS; i < ENDING_INDEX_OF_LOTTO_NUMBERS + 1; i++) {
            int randomNumberIndex = (int) (Math.random() * listOf45.size());
            listOf6RandomNumbers.add(listOf45.get(randomNumberIndex));
            listOf45.remove(randomNumberIndex);
        }
        return listOf6RandomNumbers;
    }

    private static List<Integer> makeListOf45() {
        List<Integer> listOf45 = new ArrayList<>();
        for (int i = LOTTO_MIN_NUMBER; i < LOTTO_MAX_NUMBER + 1; i++) {
            listOf45.add(i);
        }
        return listOf45;
    }

    public static void printLottos(List<Lotto> listOfUserLottos) {
        System.out.println();
        int n = listOfUserLottos.size();
        System.out.println(n + "개를 구매했습니다.");
        for (int i = 0; i < n; i++) {
            System.out.println(listOfUserLottos.get(i).numbers);
        }
        System.out.println();
    }

    public static int compareNumbers(Lotto winningLotto, Lotto userLotto) {
        int count = 0;
        for (int i = 0, n = userLotto.numbers.size(); i < n; i++) {
            count += checkMatch(winningLotto.numbers, userLotto.numbers.get(i));
        }
        return count;
    }

    private static int checkMatch(List<Integer> winningLottoNumbers, int userLottoNumber) {
        int count = 0;
        if (winningLottoNumbers.contains(userLottoNumber)) {
            count = 1;
        }
        return count;
    }

    public static boolean compareBonus(int bonusNumber, Lotto userLotto) {
        if (userLotto.numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    public static List<Rank> makeListOfRanksInOrder() {
        List<Rank> rankList = Arrays.asList(Rank.values());
        List<Rank> rankListReversed = new ArrayList<>();
        for (int i = rankList.size() - 2; i >= 0; i--) {
            rankListReversed.add(rankList.get(i));
        }
        return rankListReversed;
    }

    public static List<Integer> makeListOfRankOccurences(List<Rank> listOfRanksInOrder, List<Rank> listOfUserLottosRanks) {
        List<Integer> listOfRankOccurences = new ArrayList<>();
        for (int i = 0, n = listOfRanksInOrder.size(); i < n; i++) {
            listOfRankOccurences.add(Collections.frequency(listOfUserLottosRanks, listOfRanksInOrder.get(i)));
        }
        return listOfRankOccurences;
    }

    public static void printStatistics(List<Rank> listOfRanksInOrder, List<Integer> listOfRankOccurences) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        printFirstThree(listOfRanksInOrder, listOfRankOccurences);
        printRest(listOfRanksInOrder, listOfRankOccurences);
    }

    private static void printFirstThree(List<Rank> listOfRanksInOrder, List<Integer> listOfRankOccurences) {
        for (int i = 0, n = listOfRanksInOrder.size() - 2; i < n; i++) {
            System.out.print(listOfRanksInOrder.get(i).getCountOfMatch() + "개 일치 (");
            System.out.print(listOfRanksInOrder.get(i).getWinningMoney() + "원)-");
            System.out.println(listOfRankOccurences.get(i) + "개");
        }
    }

    private static void printRest(List<Rank> listOfRanksInOrder, List<Integer> listOfRankOccurences) {
        System.out.print(listOfRanksInOrder.get(3).getCountOfMatch() + "개 일치, 보너스 볼 일치 (");
        System.out.print(listOfRanksInOrder.get(3).getWinningMoney() + "원)-");
        System.out.println(listOfRankOccurences.get(3) + "개");
        System.out.print(listOfRanksInOrder.get(4).getCountOfMatch() + "개 일치 (");
        System.out.print(listOfRanksInOrder.get(4).getWinningMoney() + "원)-");
        System.out.println(listOfRankOccurences.get(4) + "개");
    }

    public static void printProfitRate(String userInput, List<Rank> listOfUserLottoRanks) {
        double doubleUserInput = Double.parseDouble(userInput);
        double total = 0;
        for (int i = 0, n = listOfUserLottoRanks.size(); i < n; i++) {
            total += listOfUserLottoRanks.get(i).getWinningMoney();
        }
        double profitRate = total / doubleUserInput;
        System.out.println("총 수익률은 " + profitRate + "입니다.");
    }
}
