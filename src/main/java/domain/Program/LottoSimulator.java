package domain.Program;

import domain.Elements.Lotto;
import domain.Elements.LottoPaper;
import domain.Program.Config.Constant;

import java.util.Scanner;

public class LottoSimulator {
    public void play(){
        long pay = Input.setPrice();
        int type = selectType();
        Lotto[] lottoBundle = buyLottoBundle(pay,type);
    }
    private Lotto[] buyLottoBundle(long pay, int type){
        int amount = (int)(pay/ Constant.LOTTO_PRICE);
        return ObjectWrapper.createLottoBundle(type,amount);
    }
    private int selectType(){
        System.out.println("타입을 선택해주세요.\n 1:자동 2:수동");
        return new Scanner(System.in).nextInt();
    }
}
