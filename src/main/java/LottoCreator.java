import domain.Lotto;

import java.util.List;

public class LottoCreator {
    public static Lotto createLotto(){
        List<Integer> list = LottoNumberCreator.createLottoNums();
        Lotto lotto = new Lotto(list);
        return lotto;
    }
    public static Lotto createLotto(List<Integer> list){
        Lotto lotto = new Lotto(list);
        return lotto;
    }
}
