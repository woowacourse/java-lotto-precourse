package domain.util;
import com.sun.tools.internal.jxc.ap.Const;
import domain.util.Constant;

import domain.Game;

import java.util.InputMismatchException;
public class Input {


    public static int insertMoney(){
        int insertedMoney = 0;
        try {
            insertedMoney = PrintScan.requesetInputMoney();
            CheckException.checkInsertedMoneyIsValid(insertedMoney, Constant.MIN_INPUT_MONEY, Constant.MAX_INPUT_MONEY);
            return insertedMoney;
        } catch (InputMismatchException | IllegalArgumentException e) {
            PrintScan.printOutofRangeNotice();
            return insertMoney();
        }
    }
}
