package error.customExceptions;

/**
 * 최소 금액 미만의 금액이 입력되었을 경우
 */
public class MinimumPurchasePriceException extends IllegalArgumentException {
    public MinimumPurchasePriceException(int minPurchasePrice) {
        super(minPurchasePrice + "원 이상의 금액을 입력해 주세요.");
    }
}
