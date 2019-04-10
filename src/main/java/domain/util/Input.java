package domain.util;

import java.util.InputMismatchException;
public class Input {
    public static final int MIN_INPUT_MONEY = 1_000;
    public static final int MAX_INPUT_MONEY = 2_147_483_647;

    public static int insertMoney(){
        int insertedMoney = 0;
        try {
            insertedMoney = PrintScan.requesetInputMoney();
            CheckException.checkInsertedMoneyIsValid(insertedMoney, MIN_INPUT_MONEY, MAX_INPUT_MONEY);
            return insertedMoney;
        } catch (InputMismatchException | IllegalArgumentException e) {
            PrintScan.printOutofRangeNotice();
            return insertMoney();
        }
    }
}
