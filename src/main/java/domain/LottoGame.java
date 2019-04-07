package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static domain.CreateUserLotto.NUM_OF_LOTTO;

public class LottoGame {
    private static final String INFO_BUY_MONEY = "구입금액을 입력해 주세요.";
    private static final String INFO_BUY_COUNT = "개를 구입했습니다.";
    private static final String INFO_WIN_NUM = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INFO_BONUS_NUM = "보너스 볼을 입력해 주세요.";
    private static final String INFO_RESULT_LOTTO = "당첨 통계";
    private static final int MIN_COUNT = 1;
    private static int INPUT_MONEY;

    static List<Integer> win_lotto = new ArrayList<>();
    static int bonus;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println(INFO_BUY_MONEY);
        INPUT_MONEY = scan.nextInt();
        System.out.println(checkMoney() + INFO_BUY_COUNT);
        CreateUserLotto.createLotto(checkMoney());
        System.out.println(INFO_WIN_NUM);
        setWinNumber();
        System.out.println(INFO_BONUS_NUM);
        setBonusNum();
    }

    private static int checkMoney() {
        int count = INPUT_MONEY / 1000;

        if(count < MIN_COUNT) {
            System.out.println("구입금액은 1000원 이상이어야 합니다!!!.");
        }

        return count;
    }

    private static void setWinNumber() {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String[] str = line.split(",");

        for(int i=0; i< str.length;i++) {
            win_lotto.add(Integer.parseInt(str[i]));
        }
    }

    private static void setBonusNum() {
        Scanner scan = new Scanner(System.in);

        bonus = scan.nextInt();
    }
}
