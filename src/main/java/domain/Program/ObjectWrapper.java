package domain.Program;

import domain.Elements.Lotto;
import domain.Elements.LottoPaper;

import java.util.List;

public class ObjectWrapper {
    public static Lotto[] createLottoBundle(int type, int amount){
        Lotto[] lottoBundle = new Lotto[amount];
        for(int i=0; i<amount; i++){
            lottoBundle[i] = new Lotto(new LottoPaper(type).getLottoNumber());
        }
        return lottoBundle;
    }
}
