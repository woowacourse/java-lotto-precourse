package domain.Program;

import domain.Elements.Lotto;
import domain.Elements.LottoPaper;
import domain.Elements.WinningLotto;
import domain.Program.Config.Constant;

import java.util.List;
import java.util.Scanner;

public class LottoSimulator {
    public void play(){
        long pay = Input.setPrice();                                                                                                                //1
        int type = selectType();                                                                                                                    //2
        Lotto[] lottoBundle = buyLottoBundle(pay,type);                                                                                             //3
        Print.getLottoBundle(lottoBundle);                                                                                                          //4
        Print.getWinningLottoSetter();                                                                                                              //5
        Lotto winningLottoPaper = new Lotto(new LottoPaper(2).getLottoNumber());                                                              //6
        WinningLotto winningLotto = new WinningLotto(winningLottoPaper,Input.setBonusNumber(winningLottoPaper.getLottoNumber()));                   //7
    }
    private Lotto[] buyLottoBundle(long pay, int type){
        int amount = (int)(pay/ Constant.LOTTO_PRICE);
        return ObjectWrapper.createLottoBundle(type,amount);
    }
    private int selectType(){
        Print.getType();
        return new Scanner(System.in).nextInt();
    }
}
