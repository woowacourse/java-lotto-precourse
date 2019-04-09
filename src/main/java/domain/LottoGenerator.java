package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private static List<Lotto> lottoList;

    LottoGenerator() {
        lottoList = new ArrayList<>();
    }

    public void GenerateAutoLottos(int lottoCount) {

        for (int i = 0; i < lottoCount; i++) {
            GenerateAutoLotto();
        }
    }

    private void GenerateAutoLotto() {
        AutoLotto autoLotto = new AutoLotto();

        lottoList.add(new Lotto(autoLotto.GenerateAuttoLotto()));
    }


    public static List<Lotto> getLottoList() {
        return lottoList;
    }

}
