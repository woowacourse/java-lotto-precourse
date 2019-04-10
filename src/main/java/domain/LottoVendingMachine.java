package domain;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 로또게임의 입력, 출력을 담당하는 객체
 */
class LottoVendingMachine {
    private int purchasedLottoCount;
    private List<Integer> winningLottoNumberList;

    LottoVendingMachine() {
        purchasedLottoCount = getLottoPurchaseMoney() / LottoGame.LOTTO_PRICE;
    }

    int getPurchasedLottoCount() {
        return purchasedLottoCount;
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

    List<Integer> getWinningLottoNumberList() {
        String winningLottoNumbers;

        do {
            winningLottoNumbers = inputWinningLottoNumbers();
        } while (!isValidWinningLottoNumbers(winningLottoNumbers));

        return winningLottoNumberList = separateWinningLottoNumbers(winningLottoNumbers)
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
        String bonusNumber;

        do {
            bonusNumber = inputBonusNumber();
        } while (!isValidBonusNumber(bonusNumber));

        return Integer.parseInt(bonusNumber);
    }

    private String inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");

        return input();
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
