package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class LottoGameManager {
    private InputLottoInformation inputlottoinformation;
    private List<Lotto> lotto;
    private WinningLotto winninglotto;
    private HashMap<Rank, Integer> lottoStatisticsMap;
    private double totalEarningRate;

    private void init() {
        inputlottoinformation = new InputLottoInformation();
        lotto = new ArrayList<>();
        lottoStatisticsMap = new HashMap<>();
        for (Rank rank : Rank.values()) {
            lottoStatisticsMap.put(rank, 0);
        }
        totalEarningRate = 0;
    }

    public void lottoPurchase() {
        init();
        int money = inputlottoinformation.getLottoPurchasePrice();
        lotto = inputlottoinformation.getGeneratedLottoNumber(money);
        System.out.println(lotto.size() + Message.lottoOutputMessage.get("OUTPUT_BUYLOTTO"));
        outputLottoNumber();
        confirmWinOfLotto();
        earningRate(money);
    }

    private void outputLottoNumber() {
        for (Lotto li : lotto) {
            System.out.println(li.getNumbers());
        }
    }

    private void confirmWinOfLotto() {
        List<Integer> lastweeklottonumber = inputlottoinformation.getLottoNumberOfLastWeek();
        Lotto lastweekNo = new Lotto(lastweeklottonumber);
        int bonusNo = inputlottoinformation.getBonusBallOfLastWeek();
        winninglotto = new WinningLotto(lastweekNo, bonusNo); //
        setWinStatisticsOfLotto();
        setOutputWinStatisticsOfLotto();
    }

    /*
     * Lotto match에 대한 count 증가
     */
    private void setWinStatisticsOfLotto() {
        for (Lotto lot : lotto) {
            Rank rank = winninglotto.match(lot);
            lottoStatisticsMap.put(rank, lottoStatisticsMap.get(rank) + 1);
            totalEarningRate += (int) winninglotto.match(lot).getWinningMoney();
        }
    }

    private void setOutputWinStatisticsOfLotto() {
        System.out.println(Message.lottoOutputMessage.get("OUTPUT_STATISTICS"));
        System.out.println(Message.lottoOutputMessage.get("OUTPUT_STATISTICSLINE"));
        Stack<Rank> reverse = new Stack<>(); // reverse for output
        for (Rank rank : Rank.values()) {
            reverse.push(rank);
        }
        int size = reverse.size();
        for (int i = 0; i < size; i++) {
            outputWinStatistics(reverse.pop());
        }
    }

    private void outputWinStatistics(Rank rank) {
        if (rank == Rank.MISS) {
            return;
        }
        System.out.print(rank.getCountOfMatch() + "개 일치");
        if (rank == Rank.SECOND) {
            System.out.print(" 보너스 볼 일치");
        }
        System.out.print("(");
        System.out.println(rank.getWinningMoney() + "원)- " + lottoStatisticsMap.get(rank) + "개");
    }

    private void earningRate(int money) {
        System.out.println("총 수익률은 " + (float) totalEarningRate / (float) money + "입니다.");
    }
}
