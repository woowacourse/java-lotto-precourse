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
    private static final int PERCENT = 100;

    private List<Lotto> lottoList;
    private WinningLotto winningLotto;

    public void turnOn() {
        run();
    }

    private void run() {
        registerLottoList();
        printLottoList();
        registerWinningLotto();
        printResult();
        printEarningsRate();
    }

    private void registerLottoList() {
        lottoList = new ArrayList<>();
        int lottoCount = getLottoCount();

        for (int i = 0; i < lottoCount; i++) {
            lottoList.add(createLotto());
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
        System.out.println("구입금액을 입력해 주세요.");

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

    private void printLottoList() {
        System.out.println(String.format("%d개를 구매했습니다.", lottoList.size()));
        for (Lotto lotto : lottoList) {
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
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

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
        return Arrays.asList(winningLottoNumbers.split(","));
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
        System.out.println("보너스 볼을 입력해 주세요.");

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
        System.out.println("당첨 통계\n-------------------------------------------");
        printResultByRank(Rank.FIFTH);
        printResultByRank(Rank.FOURTH);
        printResultByRank(Rank.THIRD);
        printResultByRank(Rank.SECOND);
        printResultByRank(Rank.FIRST);
    }

    private void printResultByRank(Rank rank) {
        if (rank == Rank.SECOND) {
            System.out.println(String.format("%d개 일치, 보너스 볼 일치 (%d원)- %d개",
                    rank.getCountOfMatch(), rank.getWinningMoney(), getLottoCountByRank(rank)));

            return;
        }
        System.out.println(String.format("%d개 일치 (%d원)- %d개",
                rank.getCountOfMatch(), rank.getWinningMoney(), getLottoCountByRank(rank)));
    }

    private int getLottoCountByRank(Rank rank) {
        return Math.toIntExact(lottoList.stream().filter(lotto -> winningLotto.match(lotto) == rank).count());
    }

    private void printEarningsRate() {
        System.out.println(String.format("총 수익률은 %.2f%%입니다.", getEarningsRate()));
    }

    private double getEarningsRate() {
        return (double) getWinningMoneyTotal() / (lottoList.size() * LOTTO_PRICE) * PERCENT;
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
