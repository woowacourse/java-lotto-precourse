package domain;

import java.util.Scanner;

/**
 *  로또에 관련된 돈을 의미 하는 클래스
 */
public class LottoMoney {

    private static final int GET_LOTTO_MONEY = 1000;

    /* 로또 구입 금액을 입력 받는 메소드 */
    public static int getLottoMoney(){

        Scanner getMoney = new Scanner(System.in);
        int lottoMoney = getMoney.nextInt();

        System.out.println("구입 금액을 입력해 주세요");

        return lottoMoney / GET_LOTTO_MONEY;
    }
}
