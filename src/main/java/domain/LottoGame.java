package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static domain.InfoString.*;

/**
 * 우아한 테크코스 3주차 MISSION
 * LOTTO 구현하기.
 * 2019.04.09
 * 최유성
 */
public class LottoGame {
    private static int INPUT_MONEY;
    private static List<Integer> lottoList = new ArrayList<>();
    private static Lotto winLotto;
    private static int bonus;
    private static List<Integer> rankArr = new ArrayList<>();
    private static int five = 0;
    private static int four = 0;
    private static int three = 0;
    private static int two = 0;
    private static int one = 0;
    private static double totalMoney = 0;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println(INFO_BUY_MONEY);
        INPUT_MONEY = scan.nextInt();
        System.out.println(checkMoney() + INFO_BUY_COUNT);
        CreateUserLotto.createLotto(checkMoney());
        System.out.println(INFO_WIN_NUM);
        winLotto = setWinNumber();
        System.out.println(INFO_BONUS_NUM);
        setBonusNum();
        matchRank();
        printOutPut(INPUT_MONEY);
    }

    public static int checkMoney() {
        int count = INPUT_MONEY / MIN_MONEY;

        if(count < MIN_COUNT) {
            System.out.println(INFO_MIN_BUY);
            System.exit(1);
        }

        return count;
    }

    private static Lotto setWinNumber() {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String[] str = line.split(",");

        for(int i=0; i< str.length;i++) {
            lottoList.add(Integer.parseInt(str[i]));
        }
        checkWinNumber(lottoList);

        winLotto = new Lotto(lottoList);
        return winLotto;
    }

    private static void checkWinNumber(List<Integer> lotto) {
        boolean check = true;

        if(lottoList.size() > NUM_OF_LOTTO) {
            System.out.println(ERROR_LOTTO);
            System.exit(1);
        }
        for(int i = 0 ; i<lottoList.size() ; i++){
            check = ((lotto.get(i) > MAX_OF_NUM) || (lotto.get(i) < MIN_COUNT)) ? false : true;
        }

        if(check == false) {
            System.out.println(ERROR_NUMBER);
            System.exit(1);
        }

    }

    private static void setBonusNum() {
        Scanner scan = new Scanner(System.in);
        bonus = scan.nextInt();
    }

    public static void matchRank() {
        WinningLotto CreateLottoObject = new WinningLotto(winLotto, bonus);
        Rank rank = null;

        for(int i = 0; i < checkMoney(); i++) {
            rank = CreateLottoObject.match(CreateUserLotto.lottos[i]);
            five = (rank == Rank.FIFTH) ? five+1 : five;
            four = (rank == Rank.FOURTH) ? four+1 : four;
            three = (rank == Rank.THIRD) ? three+1 : three;
            two = (rank == Rank.SECOND) ? two+1 : two;
            one = (rank == Rank.FIRST) ? one+1 : one;
            totalMoney += rank.getWinningMoney();
        }
    }

    public static void printOutPut(int INPUT_MONEY) {
        System.out.println(INFO_RESULT_LOTTO);
        System.out.println(INFO_UNDER_LINE);
        System.out.println(INFO_FIVE_RANK + five +INFO_NUM);
        System.out.println(INFO_FOUR_RANK + four+INFO_NUM);
        System.out.println(INFO_THREE_RANK + three+INFO_NUM);
        System.out.println(INFO_TWO_RANK + two+INFO_NUM);
        System.out.println(INFO_ONE_RANK + one+INFO_NUM);
        System.out.println(INFO_LOSS_RATE + (totalMoney / INPUT_MONEY) + INFO_IT_IS);
    }
}
