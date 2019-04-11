package domain;


public class WinningResult {


    private static int[] result_Count = {Info.ZERO, Info.ZERO, Info.ZERO, Info.ZERO, Info.ZERO};
    private static Rank[] rank = Rank.values();
    static boolean bonus_check;
    private static int prize_money;
    private static float rate_of_earnings;

    private static void result_Stats() {
        for (int i = Info.ZERO; i < LottoBuy.lotto_money / Info.DIVISION; i++) {
            bonus_check = LottoBuy.lottos[i].getNumbers().contains(WinningLotto_Input.bonus_Ball);
            stats_Rounds(i);
        }
    }

    private static void stats_Rounds(int i) {
        for (int j = Info.FIFTH_START; j >= Info.ZERO; j--) {
            WinningLotto_Result(i, j);
        }
    }

    private static void WinningLotto_Result(int i, int j) {
        if (WinningLotto_Input.winningLotto.match(LottoBuy.lottos[i]).equals(rank[j])) {
            prize_money += WinningLotto_Input.winningLotto.match(LottoBuy.lottos[i]).getWinningMoney();
            result_Count[j] += Info.LOTTO_NUMBER_MIN_VALUE;
        }
    }

    private static void rank_Print(int i) {
        if (!(rank[i].getWinningMoney() == Rank.SECOND.getWinningMoney())) {
            System.out.println(rank[i].getCountOfMatch() + "개 일치 (" + rank[i].getWinningMoney() + "원)-" + result_Count[i] + "개");

        }
        if (rank[i].getWinningMoney() == Rank.SECOND.getWinningMoney()) {
            System.out.println(rank[i].getCountOfMatch() + "개 일치, 보너스 볼 일치(" + rank[i].getWinningMoney() + "원)-" + result_Count[i] + "개");
        }
    }

    private static void earnings_Rate_Print() {
        rate_of_earnings = (float) prize_money / LottoBuy.lotto_money;
        System.out.printf("총 수익률은 " + "%.3f" + "입니다", rate_of_earnings);
    }

    static void resultProcess() {
        result_Stats();
        System.out.println(Info.WINNINGRESULT_PRINT);
        System.out.println(Info.DASH);

        for (int i = Info.FIFTH_START; i >= Info.ZERO; i--) {
            rank_Print(i);
        }
        earnings_Rate_Print();
    }

}
