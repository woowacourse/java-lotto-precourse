package domain.Program;

import domain.Elements.Lotto;
import domain.Elements.LottoPaper;
import domain.Program.Config.Constant;

public class LottoSimulator {
    public void play(){
        long pay = Input.setPrice();
        Lotto[] lottoBundle = ObjectWrapper.createLottoBundle(1,(int)(pay/ Constant.LOTTO_PRICE));
    }
}
