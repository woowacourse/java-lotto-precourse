package domain;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Collections;
import java.util.Vector;

/**
 * 어플리케이션 객체
 */
public class App {
    private static final Scanner input = new Scanner(System.in);
    private static final List<Lotto> lottos = new Vector<>();

    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
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
        final int number = validateAmountAndGetNumber(inputAmount());

        System.out.println("\n" + number + "개를 구매했습니다.");
        for (int i = 0; i < number; i++) {
            buyLottoAndPrint();
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
        return amount / PRICE;
    }

    /*
    1 ~ 45의 수열을 섞어서 앞 6개의 번호를 로또 자동 발권
     */
    private static void buyLottoAndPrint() {
        final Lotto lotto;
        final List<Integer> pickedNumbers;

        Collections.shuffle(SEQUENCE);
        pickedNumbers = SEQUENCE.subList(0, 6);
        pickedNumbers.sort((a, b) -> a > b ? 1 : -1);
        lotto = new Lotto(pickedNumbers);
        lottos.add(lotto);
    }
}