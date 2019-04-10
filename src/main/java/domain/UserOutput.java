package domain;

import java.util.List;
import java.util.stream.Stream;

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
        String purchaseResult; // 하나의 구매된 로또의 번호들

        List<Integer> lottoNumbers = this.lottoList.get(lottoOrder).getNumbers();

        purchaseResult = String.join(",", lottoNumbers.toString());

        System.out.println(purchaseResult);

    }

    public void PrintWinStatistics(List<Rank> userRanks, int purchaseAmount) {
        Stream<Rank> rankStream = Stream.of(Rank.values());

        System.out.println("당첨통계");
        System.out.println("---------");
        rankStream.filter(rs -> rs.getCountOfMatch() != 0).forEach(rs -> PrintWinResult(rs, userRanks));

        PrintEarningRate(userRanks,purchaseAmount);
    }

    private void PrintWinResult(Rank rank, List<Rank> userRanks) {
        int matchCountperRank = (int) userRanks.stream().filter(r -> r == rank).count();

        if (rank == Rank.SECOND) {
            System.out.println(rank.getCountOfMatch() + "개 일치, 보너스 볼 일치 (" + rank.getWinningMoney() + "원)-"
                    + matchCountperRank + "개");
            return;
        }

        System.out.println(rank.getCountOfMatch() + "개 일치, (" + rank.getWinningMoney() + "원)-"
                + matchCountperRank + "개");

    }


    private void PrintEarningRate(List<Rank> userRanks, int purchaseAmount) {
        int sumOfPrize = userRanks.stream()
                .filter(ur -> ur.getWinningMoney() > 0)
                .mapToInt(ur -> ur.getWinningMoney())
                .sum();

        double earningRate = sumOfPrize / purchaseAmount;

        System.out.printf("수익률은 "+earningRate+"입니다.");
    }
}
