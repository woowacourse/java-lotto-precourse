package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static domain.Validator.AMOUNT_UNIT;

final
/**
 * 사용자 입력을 받는 입력기
 *
 * @version 1.0(2019.04.09)
 * @author jongyoon Kim
 */
public class Inputter {
    private static final String MSG_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String MSG_INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.(6자리)"
                                                                + "\n입력 예시 : 5,10,14,32,40,45";
    private static final String MSG_INPUT_BONUS_BALL = "보너스 볼을 입력해 주세요.";
    private static Scanner scan = new Scanner(System.in);
    private static Validator validator = new Validator();

    public int inputPurchaseAmount(){
        String amount;
        do{
            System.out.println(MSG_INPUT_PURCHASE_AMOUNT);
            amount = scan.nextLine();
        }while (!validator.isNumeric(amount) && !validator.isPossibleAmountUnit(amount));
        return Integer.parseInt(amount) / AMOUNT_UNIT;
    }

    public String inputWinningNumber(){
        String winningNum;
        do{
            System.out.println(MSG_INPUT_WINNING_NUMBERS);
            winningNum = scan.nextLine();
        }while (!validator.isProperNumberDigit(winningNum));
        return winningNum;
    }

    public List<Integer> winningNumberSplit(String winningNum){
        List<Integer> splittedWinningNum;
        boolean isDuplicateAndOverNum;
        do{
            splittedWinningNum = changeStrListToIntList(Arrays.asList(winningNum.split(",")));
            isDuplicateAndOverNum = validator.isDuplicateAndNumOverValue(splittedWinningNum);
            winningNum = reInputWinningNumbers(isDuplicateAndOverNum, winningNum);
        }while (isDuplicateAndOverNum);

        return splittedWinningNum;
    }

    private List<Integer> changeStrListToIntList(List<String> strList){
        List<Integer> intList = new ArrayList<>();
        for(String str : strList){
            intList.add(Integer.parseInt(str));
        }
        return intList;
    }

    private String reInputWinningNumbers(boolean isRestart, String origin){
        if(isRestart){
            return inputWinningNumber();
        }
        return origin;
    }

    public int inputBonusNumber(List<Integer> splittedWinningNum){
        int bonusNum;
        do {
            System.out.println(MSG_INPUT_BONUS_BALL);
            bonusNum = scan.nextInt();
        }while(validator.isDuplicateAndNumOverValue(bonusNum, splittedWinningNum));
        return bonusNum;
    }
}
