package domain;

import java.util.*;

/**
 * 게임의 흐름을 컨트럴하는 마스터 객체
 */
public class Controller {
    public static final int MINIMUM_MONEY = 1000;      //로또 구입할수 있는 최소 가격
    public static final int MAXIMUM_MONEY = 100000;    //로또 구입할수 있는 최대 가격
    public static final int LOTTOS_NUMBER = 7;         //로또의 번호 갯수
    public static final int LOTTOS_LIMIT_NUMBER = 45;  //로또번호 한도 숫자
    public static int money;

    private final int RANK_SECOND_WINNING_MONEY = 30000000;
    private final int START_RANKING = 4;         // 출력이 반대로이기 때문에 RANK FIFITH 부터
    private List<Lotto> lottos;
    private List<Rank> ranks;

    public Controller() {
        lottos = new ArrayList<>();
        ranks = new ArrayList<>();
    }

    public void buyLotto() {
        int lottoAmount = calculateLottoAmount();

        System.out.printf("%d개를 구매했습니다.\n", lottoAmount);

        for (int i = 0; i < lottoAmount; i++) {
            lottos.add(new Lotto(makeRandomNumber()));
        }
    }

    /* 받은 돈으로 살수 있는 로또 갯수와 거스름돈 반환 */
    public int calculateLottoAmount() {
        if ((money % MINIMUM_MONEY) != 0) {
            System.out.printf("%d 남았습니다.\n", money % MINIMUM_MONEY);
        }

        return money / MINIMUM_MONEY;
    }

    public List<Integer> makeRandomNumber() {
        List<Integer> randomNumberList = new ArrayList<>();
        int randomNum;

        do {
            randomNum = (int) (Math.random() * LOTTOS_LIMIT_NUMBER) + 1;
        } while (checkNumberToList(randomNum, randomNumberList));

        return randomNumberList;
    }

    /* 생성된 숫자가 중복되는지 확인 및 7개 만들어졌는지 확인 하는 메소드 */
    public boolean checkNumberToList(int randomNum, List<Integer> randomNumberList) {
        if (randomNumberList.size() == LOTTOS_NUMBER) {
            return false;
        }

        if (!randomNumberList.contains(randomNum)) {
            randomNumberList.add(randomNum);
        }
        return true;
    }

    /* 만들어진 로또들의 숫자 전부 보여주기 */
    public void showLottosNumber() {
        for (Lotto each : lottos) {
            System.out.println(each.getNumbersList().toString());
        }
    }

    public void showResult(List<Integer> lastLotto) {
        HashMap<Rank, Integer> resultRank = new LinkedHashMap<>();
        int prizeMoney;

        makeWinningLotto(lastLotto);
        makeHashRank(resultRank);
        prizeMoney = calculateRankPrize(resultRank);
        for (int i = START_RANKING; i >= 0; --i) {                  // FIFTH 부터 시작
            System.out.println(printResult(Rank.values()[i], resultRank));
        }
        printEarningRate(prizeMoney);
    }

    public void makeWinningLotto(List<Integer> lastLotto) {
        int bonusNumber = lastLotto.get(LOTTOS_NUMBER - 1);
        lastLotto.remove(LOTTOS_NUMBER - 1);             //마지막 보너스번호만 제외하기 위해서

        WinningLotto winningLotto = new WinningLotto(new Lotto(lastLotto), bonusNumber);

        for (Lotto users : lottos) {
            ranks.add(winningLotto.match(users));
        }

    }

    /* User가 갖고 있는 당첨이 어떤 것인지 알기 위해서 우선 모든 Rank를 key로한 map을 생성하는 기능 */
    public void makeHashRank(HashMap<Rank, Integer> resultRank) {
        for (Rank rank : Rank.values()) {
            resultRank.put(rank, 0);
        }
    }

    public int calculateRankPrize(HashMap<Rank, Integer> resultRank) {
        int sumPrize = 0;

        for (Rank userRank : ranks) {
            sumPrize += userRank.getWinningMoney();
            resultRank.put(userRank, resultRank.get(userRank) + 1);
        }
        return sumPrize;
    }

    public String printResult(Rank rank, HashMap<Rank, Integer> resultRank) {
        if (rank.getWinningMoney() == RANK_SECOND_WINNING_MONEY) {
            return String.format(rank.getCountOfMatch() + "개 일치, 보너스 볼 일치 ("
                    + rank.getWinningMoney() + "원)-" + resultRank.get(rank) + "개");
        }

        return String.format(rank.getCountOfMatch() + "개 일치 ("
                + rank.getWinningMoney() + "원)-" + resultRank.get(rank) + "개");
    }

    public void printEarningRate(int prizeMoney) {
        double rate = (double) prizeMoney / (money - (money % MINIMUM_MONEY));
        System.out.printf("총 수익률은 %.3f입니다.", rate);
    }

}
