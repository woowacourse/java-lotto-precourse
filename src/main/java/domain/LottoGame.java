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
    final Rank[] rankDisplayOrder = {Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST};

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
        Map<Rank, Integer> rankCounter = createInitializedRankCounter();

        for (int i = 0; i < lottoList.size(); i++) {
            Rank rank = winningLotto.match(lottoList.get(i));
            rankCounter.put(rank, rankCounter.get(rank) + 1);
        }
        return rankCounter;
    }

    private Map<Rank, Integer> createInitializedRankCounter(){
        Map<Rank, Integer> rankCounter = new HashMap<Rank, Integer>();

        for (Rank rank: Rank.values()){
            rankCounter.put(rank,0);
        }
        return rankCounter;
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

        for (Rank displayRank: rankDisplayOrder){
            int count = rankCounter.get(displayRank);
            displayRank.printRank(count);   // 당첨통계 출력
        }
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
