package domain;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Collections;
import java.util.Vector;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 어플리케이션 객체
 */
public class App {
    private static final Scanner input = new Scanner(System.in);
    private static final List<Lotto> lottos = new Vector<>();

    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    private static final int LOTTO_NUMBER_OF_PICKS = 6;
    private static final int PRICE = 1000;
    private static final List<Integer> SEQUENCE;

    static {
        final List<Integer> numbers = new Vector<>();

        for (int i = LOTTO_MIN; i <= LOTTO_MAX; i++) {
            numbers.add(i);
        }
        SEQUENCE = numbers;
    }

    public static void main(String[] args) {
        purchaseLottos(validateAmountAndGetNumber(inputAmount()));
        getWinningLotto(validateWinningNumbers(parseWinningNumbers(inputWinningNumbers())), validateBonusNumber(inputBonusNumber()));
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
        return amount / PRICE;
    }

    private static void purchaseLottos(final int number) {
        System.out.println("\n" + number + "개를 구매했습니다.");
        for (int i = 0; i < number; i++) {
            purchaseLottoAndPrint();
        }
    }

    /*
    1 ~ 45의 수열을 섞어서 앞 6개의 번호를 로또 자동 발권
     */
    private static void purchaseLottoAndPrint() {
        final Lotto lotto;
        final List<Integer> pickedNumbers;

        Collections.shuffle(SEQUENCE);
        pickedNumbers = SEQUENCE.subList(0, LOTTO_NUMBER_OF_PICKS);
        pickedNumbers.sort((a, b) -> a > b ? 1 : -1);
        lotto = (new Lotto(pickedNumbers)).printNumbers();
        lottos.add(lotto);
    }

    private static HashSet<String> inputWinningNumbers() {
        final HashSet<String> validator;

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
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
        parsedList.sort((a, b) -> a > b ? 1 : -1);
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
}