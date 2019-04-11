package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 사용자 입력과 로또들의 유효성 검사 객체
 *
 * @version 1.1(2019.04.11)
 * @author jongyoon Kim
 */
public class Validator {
    public static final int AMOUNT_UNIT = 1000;
    public static final int LOTTO_MAXIMUM_NUMBER_VALUE = 45;
    public static final int LOTTO_MAXIMUM_NUMBER_COUNT = 6;
    /**유효성 검사를 위한 정규표현식*/
    private static final String NUMBER_PATTERN = "^[0-9]*$";
    private static final String DIGIT_PATTERN = "^\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2},\\d{1,2}$";
    /**에러 메시지들*/
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

    /**
     * 당첨 번호끼리의 중복 확인 및 최대값 넘김 확인
     *
     * @param numbers 중복을 확인할 숫자들
     * @return 중복이거나 최대값이 넘어가면 true, 아니면 false
     */
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

    /**
     * 보너스 번호와 당첨 번호들과의 중복 확인 및 최대값 넘김 확인
     *
     * @param  num 보너스 번호
     * @param  numbers 당첨 번호들
     * @return 중복이거나 최대값이 넘어가면 true, 아니면 false
     */
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

    /**
     * 유저가 뽑은 로또 번호에 당첨 번호가 하나 있는지 확인
     *
     * @param  num 당첨 번호 한개
     * @param  list 유저가 뽑은 로또 번호들
     * @return 존재하면 MatchingNumber 를 증가시키기 위해 1을 반환
     */
    public int isExistNumInList(Integer num, List<Integer> list){
        if(list.contains(num)){
            return 1;
        }
        return 0;
    }
}
