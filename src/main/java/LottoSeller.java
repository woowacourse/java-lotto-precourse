import domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    private static final int lottoPrice = 1000;

    public static int giveLottos(int money, List<Lotto> list){
        int numOfLotto = Integer.valueOf(money)/lottoPrice;
        System.out.println("\n"+numOfLotto+"개를 구매했습니다.");
        for(int i=0; i<numOfLotto; i++) {
            Lotto lotto = LottoCreator.createLotto();
            list.add(lotto);
            System.out.println(lotto);
        }
        return numOfLotto * lottoPrice;
    }
}
