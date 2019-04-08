package domain.interfaces;

public interface InputValidator {

    int MAX_AFFORDABLE_LOTTO_PURCHASE_AMOUNT = 100000;
    int MINIMUM_PURCHASE_AMOUNT = 0;
    int MAX_LOTTO_LENGTH = 6;
    int PRICE_PER_LOTTO = 1000;
    int MAX_BONUS_NUMBER = 45;
    int MIN_BONUS_NUMBER = 1;

    boolean isValidPurchaseAmount(int purchaseAmount);
    boolean isValidLotto(int lottoLength, String winningLotto);
    boolean isValidBonusNumber(int bonusNo);
}
