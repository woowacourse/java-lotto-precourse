package domain;

import java.util.*;
import java.util.regex.Pattern;

public class WinningLotto_Input {

    private static String[] number_Input;
    private static List<Integer> change_List = new ArrayList<>();
    private static Set<Integer> overlap_Number_CheckSet = new TreeSet<>();
    static WinningLotto winningLotto;
    private static int bonus_Ball;

    static void last_Week_Winning_Number_Create() {
        System.out.println(Info.LAST_WEEK_WINNING_NUMBER_PRINT);
        number_Input = Info.SCAN.nextLine().split(",");
        last_Week_Winning_NumberLength_Check();
        last_Week_Winning_Number_Check();
    }

    static void last_Week_Winning_Number_Check() {
        for (int i = Info.ZERO; i < number_Input.length; i++) {
            last_Week_Winning_NumberType_Check(i);
            last_Week_Winning_NumberRange_Check(i);
            overlap_Number_CheckSet.add(Integer.parseInt(number_Input[i]));
        }
        last_Week_Winning_Number_Overlap_Check();
    }

    static void bonus_Number_Create() {
        System.out.println(Info.BONUS_BALL_INPUT_PRINT);
        bonus_Ball = Info.SCAN.nextInt();
    }

    static void winningLotto_Object_Create() {
        change_List.addAll(overlap_Number_CheckSet);
        winningLotto = new WinningLotto(new Lotto(change_List), bonus_Ball);
    }

    private static void last_Week_Winning_NumberRange_Check(int i) {
        if ((Integer.parseInt(number_Input[i]) > Info.LOTTO_NUMBER_MAX_VALUE) ||
                (Integer.parseInt(number_Input[i]) < Info.LOTTO_NUMBER_MIN_VALUE)) {
            System.out.println(Info.WINNING_LOTTO_RANGE_ERROR_PRINT);
            RandomNumberCreate.set_Number_Delete(overlap_Number_CheckSet);
            last_Week_Winning_Number_Create();
        }
    }

    private static void last_Week_Winning_NumberType_Check(int i) {
        if (!(Pattern.matches(Info.NUMBER_PATTERN, number_Input[i]))) {
            System.out.println(Info.WINNING_LOTTO_TYPE_ERROR_PRINT);
            RandomNumberCreate.set_Number_Delete(overlap_Number_CheckSet);
            last_Week_Winning_Number_Create();
        }
    }

    private static void last_Week_Winning_NumberLength_Check() {
        if (number_Input.length != Info.LOTTO_NUMBER_MAX_LENGTH) {
            System.out.println(Info.WINNING_LOTTO_LENGTH_ERROR_PRINT);
            last_Week_Winning_Number_Create();
        }
    }

    private static void last_Week_Winning_Number_Overlap_Check() {
        if (overlap_Number_CheckSet.size() != Info.LOTTO_NUMBER_MAX_LENGTH) {
            System.out.println(Info.WINNING_LOTTO_OVERLAP_ERROR_PRINT);
            RandomNumberCreate.set_Number_Delete(overlap_Number_CheckSet);
            last_Week_Winning_Number_Create();
        }
    }


}
