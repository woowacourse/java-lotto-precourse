package domain;

import java.util.*;

public class WinningLotto_Input {

    private static String[] number_Input;
    static List<Integer> change_List = new ArrayList<>();
    static Lotto Winning_Number;
    static WinningLotto winningLotto;
    private static int bonus_Ball;

    static void last_Week_Winning_Number_Create() {
        System.out.println(Info.LAST_WEEK_WINNING_NUMBER_PRINT);
        number_Input = Info.SCAN.nextLine().split(",");
        for (String str : number_Input) {
            change_List.add(Integer.parseInt(str));
        }
    }

    static void last_Week_Winning_Lotto_Create() {
        Winning_Number = new Lotto(change_List);
    }

    static void bonus_Number_Create() {
        System.out.println(Info.BONUS_BALL_INPUT_PRINT);
        bonus_Ball = Info.SCAN.nextInt();
    }

    static void winningLotto_Object_Create() {
        winningLotto = new WinningLotto(Winning_Number, bonus_Ball);
    }

}
