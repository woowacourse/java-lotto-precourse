package domain;

import java.util.Scanner;

/**
 *  로또에 관련된 돈을 의미 하는 클래스
 */
public class LottoMoney {
    private final int lottoMoney;


    public LottoMoney(int lottoMoney){
        this.lottoMoney = lottoMoney;
    }

    /* 로또 구입 금액을 입력 받는 메소드 */
    public static int getLottoMoney(){

        System.out.println("구입 금액을 입력해 주세요");

        Scanner getMoney = new Scanner(System.in);
        LottoMoney money = new LottoMoney(getMoney.nextInt());

        return money.lottoMoney;
    }
}
