package domain;

import java.util.*;

public class LottoGameStart {

    final static int LOTTO_PRICE=1000;
    final static int LOTTO_SIZE = 6;
    final static int LOTTO_MAX_SIZE = 45;
    final static int LOTTO_MIN_SIZE = 1;


    public static void main(String[] args)
    {

        int Money = GetMoney();
        int NumOfLotto = GetNumOfLotto(Money);
        Lotto[] lotto=CreateLotto(NumOfLotto);
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

    public static Lotto[] CreateLotto(int NumberOfLotto)
    {
        Lotto[] NewLotto = new Lotto[NumberOfLotto];
        for(int i=0; i<NumberOfLotto; i++)
        {
            List<Integer> InputLotto = InputLottoNum();
            NewLotto[i] = new Lotto(InputLotto);
        }

        return NewLotto;
    }

    public static List<Integer> InputLottoNum()
    {
        List<Integer> NumberList = new ArrayList<Integer>();

        while(NumberList.size() < LOTTO_SIZE)
        {
            int RandomNum=RandomCreateNum();
            if(NumberList.contains(RandomNum))
            {
                continue;
            }
            NumberList.add(RandomNum);
        }
        Collections.sort(NumberList);
        return NumberList;
    }

    public static int RandomCreateNum()
    {
        Random random= new Random();
        int CreateNum=random.nextInt(LOTTO_MAX_SIZE)+LOTTO_MIN_SIZE;
        return CreateNum;
    }

    public static void PrintNumber(int num , Lotto[] PrintLotto)
    {

    }
}
