package domain.util;

import java.util.InputMismatchException;
public class Input {

    public static int insertMoney(){
        int insertedMoney = 0;
        try {
            insertedMoney = PrintScan.requesetInputMoney();
            CheckException.checkInsertedMoneyIsValid(insertedMoney,1000,2147483647);
            return insertedMoney;
        } catch (InputMismatchException | IllegalArgumentException e) {
            PrintScan.exeptionPrint();
            return insertMoney();
        }
    }
}
