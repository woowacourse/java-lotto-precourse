package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Display {

    private static final int limitOfLotto = 6;
    private static Scanner sc = new Scanner(System.in);
    private static List<Integer> winningLotto = new ArrayList<Integer>();

    private Display() {
    }

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = sc.nextInt();
        return money;
    }

    public static void showBoughtLotto(List<Lotto> userLottoTickets) {
        System.out.println(userLottoTickets.size() + "개를 구매했습니다.");
        for (int i = 0; i < userLottoTickets.size(); i++) {
            System.out.println(userLottoTickets.get(i));
        }
    }

    public static List<Integer> inputLastWeekWinningNumbers() {
        System.out.println("지난주 당첨번호를 입력해 주세요.");
        String tmp = sc.next();
        String[] s = tmp.split(",");
        for(String s1: s) {
            winningLotto.add(Integer.parseInt(s1));
        }
        return winningLotto;
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNo = sc.nextInt();
        return bonusNo;
    }

    public static void showStatistics(int[] countRank, Rank[] ranks) {
        System.out.println("당첨통계");
        System.out.println("-------");
        for (int i = ranks.length - 2; i >= 0; i--) {
            System.out.println(ranks[i].getCountOfMatch() + "개 일치 (" + ranks[i].getWinningMoney() + "원)- " + countRank[i] + "개");
        }
    }

    public static void showProfitRate(int[] countRank, int money) {
        double profitRate = Profit.calculateProfitRate(countRank, money);
        System.out.println("총 수익륭은 " + profitRate + "입니다.");
    }
}
