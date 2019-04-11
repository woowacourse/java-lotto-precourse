import domain.Lotto;
import domain.Rank;

import java.util.List;

public class LottoGameOutputView {
    public void printBuyingLottosCount(LottoGenerator lottoGenerator) {
        System.out.println("\n"+lottoGenerator.getBuyingLottosCount()+"개를 구매했습니다.");
    }

    public void printGeneratedLottos(LottoGenerator lottoGenerator) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Lotto> generateLottos = lottoGenerator.getGenerateLottos();

        for(Lotto lotto : generateLottos) {
            String result = String.join(",", lotto.getNumbers().toString());
            stringBuilder.append(result);
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    public void printResult(LottoResult lottoResult) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n당첨 통계\n");
        stringBuilder.append("------------------\n");
        stringBuilder.append(String.format("%d개 일치 (%d원) - %d개\n", Rank.FIFTH.getCountOfMatch(), Rank.FIFTH.getWinningMoney(), lottoResult.getMatchCount(Rank.FIFTH)));
        stringBuilder.append(String.format("%d개 일치 (%d원) - %d개\n", Rank.FOURTH.getCountOfMatch(), Rank.FOURTH.getWinningMoney(), lottoResult.getMatchCount(Rank.FOURTH)));
        stringBuilder.append(String.format("%d개 일치 (%d원) - %d개\n", Rank.THIRD.getCountOfMatch(), Rank.THIRD.getWinningMoney(), lottoResult.getMatchCount(Rank.THIRD)));
        stringBuilder.append(String.format("%d개 일치, 보너스 볼 일치 (%d원) - %d개\n", Rank.SECOND.getCountOfMatch(), Rank.SECOND.getWinningMoney(), lottoResult.getMatchCount(Rank.SECOND)));
        stringBuilder.append(String.format("%d개 일치 (%d원) - %d개\n", Rank.FIRST.getCountOfMatch(), Rank.FIRST.getWinningMoney(), lottoResult.getMatchCount(Rank.FIRST)));
        stringBuilder.append(String.format("총 수익률은 %.3f입니다.", lottoResult.getRateOfProfit()));
        System.out.println(stringBuilder);
    }
} 
