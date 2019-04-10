package domain;

import java.util.*;

public class LottoGameStart {

    final static int LOTTO_PRICE=1000;

    public static void main(String[] args)
    {
        int Money = GetMoney();
        int NumOfLotto = GetNumOfLotto(Money);
    }

    public static int GetMoney()
    {
        int Price;
        Scanner sc = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요");
        Price = sc.nextInt();
        return Price;
    }

    public static int GetNumOfLotto(int money)
    {
        int NumLotto = money/LOTTO_PRICE;
        System.out.printf("%d개를 구매했습니다.", NumLotto);
        return NumLotto;
    }
    
}
