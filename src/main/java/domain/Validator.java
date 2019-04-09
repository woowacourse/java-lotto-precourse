package domain;

import java.util.List;

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
            System.out.println("정수를 입력해주세요");
            System.out.println("(혹은 너무 큰 금액일 수도 있습니다. 적당한 숫자를 입력해주세요.)");
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

    public boolean isValidWinningNumbers(List<Integer> winningNumbers) {
        return true;
    }

    public boolean isValidBonus(String Bonus) {
        return true;
    }
}