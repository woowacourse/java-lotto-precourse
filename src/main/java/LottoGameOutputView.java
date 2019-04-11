import domain.Lotto;

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
} 
