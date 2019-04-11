package domain.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.InputMismatchException;

public class Input {
    public static int insertMoney() {
        int insertedMoney = 0;
        try {
            insertedMoney = PrintScan.requesetInputMoney();
            CheckException.checkValueInRange(insertedMoney, Constant.MIN_INPUT_MONEY, Constant.MAX_INPUT_MONEY);
            return insertedMoney;
        } catch (InputMismatchException | IllegalArgumentException e) {
            PrintScan.printOutofRangeNotice(Constant.MIN_INPUT_MONEY, Constant.MAX_INPUT_MONEY);
            return insertMoney();
        }
    }

    public static List<Integer> inputWiningNum() {
        try {
            String winningLottoNumsString = PrintScan.requestWinningNum();
            List<Integer> winningLottoNum = winningNumsToInt(winningLottoNumsString);
            CheckException.checkWinNumberLength(winningLottoNum.size(), Constant.NUMBER_OF_LOTTO_NUMBERS);
            Collections.sort(winningLottoNum);
            return winningLottoNum;
        } catch (InputMismatchException | IllegalArgumentException e) {
            PrintScan.printInvalidNumber();
            return inputWiningNum();
        }
    }

    public static List<Integer> winningNumsToInt(String winningInputString) {
        String[] winningStringArray = winningInputString.split(",\\s*");
        List<Integer> winningNumsList = new ArrayList<>();
        for (String s : winningStringArray) {
            int winningNum=Integer.valueOf(s);
            CheckException.checkValueInRange(winningNum, Constant.MIN_LOTTO_NUM, Constant.MAX_LOTTO_NUM);
            GenarateNumber.addingNumberToList(winningNumsList,winningNum);
        };
        return winningNumsList;
    }

    public static int inputBonusNum(List<Integer> alreadyEnteredNumbers){
        try {
            int bonusNum = PrintScan.requestBonusNum();
            CheckException.checkValueInRange(bonusNum, Constant.MIN_LOTTO_NUM, Constant.MAX_LOTTO_NUM);
            CheckException.checkAleadyEnteredNumber(bonusNum, alreadyEnteredNumbers);
            return bonusNum;
        } catch (InputMismatchException | IllegalArgumentException e) {
            PrintScan.printOutofRangeNotice(Constant.MIN_LOTTO_NUM, Constant.MAX_LOTTO_NUM);
            return inputBonusNum(alreadyEnteredNumbers);
        }
    }

}
