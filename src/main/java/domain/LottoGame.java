package domain;

import java.util.Scanner;

public class LottoGame {
    private static final String INFO_BUY_MONEY = "구입금액을 입력해 주세요.";
    private static final String INFO_WIN_NUM = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INFO_BONUS_NUM = "보너스 볼을 입력해 주세요.";
    private static final String INFO_RESULT_LOTTO = "당첨 통계";
    private static final int MIN_COUNT = 1;
    private static int INPUT_MONEY;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println(INFO_BUY_MONEY);
        INPUT_MONEY = scan.nextInt();
        CreateUserLotto.createLotto(checkMoney());
    }

    private static int checkMoney() {
        int count = INPUT_MONEY / 1000;

        if(count < MIN_COUNT) {
            System.out.println("구입금액은 1000원 이상이어야 합니다!!!.");
        }

        return count;
    }
}
