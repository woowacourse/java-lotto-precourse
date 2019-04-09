package domain;

import java.util.LinkedList;
import java.util.List;

public class LottoGame {

    static List<Lotto> lottoList;
    static WinningLotto winningLotto;

    private void createLottos(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
        List<Lotto> createdLottoList = new LinkedList<Lotto>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto createdLotto = Lotto.createRandomLotto();
            createdLottoList.add(createdLotto);
        }
        lottoList = createdLottoList;
    }
}
