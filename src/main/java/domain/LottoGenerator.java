package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static final int PRIZE_OF_LOTTO = 1000;
    private List<Lotto> lottoList;

    LottoGenerator() {
        lottoList = new ArrayList<>();
    }

    private void GenerateLottos(int purchaseAmount) {
        int lottoCount = purchaseAmount / PRIZE_OF_LOTTO;
        for (int i = 0; i < lottoCount; i++) {
            GenerateLotto();
        }
    }

    private void GenerateLotto(){
        
    }


}
