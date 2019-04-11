package domain;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 로또게임의 입력, 출력을 담당하는 객체
 */
class LottoVendingMachine {
    private int purchasedLottoMoney;
    private List<Integer> winningLottoNumberList;
    private int bonusNumber;

    int getPurchasedLottoCount() {
        return purchasedLottoMoney / LottoGame.LOTTO_PRICE;
    }

    void inputLottoPurchaseMoney() {
        String lottoPurchaseMoney;

        do {
            printMessage("구입금액을 입력해 주세요.");
            lottoPurchaseMoney = input();
        } while (!isValidLottoPurchaseMoney(lottoPurchaseMoney));

        purchasedLottoMoney = Integer.parseInt(lottoPurchaseMoney);
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

    List<Integer> getWinningLottoNumberList() {
        return winningLottoNumberList;
    }

    void inputWinningLottoNumbers() {
        String winningLottoNumbers;

        do {
            printMessage("지난 주 당첨 번호를 입력해 주세요.");
            winningLottoNumbers = input();
        } while (!isValidWinningLottoNumbers(winningLottoNumbers));

        winningLottoNumberList = separateWinningLottoNumbers(winningLottoNumbers)
                .stream().map(Integer::parseInt).collect(Collectors.toList());
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
        return segregatedWinningLottoNumbers.size() == LottoGame.THE_NUMBER_OF_LOTTO_NUMBERS;
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
            result = result && (Integer.parseInt(winningLottoNumber) >= LottoGame.MIN_LOTTO_NUMBER
                    && Integer.parseInt(winningLottoNumber) <= LottoGame.MAX_LOTTO_NUMBER);
        }

        return result;
    }

    private boolean hasDuplicateNumber(List<String> segregatedWinningLottoNumbers) {
        Set<Integer> set = new HashSet<>();

        for (String winningLottoNumber : segregatedWinningLottoNumbers) {
            set.add(Integer.parseInt(winningLottoNumber));
        }

        return set.size() != LottoGame.THE_NUMBER_OF_LOTTO_NUMBERS;
    }

    int getBonusNumber() {
        return bonusNumber;
    }

    void inputBonusNumber() {
        String bonusNumber;

        do {
            printMessage("보너스 볼을 입력해 주세요.");
            bonusNumber = input();
        } while (!isValidBonusNumber(bonusNumber));

        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private boolean isValidBonusNumber(String bonusNumber) {
        if (!isInteger(bonusNumber) || winningLottoNumberList.contains(Integer.parseInt(bonusNumber))) {
            return false;
        }

        return Integer.parseInt(bonusNumber) >= LottoGame.MIN_LOTTO_NUMBER
                && Integer.parseInt(bonusNumber) <= LottoGame.MAX_LOTTO_NUMBER;
    }

    void printMessage(String message) {
        System.out.println(message);
    }
}
