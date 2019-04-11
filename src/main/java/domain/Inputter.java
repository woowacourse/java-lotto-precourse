package domain;

import java.util.List;
import java.util.Scanner;

import static domain.Validator.AMOUNT_UNIT;

/**
 * 사용자 입력을 받는 객체
 *
 * @version 1.1(2019.04.11)
 * @author jongyoon Kim
 */
public class Inputter {
    /**입력 메세지*/
    private static final String MSG_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String MSG_INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.(6자리)"
                                                                + "\n입력 예시 : 5,10,14,32,40,45";
    private static final String MSG_INPUT_BONUS_BALL = "보너스 볼을 입력해 주세요.";
    private static final String MSG_PURCHASE_AMOUNT = "개를 구매했습니다.";

    private static Scanner scan = new Scanner(System.in);
    private static Validator validator = new Validator();

    public int inputPurchaseAmount(){
        String amount;
        do{
            System.out.println(MSG_INPUT_PURCHASE_AMOUNT);
            amount = scan.nextLine();
        }while (!validator.isNumeric(amount) || !validator.isPossibleAmountUnit(amount));
        int changeToIntAmount = Integer.parseInt(amount) / AMOUNT_UNIT;
        System.out.println(changeToIntAmount + MSG_PURCHASE_AMOUNT);
        return changeToIntAmount;
    }

    public String inputWinningNumber(){
        String winningNum;
        do{
            System.out.println(MSG_INPUT_WINNING_NUMBERS);
            winningNum = scan.nextLine();
        }while (!validator.isProperNumberDigit(winningNum));
        return winningNum;
    }

    public int inputBonusNumber(List<Integer> splittedWinningNum){
        String bonusNum;
        do {
            System.out.println(MSG_INPUT_BONUS_BALL);
            bonusNum = scan.nextLine();
        }while( ! validator.isNumeric(bonusNum)
                || validator.isBonusDuplicateAndNumOverValue(Integer.parseInt(bonusNum),
                                                                splittedWinningNum));
        return Integer.parseInt(bonusNum);
    }

}
