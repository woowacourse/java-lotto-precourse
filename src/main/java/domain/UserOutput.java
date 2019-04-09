package domain;

import java.util.List;

public class UserOutput {

    private List<Lotto> lottoList;

    public void PrintPurchaseResults() {

        lottoList = LottoGenerator.getLottoList();
        PrintPurchaseCounts();

        for (int lottoOrder = 0; lottoOrder < lottoList.size(); lottoOrder++) {
            PrintLottoNumbers(lottoOrder);
        }
    }

    private void PrintPurchaseCounts() {
        int lottoCount = this.lottoList.size();
        System.out.println(lottoCount + "개를 구입하였습니다.");
    }

    private void PrintLottoNumbers(int lottoOrder){
        String purchaseResult; // 하나의 구매된 로또의 번호들

        List<Integer> lottoNumbers = this.lottoList.get(lottoOrder).getNumbers();

        purchaseResult = String.join("," ,lottoNumbers.toString() );

        System.out.println(purchaseResult);

    }

    public void PrintWinStatistics(){
        System.out.println("당첨통계");
        System.out.println("---------");

    }

    private void PrintEarningRate(){
        System.out.println("이후 구현 예정");
    }
}
