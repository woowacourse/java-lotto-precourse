package domain;

import java.util.List;
import java.util.stream.Stream;

import static domain.Constant.*;

public class UserOutput {

    private List<Lotto> lottoList;

    public void PrintPurchaseResults() {

        lottoList = LottoGenerator.getLottoList();
        PrintPurchaseCount();

        for (int lottoOrder = 0; lottoOrder < lottoList.size(); lottoOrder++) {
            PrintLottoNumbers(lottoOrder);
        }
    }

    private void PrintPurchaseCount() {
        int lottoCount = this.lottoList.size();
        System.out.println(lottoCount + "개를 구입하였습니다.");
    }

    private void PrintLottoNumbers(int lottoOrder) {
        String JoinedLottoNumber = this.lottoList.get(lottoOrder).JoinLottoNumbers();

        System.out.println(JoinedLottoNumber);

    }

    public void PrintWinStatistics(List<Rank> userRanks, int purchaseAmount) {
        Stream<Rank> rankStream = Stream.of(Rank.values());

        System.out.println("당첨 통계");
        System.out.println("---------");
        rankStream.filter(rs -> rs.getCountOfMatch() != ZERO) // Rank에서 CountOfMatch가 0이 아닌것에 대해서만 PrintWinResult 호출
                .forEach(rs -> PrintWinResult(rs, userRanks));

        PrintEarningRate(userRanks, purchaseAmount);
    }

    private void PrintWinResult(Rank rank, List<Rank> userRanks) {
        int matchCountPerRank = Calculator.CalculateMatchCountPerRank(rank, userRanks);

        if (rank == Rank.SECOND) {
            System.out.println(rank.getCountOfMatch() + "개 일치, 보너스 볼 일치 (" + rank.getWinningMoney() + "원)-"
                    + matchCountPerRank + "개");
            return;
        }

        System.out.println(rank.getCountOfMatch() + "개 일치, (" + rank.getWinningMoney() + "원)-"
                + matchCountPerRank + "개");
    }


    private void PrintEarningRate(List<Rank> userRanks, int purchaseAmount) {
        double earningRate = Calculator.CalculateEarningRate(userRanks, purchaseAmount);

        System.out.printf("수익률은 " + earningRate + "입니다.");
    }
}
