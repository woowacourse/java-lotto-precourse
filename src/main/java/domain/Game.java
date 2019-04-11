package domain;

import java.util.*;

public class Game {
    private final String[] SENTENCE = {
            "구입금액을 입력해 주세요.",
            "개를 구매했습니다.",
            "지난 주 당첨 번호를 입력해 주세요.",
            "보너스 볼을 입력해 주세요.",
            "당첨 통계\n" + "---------",
            "총 수익률은 ",
            "입니다."
    };

    private Scanner sc = new Scanner(System.in);
    private Random random = new Random();

    private List<Lotto> lottos = new ArrayList<>();
    private WinningLotto winningLotto;
    private int gameNum, prize = 0;
    private int[] result = new int[6];

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
        if (countOfMatch == 6) result[5]++;
        if (countOfMatch == 5 && winningMoney == 30000000) result[4]++;
        if (countOfMatch == 5 && winningMoney == 1500000) result[3]++;
        if (countOfMatch == 4) result[2]++;
        if (countOfMatch == 3) result[1]++;
    }

    private void printResult() {
        System.out.println(SENTENCE[4]);

        StringBuilder result = new StringBuilder();
        Rank[] rank = Rank.values();
        for (int i = 4; i >= 0; i--) {
            result.append(rank[i].getCountOfMatch() + "개 일치 (" + rank[i].getWinningMoney() + "원)-");
            result.append(this.result[i] + "개\n");
        }
        System.out.println(result.toString());
    }
    private void printLottos() {
        for (int i = 0; i < gameNum; i++) {
            lottos.get(i).print();
        }
        System.out.println();
    }

    private WinningLotto generateWinningLotto() {
        System.out.println(SENTENCE[2]);

        // 임시로 당첨 번호 받기
        List<Integer> list = new LinkedList<>();
        String[] input = sc.nextLine().split(",");
        for (String str : input) {
            list.add(Integer.parseInt(str));
        }

        System.out.println(SENTENCE[3]);
        int bonus = sc.nextInt();

        Lotto lotto = new Lotto(list);

        return new WinningLotto(lotto, bonus);
    }

    /*private void putValidNumber(List<Integer> list) {
        StringBuilder input = new StringBuilder(sc.nextLine());
        while (input.length() > 2) {
            // 한 자리 수일 때
            if (input.charAt(1) == ',') {

            }
            // 두 자리 수일 때
            else if (input.charAt(1) >= '0' && input.charAt(1) <= '9') {

            }
        }

    }

    private boolean isValidNumber(StringBuilder input, List<Integer> list) {

    }*/

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
        System.out.println(gameNum + SENTENCE[1]);

        for (int i = 0; i < gameNum; i++)
            lottos.add(generateLotto());
    }

    private void setGameNum() {
        System.out.println(SENTENCE[0]);

        int total = sc.nextInt();
        sc.nextLine();
        gameNum = total / 1000;

        System.out.println();
    }
}
