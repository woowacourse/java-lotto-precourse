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
        Lotto[] PurchaseLotto=CreateLotto(NumOfLotto);
        PrintNumber(NumOfLotto, PurchaseLotto);
        Lotto ThisWeekLottoList = ThisWeekNumber();
        int ThisWeekBonusNumber = ThisWeekBonusNumber();
        WinningLotto WinLotto = new WinningLotto(ThisWeekLottoList,ThisWeekBonusNumber);
        int[] LuckyCount = new int[6];
        LuckyCount = ResultCount(WinLotto, PurchaseLotto);
        int FinalGetMoney =ResultMoney(WinLotto, PurchaseLotto);
        ResultPrint(LuckyCount);
        ResultRate(Money, FinalGetMoney);
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
        System.out.printf("%d개를 구매했습니다.\n", NumLotto);
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
        for(int i=0; i<num; i++)
        {
            PrintLotto[i].PrintLottoNumber();
        }
    }

    public static Lotto ThisWeekNumber()
    {
        List<Integer> ThisWeekLotto = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        String ThisWeekNumber = sc.nextLine();
        String[] temp = ThisWeekNumber.split(",");
        for(int i=0; i<temp.length;i++)
        {
            ThisWeekLotto.add(Integer.parseInt(temp[i]));
        }
        Lotto tmp_Lotto = new Lotto(ThisWeekLotto);
        return tmp_Lotto;
    }

    public static int ThisWeekBonusNumber()
    {
        System.out.println("보너스 볼을 입력해 주세요");
        Scanner sc= new Scanner(System.in);
        int BonusNum;
        BonusNum = sc.nextInt();
        return BonusNum;
    }
    public static int[] ResultCount(WinningLotto WinLottos, Lotto[] Lottos)
    {
        int [] resultcount = new int[6];
        for(int i=0; i<Lottos.length; i++)
        {
            Rank rank = WinLottos.match(Lottos[i]);
            resultcount[rank.ordinal()]++;
        }
        return resultcount;
    }
    public static int ResultMoney(WinningLotto WinLottos, Lotto[] Lottos)
    {
        int money = 0;
        for(int i=0; i<Lottos.length; i++)
        {
            Rank rank = WinLottos.match(Lottos[i]);
            money += rank.getWinningMoney();
        }
        return money;
    }
    public static void ResultPrint(int[] result)
    {
        System.out.println("당첨 통계");
        System.out.println("----------");
        System.out.printf("3개 일치(5000원)- %d개 \n", result[4]);
        System.out.printf("4개 일치(50000원)- %d개 \n", result[3]);
        System.out.printf("5개 일치(150000원)- %d개 \n", result[2]);
        System.out.printf("5개 일치, 보너스 볼 일치(30000000원)- %d개 \n", result[1]);
        System.out.printf("6개 일치(2000000000원)- %d개 \n", result[0]);
    }
    public static void ResultRate(int purchase, int profit)
    {
        double resultrate= (double)profit/purchase;
        System.out.printf("총 수익률은%f입니다.\n",resultrate);
    }
}
