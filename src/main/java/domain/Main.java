package domain;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    final static int LOTTO_PRICE = 1000;
    final static Rank[] displayRankOrder = { Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST };

    static private WinningLotto winningLotto;
    static private Scanner staticSc;
    static private List<Lotto> lottoList;
    static private List<Integer> numSeq;
    static private Map<Rank, Integer> rankMap;

    private static Scanner getScanner() {
        if (staticSc == null) {
            staticSc = new Scanner(System.in);
        }

        return staticSc;
    }

    private static int getMoney() {
        int value, trials;
        Scanner sc = getScanner();
        System.out.println("구입금액을 입력해주세요.");

        value = sc.nextInt();

        return value;
    }

    private static void initNumSeq() {
        numSeq = new ArrayList<>();
        for (int i = 0; i < 45; i++) {
            numSeq.add(i + 1);
        }
    }

    private static void shuffleNumSeq() {
        if (numSeq == null) {
            initNumSeq();
        }

        for (int i = 0; i < 45; i++) {
            int tmp = numSeq.get(i);
            int target = (int)(Math.random() * (45 - i)) + i;
            numSeq.set(target, numSeq.get(i));
            numSeq.set(i, tmp);
        }
    }

    private static Lotto buyLotto() {
        shuffleNumSeq();
        return new Lotto(numSeq.subList(0, 5));
    }

    private static void buyMultipleLotto(int trials) {
        lottoList = new ArrayList<>();
        System.out.println(String.format("%d 개를 구매했습니다.", trials));
        for (int i = 0; i < trials; i++) {
            Lotto tmp = buyLotto();
            System.out.println(tmp.toString());
            lottoList.add(tmp);
        }
    }

    private static List<Integer> separateToList(String str) {
        return Arrays.stream(str.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static void getWinningLotto() {
        Scanner sc = getScanner();

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> numList = separateToList(sc.next());

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonus = sc.nextInt();

        winningLotto = new WinningLotto(new Lotto(numList), bonus);
    }

    private static void initRankMap() {
        rankMap = new HashMap<>();
        for (Rank r : Rank.values()) {
            rankMap.put(r, 0);
        }
    }

    private static void matchLottos() {
        initRankMap();
        for (int i = 0; i < lottoList.size(); i++) {
            Rank r = winningLotto.match(lottoList.get(i));
            rankMap.put(r, rankMap.get(r) + 1);
        }
        rankMap.remove(Rank.MISS);
    }

    private static int calculateBenefit() {
        int result = 0;
        for (Rank r : rankMap.keySet()) {
            result += r.getWinningMoney() * rankMap.get(r);
        }

        return result;
    }

    private static String formatRank(Rank r) {
        if (r == Rank.SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치(%d원)", r.getCountOfMatch(), r.getWinningMoney());
        }
        if (r == Rank.MISS) {
            return "꽝";
        }
        return String.format("%d개 일치 (%d원)", r.getCountOfMatch(), r.getWinningMoney());
    }

    private static void printResult(int money, int lottoMoney) {
        System.out.println("당첨 통계\n--------");
        for (Rank r : displayRankOrder) {
            System.out.println(formatRank(r) + String.format("- %d개", rankMap.get(r)));
        }

        System.out.println(String.format("총 수익률은 %3f입니다.", (float)lottoMoney / money);

    }

    public static void main(String[] args) {
        int money = getMoney();
        buyMultipleLotto((int)(money / LOTTO_PRICE));
        getWinningLotto();
        matchLottos();

        int lottoMoney = calculateBenefit();
        printResult(money, lottoMoney);
    }
}
