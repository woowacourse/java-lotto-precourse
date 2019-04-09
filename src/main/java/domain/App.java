package domain;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Collections;
import java.util.Vector;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

/**
 * 어플리케이션 객체
 */
public class App {
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    public static final int LOTTO_NUMBER_OF_PICKS = 6;
    private static final int PRICE = 1000;
    private static final List<Integer> SEQUENCE = new Vector<>();
    static {
        for (int i = LOTTO_MIN; i <= LOTTO_MAX; i++) {
            SEQUENCE.add(i);
        }
    }

    private static final Scanner input = new Scanner(System.in);
    private static final List<Lotto> lottos = new Vector<>();
    private static int spent;
    private static long earned = 0;

    public static void main(String[] args) {
        try {
            purchaseLottosAndPrint(validateAmountAndGetNumber(inputAmount()));
            printResult(matchLottos(getWinningLotto(validateWinningNumbers(parseWinningNumbers(inputWinningNumbers())), validateBonusNumber(inputBonusNumber()))));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    private static int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return input.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private static int validateAmountAndGetNumber(final int amount) {
        if (0 <= amount && amount < PRICE) {
            throw new IllegalArgumentException("금액이 부족합니다.");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        spent = amount / PRICE * PRICE;
        return amount / PRICE;
    }

    private static void purchaseLottosAndPrint(final int number) {
        System.out.println("\n" + number + "개를 구매했습니다.");
        for (int i = 0; i < number; i++) {
            lottos.add(new Lotto(generateNumbers()).printNumbers());
        }
    }

    /*
    1 ~ 45의 수열을 섞어서 앞 6개의 번호를 로또로 자동 발권
     */
    private static List<Integer> generateNumbers() {
        final List<Integer> numbers = new Vector<>();

        Collections.shuffle(SEQUENCE);
        for (int x : SEQUENCE.subList(0, LOTTO_NUMBER_OF_PICKS)) {
            numbers.add(x);
        }
        numbers.sort((a, b) -> a > b ? 1 : -1);
        return numbers;
    }

    private static HashSet<String> inputWinningNumbers() {
        final HashSet<String> validator;

        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        validator = new HashSet<>(Arrays.asList(input.next().split(",")));
        if (validator.size() != LOTTO_NUMBER_OF_PICKS) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return validator;
    }

    private static List<Integer> parseWinningNumbers(final HashSet<String> input) {
        final List<Integer> parsedList = new Vector<>();

        for (String x : input) {
            parsedList.add(Integer.parseInt(x));
        }
        return parsedList;
    }

    private static List<Integer> validateWinningNumbers(final List<Integer> parsedList) {
        parsedList.sort((a, b) -> (a > b) ? 1 : -1);
        if (parsedList.get(0) < LOTTO_MIN) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        if (parsedList.get(LOTTO_NUMBER_OF_PICKS - 1) > LOTTO_MAX) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return parsedList;
    }

    private static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        try {
            return input.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private static int validateBonusNumber(final int number) {
        if (number < LOTTO_MIN || number > LOTTO_MAX) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return number;
    }

    private static WinningLotto getWinningLotto(final List<Integer> winningNumbers, final int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return new WinningLotto(new Lotto(winningNumbers), bonusNumber);
    }

    private static List<Rank> matchLottos(WinningLotto winningLotto) {
        final List<Rank> rankings = new Vector<>();

        for (Lotto lotto : lottos) {
            final Rank rank = winningLotto.match(lotto);
            final boolean temp = (rank.getCountOfMatch() == 0) || rankings.add(rank);
        }
        return rankings;
    }

    private static void printResult(List<Rank> rankings) {
        final Map<Rank, Integer> rankTable = fillRankTable(rankings, createRankTable());

        System.out.println("\n당첨 통계 \n---------");
        for (Rank key : rankTable.keySet()) {
            printRow(key, rankTable);
            earned += key.getWinningMoney() * rankTable.get(key);
        }
        System.out.format("총 수익률은 %.3f입니다.", (double) earned / spent);
    }

    private static Map<Rank, Integer> createRankTable() {
        final TreeMap<Rank, Integer> rankTable = new TreeMap<>();

        for (Rank rank : Rank.values()) {
            rankTable.put(rank, 0);
        }
        rankTable.remove(Rank.MISS);
        return rankTable.descendingMap();
    }

    private static Map<Rank, Integer> fillRankTable(List<Rank> rankings, Map<Rank, Integer> rankTable) {
        for (Rank rank : rankings) {
            rankTable.put(rank, rankTable.get(rank) + 1);
        }
        return rankTable;
    }

    private static void printRow(Rank key, Map<Rank, Integer> rankTable) {
        if (key == Rank.SECOND) {
            System.out.println(key.getCountOfMatch() + "개 일치, 보너스 볼 일치(" + key.getWinningMoney() + "원)- " + rankTable.get(key) + "개");
            return;
        }
        System.out.println(key.getCountOfMatch() + "개 일치 (" + key.getWinningMoney() + "원)- " + rankTable.get(key) + "개");
    }
}