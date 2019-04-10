package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 사용자 입력에 대한 유효성 검사를 담당하는 객체
 */
public class Validator {
    private final int ZERO = 0;
    public boolean isNumericInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isPositiveInt(int number) {
        if (number < ZERO) {
            System.out.println("양의 정수만 입력할 수 있습니다");
            return false;
        }
        return true;
    }

    public boolean isEnough(int purchaseAmount) {
        if (purchaseAmount < LottoManager.PRICE_PER_LOTTO) {
            System.out.println("고작 그정도 돈으로는 로또를 살 수 없습니다. 적어도 1000원은 있어야 해요.");
            return false;
        }
        return true;
    }

    public boolean isMultipleOfLottoPrice(int purchaseAmount) {
        if (purchaseAmount % LottoManager.PRICE_PER_LOTTO != ZERO) {
            System.out.println("거스름돈을 드리기 애매합니다. 로또 가격인 1000원의 배수로만 입력해주세요.");
            return false;
        }
        return true;
    }

    public boolean isValidPurchase(String str) {
        int purchaseAmount;

        if (!isNumericInt(str)) {
            System.out.println("입력이 올바르지 않습니다. 정수인지, 수가 너무 크지는 않은지 확인해주세요.");
            return false;
        }

        purchaseAmount = Integer.parseInt(str);
        return isPositiveInt(purchaseAmount) && isEnough(purchaseAmount)
                && isMultipleOfLottoPrice(purchaseAmount);
    }

    public boolean isNumericIntList(List<String> userInput) {
        List<String> numerics = userInput.stream()
                .filter(str -> isNumericInt(str))
                .collect(Collectors.toList());

        return numerics.size() == userInput.size();
    }

    public boolean isInBounds(List<Integer> winningNumbers) {
        List<Integer> outbounds = winningNumbers.stream()
                .filter(number -> (number > LottoManager.WINNING_NUMBER_BOUND)
                        || (number < LottoManager.WINNING_NUMBER_ORIGIN))
                .collect(Collectors.toList());

        if (outbounds.size() > 0) {
            System.out.println("1부터 45까지의 숫자들만 입력할 수 있습니다.");
            return false;
        }
        return true;
    }

    public boolean isValidSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LottoManager.NUM_OF_WINNING_NUMBERS) {
            System.out.println(LottoManager.NUM_OF_WINNING_NUMBERS + "개의 숫자를 쉼표로 구분해 입력해주세요.");
            return false;
        }
        return true;
    }

    public boolean hasDuplicateNumbers(List<Integer> winningNumbers) {
        Set<Integer> winningNumberSet = new HashSet<Integer>(winningNumbers);

        if (winningNumberSet.size() != winningNumbers.size()) {
            System.out.println("중복되는 숫자는 포함할 수 없습니다.");
            return true;
        }
        return false;
    }

    public boolean isValidWinningNumbers(List<String> userInput) {
        List<Integer> winningNumbers;

        if (!isNumericIntList(userInput)) {
            System.out.println("입력이 올바르지 않습니다. 정수인지, 숫자가 너무 크지는 않은지 확인해주세요.");
            return false;
        }

        winningNumbers = userInput.stream().map(Integer::parseInt).collect(Collectors.toList());
        return isInBounds(winningNumbers) && isValidSize(winningNumbers)
                && !hasDuplicateNumbers(winningNumbers);
    }

    public boolean isValidBonus(String Bonus) {
        return true;
    }
}