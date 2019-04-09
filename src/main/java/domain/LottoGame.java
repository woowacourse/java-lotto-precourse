/*
 * Class: LottoGame.java
 * Version: 1.0
 * Date: 2019-04-09
 * Author: Kibaek Yoo
 */

package domain;

import java.util.*;

public class LottoGame {

    static final String COMMENT_WHEN_RECEIVE_INPUT_MONEY = "구입금액을 입력해 주세요.";
    static List<Lotto> lottoList;
    static WinningLotto winningLotto;

    private int getLottoCountFromUser(Scanner sc) {
        System.out.println(COMMENT_WHEN_RECEIVE_INPUT_MONEY);
        int lottoCount = DataReceiver.getInputMoneyFromUser(sc) / GameSetting.PRICE_PER_1LOTTO;

        return lottoCount;
    }

    private void createLottos(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
        List<Lotto> createdLottoList = new LinkedList<Lotto>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto createdLotto = Lotto.createRandomLotto();
            createdLottoList.add(createdLotto);
        }
        lottoList = createdLottoList;
    }

    private void printLottos() {
        for (int i = 0; i < lottoList.size(); i++) {
            lottoList.get(i).printLottoNumbers();
        }
    }

    private void createWinningLotto(Scanner sc) {
        ArrayList<Integer> winNumberList = DataReceiver.getWinningLottoNumbersFromUser(sc);
        int bonusNumber = DataReceiver.getBonusNumberFromUser(winNumberList, sc);

        winningLotto = new WinningLotto(new Lotto(winNumberList), bonusNumber);
    }

    private Map<Rank, Integer> calculateLottoMatch() {
        Map<Rank, Integer> rankCounter = createSortAppliedRankCounter();
        addAllRankTypes(rankCounter);

        for (int i = 0; i < lottoList.size(); i++) {
            Rank rank = winningLotto.match(lottoList.get(i));
            rankCounter.put(rank, rankCounter.get(rank) + 1);
        }
        return rankCounter;
    }

    /**
     * TreeMap을 생성해 반환합니다. TreeMap은 key(Rank)가 countOfMatch의 내림차순으로 정렬하기로
     * 약속되어있습니다. 이렇게 하는 이유는, 앞으로 여러 Rank가 추가되더라도 Rank Enum 에만 그 종류를
     * 추가하면, 추후 Rank별로 print할때 자동으로 정렬이 되어 print되도록 하기 위함입니다.
     *
     * @return Map<Rank, Integer> 랭크별로 갯수를 세는데 이용되는 Map 반환
     */
    private Map<Rank, Integer> createSortAppliedRankCounter() {
        Map<Rank, Integer> rankSortedMap = new TreeMap<Rank, Integer>((Rank a, Rank b) -> {
            return compareRank(a, b);
        });
        return rankSortedMap;
    }

    /**
     * Rank를 countOfMatch의 오름차순으로 정렬하기위한 비교 함수
     *
     * @param rankA
     * @param rankB
     * @return
     */
    private int compareRank(Rank rankA, Rank rankB) {
        if (rankA.getWinningMoney() != rankB.getWinningMoney()) {
            return (rankA.getWinningMoney() < rankB.getWinningMoney()) ? -1 : 1;
        }

        return 0;
    }

    /**
     * rankCounter는 Rank종류별 갯수를 저장하기위한 자료구조 입니다. 이 자료구조에 미리
     * 모든 종류의 Rank를 0으로 초기화 합니다.
     * @param rankCounter Rank종류별로, 몇개가 당첨됬는지 저장하기위한 자료구조
     */
    private void addAllRankTypes(Map<Rank, Integer> rankCounter) {
        for (Rank rank : Rank.values()) {
            rankCounter.put(rank, 0);
        }
    }

    private double calculateProfitRate(Map<Rank, Integer> rankCounter, int lottoCount) {
        double profitPercent = 0;
        double totalLottoMoney = (double) (lottoCount * GameSetting.PRICE_PER_1LOTTO);

        for (Map.Entry<Rank, Integer> entry : rankCounter.entrySet()) {
            int count = entry.getValue();
            profitPercent += (entry.getKey().getWinningMoney() * count) / totalLottoMoney;
        }
        return profitPercent;
    }

    private void printLottoResult(Map<Rank, Integer> rankCounter, double profitPercent) {
        // 당첨통계 출력
        for (Map.Entry<Rank, Integer> entry : rankCounter.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            rank.printRank(count);
        }
        // 수익률 출력
        System.out.println("총 수익률은 " + String.format("%.1f", profitPercent) + "입니다");
    }

    public void playGame() {
        Scanner sc = new Scanner(System.in);
        int lottoCount = getLottoCountFromUser(sc);

        createLottos(lottoCount);
        printLottos();
        createWinningLotto(sc);
        Map<Rank, Integer> lottoMatchResult = calculateLottoMatch();
        double profitPercent = calculateProfitRate(lottoMatchResult, lottoCount);
        printLottoResult(lottoMatchResult, profitPercent);
    }
}
