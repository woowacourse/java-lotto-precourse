package domain;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 로또게임을 진행하는 객체
 */
public class LottoGame {
    private static final int THE_NUMBER_OF_LOTTO_NUMBERS = 6;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int LOTTO_PRICE = 1000;
    private static final int ONE = 1;
    private static final int ZERO = 0;
    private static final int EARNINGS_RATE_DECIMAL_POINT = 2;
    private static final int PERCENT = 100;
    private static final String INPUT_LOTTO_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String INPUT_WINNING_LOTTO_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String WINNING_LOTTO_NUMBERS_DELIMITER = ",";
    private static final String INPUT_LOTTO_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String RESULT_MESSAGE = "당첨 통계\n-------------------------------------------";
    private static final String RESULT_BY_RANK_MESSAGE = "%d개 일치 (%d원)- %d개\n";
    private static final String SECOND_RANK_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원)- %d개\n";
    private static final String EARNINGS_RATE_MESSAGE = "총 수익률은 %." + EARNINGS_RATE_DECIMAL_POINT + "f%%입니다.";

    private List<Lotto> lottoes;
    private WinningLotto winningLotto;

    public LottoGame() {

    }

    public void turnOn() {
        run();
    }

    private void run() {
        registerLottoes();
        printLottoes();
        registerWinningLotto();
        printResult();
        printEarningsRate();
    }

    private void registerLottoes() {
        lottoes = new ArrayList<>();
        int lottoCount = getLottoCount();

        for (int i = 0; i < lottoCount; i++) {
            lottoes.add(createLotto());
        }
    }

    private int getLottoCount() {
        int lottoPurchaseMoney = getLottoPurchaseMoney();

        return lottoPurchaseMoney / LOTTO_PRICE;
    }

    private int getLottoPurchaseMoney() {
        String lottoPurchaseMoney;

        do {
            lottoPurchaseMoney = inputLottoPurchaseMoney();
        } while (!isValidLottoPurchaseMoney(lottoPurchaseMoney));

        return Integer.parseInt(lottoPurchaseMoney);
    }

    private String inputLottoPurchaseMoney() {
        System.out.println(INPUT_LOTTO_PURCHASE_MONEY_MESSAGE);

        return input();
    }

    private String input() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

    private boolean isValidLottoPurchaseMoney(String lottoPurchaseMoney) {
        if (!isInteger(lottoPurchaseMoney)) {
            return false;
        }

        return !isNegativeNumber(Integer.parseInt(lottoPurchaseMoney));
    }

    private boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    private boolean isNegativeNumber(int number) {
        return number < 0;
    }

    private Lotto createLotto() {
        List<Integer> lottoNumbers = createLottoNumbers();
        Collections.sort(lottoNumbers);

        return new Lotto(lottoNumbers);
    }

    private List<Integer> createLottoNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>();

        while (lottoNumbers.size() < THE_NUMBER_OF_LOTTO_NUMBERS) {
            int lottoNumber = createLottoNumber();
            addLottoNumber(lottoNumber, lottoNumbers);
        }

        return lottoNumbers;
    }

    private int createLottoNumber() {
        return (int) (Math.random() * MAX_LOTTO_NUMBER) + MIN_LOTTO_NUMBER;
    }

    private void addLottoNumber(int lottoNumber, List<Integer> lottoNumbers) {
        if (!lottoNumbers.contains(lottoNumber)) {
            lottoNumbers.add(lottoNumber);
        }
    }

    private void printLottoes() {
        System.out.println(lottoes.size() + LOTTO_COUNT_MESSAGE);
        for (Lotto lotto : lottoes) {
            lotto.printLottoNumbers();
        }
    }

    private void registerWinningLotto() {
        winningLotto = createWinningLotto();
    }

    private WinningLotto createWinningLotto() {
        List<Integer> winningLottoNumbers = getWinningLottoNumbers();
        int bonusNumber = getBonusNumber(winningLottoNumbers);

        return new WinningLotto(createLotto(winningLottoNumbers), bonusNumber);
    }

    private List<Integer> getWinningLottoNumbers() {
        String winningLottoNumbers;

        do {
            winningLottoNumbers = inputWinningLottoNumbers();
        } while (!isValidWinningLottoNumbers(winningLottoNumbers));

        return separateWinningLottoNumbers(winningLottoNumbers)
                .stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    private String inputWinningLottoNumbers() {
        System.out.println(INPUT_WINNING_LOTTO_NUMBER_MESSAGE);

        return input();
    }

    private boolean isValidWinningLottoNumbers(String winningLottoNumbers) {
        List<String> segregatedWinningLottoNumbers = separateWinningLottoNumbers(winningLottoNumbers);

        return isExactLength(segregatedWinningLottoNumbers)
                && isInteger(segregatedWinningLottoNumbers)
                && isProperRange(segregatedWinningLottoNumbers)
                && !hasDuplicateNumber(segregatedWinningLottoNumbers);
    }

    private List<String> separateWinningLottoNumbers(String winningLottoNumbers) {
        return Arrays.asList(winningLottoNumbers.split(WINNING_LOTTO_NUMBERS_DELIMITER));
    }

    /* 쉼표로 구분한 당첨번호의 길이가 6인지 판단하는 메소드 */
    private boolean isExactLength(List<String> segregatedWinningLottoNumbers) {
        return segregatedWinningLottoNumbers.size() == THE_NUMBER_OF_LOTTO_NUMBERS;
    }

    private boolean isInteger(List<String> segregatedWinningLottoNumbers) {
        boolean result = true;

        for (String winningLottoNumber : segregatedWinningLottoNumbers) {
            result = result && isInteger(winningLottoNumber);
        }

        return result;
    }

    private boolean isProperRange(List<String> segregatedWinningLottoNumbers) {
        boolean result = true;

        for (String winningLottoNumber : segregatedWinningLottoNumbers) {
            result = result && (Integer.parseInt(winningLottoNumber) >= MIN_LOTTO_NUMBER
                    && Integer.parseInt(winningLottoNumber) <= MAX_LOTTO_NUMBER);
        }

        return result;
    }

    private boolean hasDuplicateNumber(List<String> segregatedWinningLottoNumbers) {
        Set<Integer> set = new HashSet<>();

        for (String winningLottoNumber : segregatedWinningLottoNumbers) {
            set.add(Integer.parseInt(winningLottoNumber));
        }

        return set.size() != THE_NUMBER_OF_LOTTO_NUMBERS;
    }

    private int getBonusNumber(List<Integer> winningLottoNumbers) {
        String bonusNumber;

        do {
            bonusNumber = inputBonusNumber();
        } while (!isValidBonusNumber(bonusNumber, winningLottoNumbers));

        return Integer.parseInt(bonusNumber);
    }

    private String inputBonusNumber() {
        System.out.println(INPUT_LOTTO_BONUS_NUMBER_MESSAGE);

        return input();
    }

    private boolean isValidBonusNumber(String bonusNumber, List<Integer> winningLottoNumbers) {
        if (!isInteger(bonusNumber) || winningLottoNumbers.contains(Integer.parseInt(bonusNumber))) {
            return false;
        }

        return Integer.parseInt(bonusNumber) >= MIN_LOTTO_NUMBER && Integer.parseInt(bonusNumber) <= MAX_LOTTO_NUMBER;
    }

    private Lotto createLotto(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);

        return new Lotto(lottoNumbers);
    }

    private void printResult() {
        System.out.println(RESULT_MESSAGE);
        printResultByRank(Rank.FIFTH);
        printResultByRank(Rank.FOURTH);
        printResultByRank(Rank.THIRD);
        printResultByRank(Rank.SECOND);
        printResultByRank(Rank.FIRST);
    }

    private void printResultByRank(Rank rank) {
        if (rank == Rank.SECOND) {
            System.out.printf(SECOND_RANK_RESULT_MESSAGE,
                    rank.getCountOfMatch(), rank.getWinningMoney(), getLottoCountByRank(rank));

            return;
        }
        System.out.printf(RESULT_BY_RANK_MESSAGE,
                rank.getCountOfMatch(), rank.getWinningMoney(), getLottoCountByRank(rank));
    }

    private int getLottoCountByRank(Rank rank) {
        int lottoCount = 0;

        for (Lotto lotto : lottoes) {
            lottoCount += winningLotto.match(lotto) == rank ? ONE : ZERO;
        }

        return lottoCount;
    }

    private void printEarningsRate() {
        System.out.printf(EARNINGS_RATE_MESSAGE, getEarningsRate());
    }

    private double getEarningsRate() {
        return (double) getWinningMoneyTotal() / (lottoes.size() * LOTTO_PRICE) * PERCENT;
    }

    private int getWinningMoneyTotal() {
        int winningMoneyTotal = 0;

        for (Rank rank : Rank.values()) {
            winningMoneyTotal += getWinningMoneyTotalByRank(rank);
        }

        return winningMoneyTotal;
    }

    private int getWinningMoneyTotalByRank(Rank rank) {
        return getLottoCountByRank(rank) * rank.getWinningMoney();
    }
}
