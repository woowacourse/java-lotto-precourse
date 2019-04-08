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
    private static final String INPUT_LOTTO_PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String INPUT_WINNING_LOTTO_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String WINNING_LOTTO_NUMBERS_DELIMITER = ",";
    private static final String INPUT_LOTTO_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String RESULT_MESSAGE = "당첨 통계\n-------------------------------------------";

    private List<Lotto> lottoes;

    public LottoGame() {

    }

    public void turnOn() {
        start();
    }

    private void start() {
        registerLottoes();
        printLottoes();
        WinningLotto winningLotto = createWinningLotto();
        printResult(winningLotto);
    }

    private String input() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
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

    private Lotto createLotto() {
        List<Integer> lottoNumbers = createLottoNumbers();
        Collections.sort(lottoNumbers);

        return new Lotto(lottoNumbers);
    }

    private Lotto createLotto(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);

        return new Lotto(lottoNumbers);
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

    private void printLottoes() {
        System.out.println(lottoes.size() + LOTTO_COUNT_MESSAGE);
        for (Lotto lotto : lottoes) {
            lotto.printLottoNumbers();
        }
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

        return isExactLength(segregatedWinningLottoNumbers) && isInteger(segregatedWinningLottoNumbers)
                && isProperRange(segregatedWinningLottoNumbers) && !hasDuplicateNumber(segregatedWinningLottoNumbers);
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

    private void printResult(WinningLotto winningLotto) {
        System.out.println(RESULT_MESSAGE);
        printResultByRank(Rank.FIFTH, winningLotto);
        printResultByRank(Rank.FOURTH, winningLotto);
        printResultByRank(Rank.THIRD, winningLotto);
        printResultByRank(Rank.SECOND, winningLotto);
        printResultByRank(Rank.FIRST, winningLotto);
    }

    private void printResultByRank(Rank rank, WinningLotto winningLotto) {
        if (rank == Rank.SECOND) {
            printResultSecondRank(rank, winningLotto);

            return;
        }

        System.out.println(String.valueOf(rank.getCountOfMatch()) + "개 일치 ("
                + rank.getWinningMoney() + "원)- " + getLottoCountByRank(rank, winningLotto) + "개");
    }

    private void printResultSecondRank(Rank rank, WinningLotto winningLotto) {
        System.out.println(String.valueOf(rank.getCountOfMatch()) + "개 일치, 보너스 볼 일치("
                + rank.getWinningMoney() + "원)- " + getLottoCountByRank(rank, winningLotto) + "개");
    }

    private int getLottoCountByRank(Rank rank, WinningLotto winningLotto) {
        int lottoCount = 0;

        for (Lotto lotto : lottoes) {
            lottoCount += winningLotto.match(lotto) == rank ? ONE : ZERO;
        }

        return lottoCount;
    }

    private int getWinningMoneyTotal(WinningLotto winningLotto) {
        int winningMoneyTotal = 0;

        for (Rank rank : Rank.values()) {
            winningMoneyTotal += getWinningMoneyTotalByRank(rank, winningLotto);
        }

        return winningMoneyTotal;
    }

    private int getWinningMoneyTotalByRank(Rank rank, WinningLotto winningLotto) {
        return getLottoCountByRank(rank, winningLotto) * rank.getWinningMoney();
    }
}
