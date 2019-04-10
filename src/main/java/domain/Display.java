package domain;

import java.util.List;
import java.util.Scanner;

public class Display {

    private static Scanner sc = new Scanner(System.in);
    private static List<Integer> winningLotto;

    private static boolean continueFlagLottoNumber = true;
    private static boolean continueFlagMoney = true;
    private static boolean continueFlagBonusNum = true;

    private static int money = 0;
    private static int bonusNo = 0;

    private Display() {
    }

    public static int inputMoney() {
        while (continueFlagMoney) {
            System.out.println("구입금액을 입력해 주세요.");
            continueFlagMoney = processMoney();
        }
        return money;
    }

    public static boolean processMoney() {
        try {
            money = sc.nextInt();
            return false;
        } catch (Exception e) {
            sc.nextLine();
            System.out.println("다시 입력해주세요 예) 8000");
            return true;
        }
    }

    public static void showBoughtLotto(List<Lotto> userLottoTickets) {
        System.out.println(userLottoTickets.size() + "개를 구매했습니다.");
        for (int i = 0; i < userLottoTickets.size(); i++) {
            System.out.println(userLottoTickets.get(i));
        }
    }

    public static List<Integer> inputLastWeekWinningNumbers() {
        while (continueFlagLottoNumber) {
            System.out.println("지난주 당첨번호를 입력해 주세요.");
            String tmp = sc.next();
            continueFlagLottoNumber = processString(tmp);
        }

        return winningLotto;
    }

    public static boolean processString(String tmp) {
        try {
            winningLotto = Check.splitUserInput(tmp);
            return false;
        } catch (Exception e) {

            System.out.println("다시 입력해주세요 예) 1,2,3,4,5,6");
            return true;
        }
    }

    public static int inputBonusNumber() {
        while (continueFlagBonusNum) {
            System.out.println("보너스 볼을 입력해 주세요.");
            continueFlagBonusNum = processBonuseNo();
        }
        return bonusNo;
    }

    public static boolean processBonuseNo() {
        try {
            bonusNo = sc.nextInt();
            Check.isBonusNoValid(bonusNo);
            return false;
        } catch (Exception e) {
            sc.nextLine();
            System.out.println("중복되지 않게 다시 입력해주세요 예) 8");
            return true;
        }
    }

    public static void showStatistics() {
        System.out.println("당첨통계");
        System.out.println("-------");
        Profit.showStatistics();
    }

    public static void showProfitRate(int money) {
        Profit.showProfitRate(money);
    }
}
