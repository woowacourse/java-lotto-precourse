package domain;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Collections;
import java.util.Vector;
import java.util.Arrays;
import java.util.HashSet
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

    private final Scanner input = new Scanner(System.in);
    private int amount;
    private int spent;
    private final List<Lotto> lottos = new Vector<>();
    private HashSet<String> validator;
    final List<Integer> winningNumbers = new Vector<>();
    private int bonusNumber;
    WinningLotto winningLotto;
    final List<Rank> rankings = new Vector<>();
    final TreeMap<Rank, Integer> rankTable = new TreeMap<>();

    private long earned = 0;

    public static void main(String[] args) {
        try {
            new App();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    App() {
        inputAmount().validateAmountAndGetNumber().purchaseAndPrintLottos();
        inputWinningNumbers().parseWinningNumbers().validateWinningNumbers();
        inputBonusNumber().validateBonusNumber();
        getWinningLotto().matchLottos();
        initRankTable().fillRankTable();
        printResult();
    }

    private App inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            amount = input.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return this;
    }

    private App validateAmountAndGetNumber() {
        if (0 <= amount && amount < PRICE) {
            throw new IllegalArgumentException("금액이 부족합니다.");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        spent = amount / PRICE * PRICE;
        return this;
    }

    private App purchaseAndPrintLottos() {
        System.out.println("\n" + amount / PRICE + "개를 구매했습니다.");
        for (int i = 0; i < amount / PRICE; i++) {
            lottos.add(new Lotto(generateNumbers()).printNumbers());
        }
        return this;
    }

    /*
    1 ~ 45의 수열을 섞어서 앞 6개의 번호를 로또로 자동 발권
     */
    private List<Integer> generateNumbers() {
        final List<Integer> numbers = new Vector<>();

        Collections.shuffle(SEQUENCE);
        for (int x : SEQUENCE.subList(0, LOTTO_NUMBER_OF_PICKS)) {
            numbers.add(x);
        }
        numbers.sort((a, b) -> a > b ? 1 : -1);
        return numbers;
    }

    private App inputWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        validator = new HashSet<>(Arrays.asList(input.next().split(",")));
        if (validator.size() != LOTTO_NUMBER_OF_PICKS) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return this;
    }

    private App parseWinningNumbers() {
        for (String x : validator) {
            winningNumbers.add(Integer.parseInt(x));
        }
        return this;
    }

    private App validateWinningNumbers() {
        winningNumbers.sort((a, b) -> (a > b) ? 1 : -1);
        if (winningNumbers.get(0) < LOTTO_MIN) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        if (winningNumbers.get(LOTTO_NUMBER_OF_PICKS - 1) > LOTTO_MAX) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return this;
    }

    private App inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        try {
            bonusNumber = input.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return this;
    }

    private void validateBonusNumber() {
        if (bonusNumber < LOTTO_MIN || bonusNumber > LOTTO_MAX) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    private App getWinningLotto() {
        winningLotto = new WinningLotto(
            new Lotto(winningNumbers),
            bonusNumber
        );
        return this;
    }

    private App matchLottos() {
        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.match(lotto);
            boolean temp = (rank.getCountOfMatch() == 0)|| rankings.add(rank);
        }
        return this;
    }

    private App initRankTable() {
        for (Rank rank : Rank.values()) {
            rankTable.put(rank, 0);
        }
        rankTable.remove(Rank.MISS);
        rankTable.descendingMap();
        return this;
    }

    private App fillRankTable() {
        for (Rank rank : rankings) {
            rankTable.put(rank, rankTable.get(rank) + 1);
        }
        return this;
    }

    private App printResult() {
        System.out.println("\n당첨 통계 \n---------");
        for (Rank key : rankTable.keySet()) {
            printRow(key);
            earned += key.getWinningMoney() * rankTable.get(key);
        }
        System.out.format("총 수익률은 %.3f입니다.", (double) earned / spent);
        return this;
    }

    private void printRow(final Rank key) {
        System.out.format(
            "%d개 일치, %s(%d원)- %d개\n",
            key.getCountOfMatch(),
            (key == Rank.SECOND) ? "보너스 볼 일치" : "",
            key.getWinningMoney(),
            rankTable.get(key)
        );
    }
}