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
    public boolean isNemericInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("입력이 올바르지 않습니다. 정수인지, 수가 너무 크지는 않은지 확인해주세요.");
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

        if (!isNemericInt(str)) {
            return false;
        }

        purchaseAmount = Integer.parseInt(str);
        return isPositiveInt(purchaseAmount) && isEnough(purchaseAmount)
                && isMultipleOfLottoPrice(purchaseAmount);
    }

    public boolean isInBounds(List<String> userInput) {
        List<Integer> outbounds = userInput.stream().map(Integer::parseInt)
                .filter(number -> (number > LottoManager.WINNING_NUMBER_BOUND)
                        || (number < LottoManager.WINNING_NUMBER_ORIGIN))
                .collect(Collectors.toList());

        if (outbounds.size() > 0) {
            System.out.println("1부터 45까지의 숫자들만 입력할 수 있습니다.");
            return false;
        }
        return true;
    }

    public boolean isValidSize(List<String> userInput) {
        if (userInput.size() != LottoManager.NUM_OF_WINNING_NUMBERS) {
            System.out.println(LottoManager.NUM_OF_WINNING_NUMBERS + "개의 숫자를 쉼표로 구분해 입력해주세요.");
            return false;
        }
        return true;
    }

    public boolean hasDuplicateNumbers(List<String> userInput) {
        Set<String> numerics = new HashSet<String>(userInput);

        if (numerics.size() != userInput.size()) {
            System.out.println("중복되는 숫자는 포함할 수 없습니다.");
            return true;
        }
        return false;
    }

    public boolean isValidWinningNumbers(List<String> userInput) {
        boolean validNumerics = true;

        for (String str: userInput) {
            validNumerics = validNumerics && isNemericInt(str);
        }

        return validNumerics && isInBounds(userInput) && isValidSize(userInput)
                && !hasDuplicateNumbers(userInput);
    }

    public boolean isValidBonus(String Bonus) {
        return true;
    }
}