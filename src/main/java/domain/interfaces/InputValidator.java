package domain.interfaces;

import java.util.InputMismatchException;

public interface InputValidator {

    int MINIMUM_PURCHASE_AMOUNT = 0;
    int LOTTO_LENGTH = 6;
    int PRICE_PER_LOTTO = 1000;
    int MAX_BONUS_NUMBER = 45;
    int MIN_BONUS_NUMBER = 1;
    int MIN_LOTTO_NUMBER = 1;
    int MAX_LOTTO_NUMBER = 45;

    boolean isValidPurchaseAmount(long purchaseAmount) throws InputMismatchException;

    boolean isValidWinningLotto(int lottoLength, String[] winningLotto) throws IllegalArgumentException;

    void isValidLottoNumber(int num) throws InputMismatchException;

    boolean isValidBonusNumber(int bonusNo) throws InputMismatchException;
}
