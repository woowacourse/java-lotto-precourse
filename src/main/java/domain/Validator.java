package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 사용자 입력과 로또들의 유효성 검사 객체
 *
 * @version 1.0(2019.04.09)
 * @author jongyoon Kim
 */
public class Validator {
    public static final int AMOUNT_UNIT = 1000;
    public static final int LOTTO_MAXIMUM_NUMBER_VALUE = 45;
    public static final int LOTTO_MAXIMUM_NUMBER_COUNT = 6;
    private static final String NUMBER_PATTERN = "^[0-9]*$";
    private static final String DIGIT_PATTERN = "^\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}$";
    private static final String ERROR_MSG_AMOUNT_UNIT_MESSAGE = "1000원 단위로 적어주세요!";
    private static final String ERROR_MSG_NUMBER_MESSAGE = "숫자만 입력해주세요!";
    private static final String ERROR_MSG_NUMBER_DIGIT_MESSAGE = "입력 형식이 잘못되었습니다.";
    private static final String ERROR_MSG_DUPLICATE_NUMBER = "입력된 숫자들 중 중복이 있습니다.";
    private static final String ERROR_MSG_NUMBER_OVER_VALUE = "입력된 숫자들 중 " + LOTTO_MAXIMUM_NUMBER_VALUE
                                                            + "를 넘는 수가 있습니다.";
    private static final String ERROR_MSG_BONUS_DUPLICATE_NUMBERLIST = "보너스 숫자는 당첨 번호와 같을 수 없습니다.";
    private static final String ERROR_MSG_BONUS_OVER_VALUE = "보너스 숫자는 " + LOTTO_MAXIMUM_NUMBER_VALUE
                                                            + "를 넘을 수 없습니다.";

    public boolean isPossibleAmountUnit(String amount){
        return checkingMatching((Integer.parseInt(amount) % AMOUNT_UNIT) == 0, ERROR_MSG_AMOUNT_UNIT_MESSAGE);
    }

    public boolean isNumeric(String str){
        return checkingMatching(Pattern.matches(NUMBER_PATTERN,str),ERROR_MSG_NUMBER_MESSAGE);
    }

    public boolean isProperNumberDigit(String str){
        return checkingMatching(Pattern.matches(DIGIT_PATTERN,str),ERROR_MSG_NUMBER_DIGIT_MESSAGE);
    }

    private boolean checkingMatching(boolean checking, String message){
        if(!checking){
            System.out.println(message);
        }
        return checking;
    }

    public boolean isDuplicateAndNumOverValue(List<Integer> numbers){
        List<Integer> checkedNums = new ArrayList<>();
        for(Integer num : numbers){
            if(checkedNums.contains(num)){
                System.out.println(ERROR_MSG_DUPLICATE_NUMBER);
                return true;
            }
            checkedNums.add(num);
            if(num > LOTTO_MAXIMUM_NUMBER_VALUE){
                System.out.println(ERROR_MSG_NUMBER_OVER_VALUE);
                return true;
            }
        }
        return false;
    }

    public boolean isBonusDuplicateAndNumOverValue(int num, List<Integer> numbers){
        if(numbers.contains(num)){
            System.out.println(ERROR_MSG_BONUS_DUPLICATE_NUMBERLIST);
            return true;
        }
        if(num > LOTTO_MAXIMUM_NUMBER_VALUE){
            System.out.println(ERROR_MSG_BONUS_OVER_VALUE);
            return true;
        }
        return false;
    }

    public boolean isExistLottoInLottoList(ArrayList<Lotto> lottoList, Lotto lotto){
        return lottoList.contains(lotto);
    }
}
