package domain;

import java.util.Scanner;

import static domain.LottoGame.GET_LOTTO_MONEY;

/**
 *  로또에 관련된 돈을 의미 하는 클래스
 */
public class LottoMoney {
    private final int lottoMoney;


    public LottoMoney(int lottoMoney){
        this.lottoMoney = lottoMoney;
    }

    public static int getLottoMoney(){


        int spendMoney = 0;
        while(true){
            System.out.println("구입 금액을 입력해 주세요");

            Scanner getMoney = new Scanner(System.in);
            spendMoney = getMoney.nextInt();

            if(spendMoney < GET_LOTTO_MONEY){

                System.out.printf("%d원 부터 로또 구매가 가능합니다\n",GET_LOTTO_MONEY);
                continue;
            }
            break;
        }
        LottoMoney money = new LottoMoney(spendMoney);

        return money.lottoMoney;
    }
}
