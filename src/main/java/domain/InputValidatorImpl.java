package domain;

import domain.interfaces.InputValidator;

import java.util.Arrays;

public class InputValidatorImpl implements InputValidator {

    private final static int LOTTO_BOUND_SIZE = 46;
    private static boolean[] isPicked;
    private static boolean isValid;

    @Override
    public boolean isValidPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < MINIMUM_PURCHASE_AMOUNT) {
            System.out.println("올바른 금액을 입력해 주세요.");
            return false;
        }
        if (purchaseAmount % PRICE_PER_LOTTO != 0) {
            System.out.println("올바른 금액을 입력해 주세요.");
            return false;
        }
        return true;
    }



    @Override
    public boolean isValidWinningLotto(int lottoLength, String[] winningLotto) {
        isValid = true;
        isPicked = new boolean[LOTTO_BOUND_SIZE];
        checkInput(lottoLength);
        for (String s : winningLotto) {
            checkInput(lottoLength, s);
            isValidLottoNumber(Integer.parseInt(s));
        }
        if (!isValid){
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            return false;
        }
        return true;
    }

    public void checkInput(int lottoLength){
        if (lottoLength == 0) {
            isValid = false;
        }
    }

    public void checkInput(int lottoLength, String s) {
        if (lottoLength != LOTTO_LENGTH || s.equals(" ")) {
            isValid = false;
        }
    }

    @Override
    public void isValidLottoNumber(int num) {
        if (num >= MIN_LOTTO_NUMBER && num <= MAX_LOTTO_NUMBER && isPicked[num] == false) {
            isPicked[num] = true;
            return;
        }
        if (num < MIN_LOTTO_NUMBER || num > MAX_LOTTO_NUMBER) {
            isValid = false;
            return;
        }
        if (isPicked[num]) {
            isValid = false;
            return;
        }
    }

    @Override
    public boolean isValidBonusNumber(int bonusNo) {
        if (bonusNo < MIN_BONUS_NUMBER || bonusNo > MAX_BONUS_NUMBER) {
            return false;
        }
        if (isPicked[bonusNo]) {
            return false;
        }
        return true;
    }
}
