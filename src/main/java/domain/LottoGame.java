package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static domain.InfoString.*;

public class LottoGame {

    private static int INPUT_MONEY;

    static List<Integer> lottoList = new ArrayList<>();
    static Lotto winLotto;
    static int bonus;

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
        WinningLotto CreateLottoObject = new WinningLotto(winLotto, bonus);

        for(int i = 0; i < checkMoney(); i++) {
            CreateLottoObject.match(CreateUserLotto.lottos[i]);
//            CreateUserLotto.lottos[i].getLotto();
        }

    }

    public static int checkMoney() {
        int count = INPUT_MONEY / 1000;

        if(count < MIN_COUNT) {
            System.out.println("구입금액은 1000원 이상이어야 합니다!!!.");
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

        winLotto = new Lotto(lottoList);
        return winLotto;
    }

    private static void setBonusNum() {
        Scanner scan = new Scanner(System.in);

        bonus = scan.nextInt();
    }
}
