package domain;

import domain.interfaces.LottoNumberGenerator;
import domain.interfaces.UserInterface;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

class Player {
    private static final int UNIT_PRICE_OF_LOTTO = 1000;

    private LottoNumberGenerator generator;
    private UserInterface ui;

    Player(LottoNumberGenerator generator, UserInterface ui) {
        this.generator = generator;
        this.ui = ui;
    }

    void play() {
        int totalPrice = promptTotalPriceInput();
        List<Lotto> lottos = createLottos(totalPrice / UNIT_PRICE_OF_LOTTO);
        ui.printBoughtLottos(lottos);
        WinningLotto winningLotto = createWinningLotto();
        WinningStatistics stat = createWinningStatistics(winningLotto, lottos);
        printWinningResult(stat);
    }

    private List<Lotto> createLottos(int qty) {
        LottoFactory factory = new LottoFactory(generator);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < qty; i++) {
            lottos.add(factory.createLotto());
        }

        return lottos;
    }

    private WinningLotto createWinningLotto() {
        Lotto lotForWin = new Lotto(promptWinningNumbersInput());
        return new WinningLotto(
            lotForWin,
            promptBonusNumberInput(lotForWin)
        );
    }

    private WinningStatistics createWinningStatistics(WinningLotto win, List<Lotto> lottos) {
        WinningStatistics stat = new WinningStatistics();
        for (Lotto l : lottos) {
            stat.put(win.match(l));
        }
        return stat;
    }

    private void printWinningResult(WinningStatistics stat) {
        Rank[] ranksToPrint = new Rank[]{Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST};
        for (Rank r : ranksToPrint) {
            ui.printRank(r, stat.getCountOfWinning(r));
        }
        ui.printEarningRate(stat.calculateEarningRate(UNIT_PRICE_OF_LOTTO));
    }

    private int promptTotalPriceInput() {
        try {
            int n = ui.promptTotalPrice();
            checkIfNumberInRange(n, UNIT_PRICE_OF_LOTTO, Integer.MAX_VALUE);
            checkIfTotalPriceDivisibleByUnitPrice(n);
            return n;
        } catch (IllegalArgumentException | InputMismatchException e) {
            ui.notifyInvalidInput();
            return promptTotalPriceInput();
        }
    }

    private List<Integer> promptWinningNumbersInput() {
        try {
            List<Integer> nums = ui.promptWinningNumbers();
            checkIfNumbersInLottoNumberRange(nums);
            checkWinningNumbersLength(nums);
            return nums;
        } catch (IllegalArgumentException e) {
            ui.notifyInvalidInput();
            return promptWinningNumbersInput();
        }
    }

    private int promptBonusNumberInput(Lotto winningLotto) {
        try {
            int n = ui.promptBonusNumber();
            checkIfNumberInRange(n, LottoNumberGenerator.LOTTO_NUM_MIN, LottoNumberGenerator.LOTTO_NUM_MAX);
            checkIfBonusNumberInLotto(winningLotto, n);
            return n;
        } catch (IllegalArgumentException e) {
            ui.notifyInvalidInput();
            return promptBonusNumberInput(winningLotto);
        }
    }

    /**
     * Test if min <= n <= max
     *
     * @param n   number to test
     * @param min min value(boundary included)
     * @param max max value(boundary included)
     * @throws NumberFormatException If number is not in specified range
     */
    private void checkIfNumberInRange(int n, int min, int max) {
        if (n >= min && n <= max) {
            return;
        }
        throw new NumberFormatException(String.format("%d is not in range between %d and %d",
            n, min, max));
    }

    private void checkIfNumbersInLottoNumberRange(List<Integer> nums) {
        for (int i : nums) {
            checkIfNumberInRange(i, LottoNumberGenerator.LOTTO_NUM_MIN, LottoNumberGenerator.LOTTO_NUM_MAX);
        }
    }

    private void checkWinningNumbersLength(List<Integer> nums) {
        if (nums.size() != LottoNumberGenerator.LOTTO_NUMS_LENGTH) {
            throw new IllegalArgumentException("Invalid numbers length: " + nums.size());
        }
    }

    private void checkIfTotalPriceDivisibleByUnitPrice(int totalPrice) {
        if (totalPrice % UNIT_PRICE_OF_LOTTO == 0) {
            return;
        }
        throw new IllegalArgumentException(String.format("%d isn't divisible by %d",
            totalPrice, UNIT_PRICE_OF_LOTTO));
    }

    private void checkIfBonusNumberInLotto(Lotto l, int n) {
        if (l.contains(n)) {
            throw new IllegalArgumentException(String.format("Bonus number %d is in %s", n, l));
        }
    }
}
