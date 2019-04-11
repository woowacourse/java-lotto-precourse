package lotto.domain;

public class LottoMoney {
    private final static long PRICE_PER_LOTTO = 1000;

    private long purchaseAmount;

    public LottoMoney(long purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validate(long purchaseAmount) {
        if (purchaseAmount %  PRICE_PER_LOTTO != 0)
            throw new IllegalArgumentException("금액이 잘못되었습니다. " + PRICE_PER_LOTTO + " 단위만 가능합니다.");
    }

    public static long getPricePerLotto() {
        return PRICE_PER_LOTTO;
    }
}
