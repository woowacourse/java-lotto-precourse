package domain;

import domain.interfaces.InputValidator;

public class InputValidatorImpl implements InputValidator {

    private final static int LOTTO_BOUND_SIZE = 46;
    private static boolean[] isPicked;

    @Override
    public boolean isValidPurchaseAmount(int purchaseAmount) {
        /*if (purchaseAmount > MAX_AFFORDABLE_LOTTO_PURCHASE_AMOUNT) {
            return false;
        }*/
        if (purchaseAmount < MINIMUM_PURCHASE_AMOUNT) {
            return false;
        }
        if (purchaseAmount % PRICE_PER_LOTTO != 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isValidWinningLotto(int lottoLength, String[] winningLotto) {
        boolean flag = true;
        isPicked = new boolean[LOTTO_BOUND_SIZE];
        if (lottoLength > LOTTO_LENGTH) {
            return false;
        }
        for (String s : winningLotto){
            int num = Integer.parseInt(s);
            //공백입력은 인티저 변환시 int 값이 48인가? 쉼표는? 아스키코드 값으로 변환되는가?
            flag = isValidLottoNumber(num);
        }
        if (!flag) { return false; }
        return true;
    }

    @Override
    public boolean isValidLottoNumber(int num) {
        if (num > MIN_LOTTO_NUMBER && num < MAX_LOTTO_NUMBER && isPicked[num] == false) {
            isPicked[num] = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean isValidBonusNumber(int bonusNo) {
        if (bonusNo > MIN_BONUS_NUMBER && bonusNo < MAX_BONUS_NUMBER && isPicked[bonusNo] == false) {
            return true;
        }
        return false;
    }
}
