package domain.validator;

public class PurchaseAmountValidator implements Validator {

    int purchaseAmount;

    public PurchaseAmountValidator(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    @Override
    public boolean doesValid() {
        return doesChangeNotExist();
    }

    boolean doesChangeNotExist() {
        // TODO 로또 행사를 진행할 클래스에서 로또 가격 받아오기
        return  (purchaseAmount % 1000) == 0;
    }
}
