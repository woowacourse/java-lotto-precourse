package domain;

import exception.LottoConditionException;

import java.util.*;

public class Game {
    private Scanner sc = new Scanner(System.in);
    private Random random = new Random();

    private List<Lotto> lottos = new ArrayList<>();
    private WinningLotto winningLotto;
    private long total, gameNum;
    private int[] result = new int[5];
    private double prize = 0;

    protected void execute() {
        setGameNum();
        buyLotto();
        printLottos();
        winningLotto = generateWinningLotto();
        getResult();
        printResult();
    }

    private void getResult() {
        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.match(lotto);
            prize += rank.getWinningMoney();
            count(rank.getCountOfMatch(), rank.getWinningMoney());
        }
    }

    private void count(int countOfMatch, int winningMoney) {
        if (countOfMatch == 6) result[0]++;
        if (countOfMatch == 5 && winningMoney == 30000000) result[1]++;
        if (countOfMatch == 5 && winningMoney == 1500000) result[2]++;
        if (countOfMatch == 4) result[3]++;
        if (countOfMatch == 3) result[4]++;
    }

    private void printResult() {
        System.out.println("당첨 통계\n" + "---------");

        StringBuilder result = new StringBuilder();
        Rank[] rank = Rank.values();
        for (int i = 4; i >= 0; i--) {
            result.append(rank[i].getCountOfMatch() + "개 일치 (" + rank[i].getWinningMoney() + "원)-");
            result.append(this.result[i] + "개\n");
        }
        result.append("총 수익률은 " + (prize / total) + "입니다.");

        System.out.println(result.toString());
    }

    private void printLottos() {
        for (Lotto lotto : lottos) lotto.print();
        System.out.println();
    }

    private WinningLotto generateWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> list = new LinkedList<>();
        String[] input = sc.nextLine().split(",");
        for (String str : input)
            list.add(Integer.parseInt(str));

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonus = putBonusNumber();
        System.out.println();
        return new WinningLotto(new Lotto(list), bonus);
    }

    private int putBonusNumber()  {
        int bonus = sc.nextInt();
        sc.nextLine();

        if (bonus >= 1 && bonus <= 46) return bonus;
        try {
            throw new LottoConditionException();
        } catch (LottoConditionException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private Lotto generateLotto() {
        Set<Integer> set = new HashSet<>();
        while (set.size() < 6) {
            set.add(random.nextInt(45) + 1);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        return new Lotto(list);
    }

    private void buyLotto() {
        System.out.println(gameNum + "개를 구매했습니다.");

        for (int i = 0; i < gameNum; i++)
            lottos.add(generateLotto());
    }

    private void setGameNum() {
        System.out.println("구입금액을 입력해 주세요.");

        total = sc.nextLong();
        sc.nextLine();
        gameNum = total / 1000;

        System.out.println();
    }
}
