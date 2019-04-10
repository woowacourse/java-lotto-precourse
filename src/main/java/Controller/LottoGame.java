/*
 * Class: LottoGame.java
 * Version: 1.0
 * Date: 2019-04-09
 * Author: Kibaek Yoo
 */

package Controller;

import database.GameSetting;
import database.UserViewData;
import lottodata.Lotto;
import lottodata.Rank;
import lottodata.WinningLotto;

import java.util.*;

public class LottoGame {
    private static int getLottoCountFromUser(Scanner sc) {
        System.out.println(UserViewData.COMMENT_WHEN_RECEIVE_INPUT_MONEY);
        int lottoCount = DataReceiver.getInputMoneyFromUser(sc) / GameSetting.PRICE_PER_1LOTTO;

        return lottoCount;
    }

    private static List<Lotto> createLottos(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
        List<Lotto> createdLottoList = new LinkedList<Lotto>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto createdLotto = Lotto.createRandomLotto();
            createdLottoList.add(createdLotto);
        }
        return createdLottoList;
    }

    private static void printLottos(List<Lotto> lottoList) {
        for (int i = 0; i < lottoList.size(); i++) {
            lottoList.get(i).printLottoNumbers();
        }
    }

    private static WinningLotto createWinningLotto(Scanner sc) {
        String winningLottoNumbers = DataReceiver.getWinningLottoNumbersFromUser(sc);
        ArrayList<Integer> winNumberList = transformWinningNumberInputToIntegerList(winningLottoNumbers);
        int bonusNumber = DataReceiver.getBonusNumberFromUser(winNumberList, sc);

        return new WinningLotto(new Lotto(winNumberList), bonusNumber);
    }

    private static ArrayList<Integer> transformWinningNumberInputToIntegerList(String winningNumbersInput) {
        String[] correctNumbers = winningNumbersInput.split(",");
        ArrayList<Integer> winningNumbers = new ArrayList<Integer>();
        for (int i = 0; i < correctNumbers.length; i++) {
            winningNumbers.add(Integer.parseInt(correctNumbers[i]));
        }
        return winningNumbers;
    }

    private static Map<Rank, Integer> calculateLottoMatch(List<Lotto> lottoList, WinningLotto winningLotto) {
        Map<Rank, Integer> rankCounter = createInitializedRankCounter();

        for (int i = 0; i < lottoList.size(); i++) {
            Rank rank = winningLotto.match(lottoList.get(i));
            rankCounter.put(rank, rankCounter.get(rank) + 1);
        }
        return rankCounter;
    }

    private static Map<Rank, Integer> createInitializedRankCounter() {
        Map<Rank, Integer> rankCounter = new HashMap<Rank, Integer>();

        for (Rank rank : Rank.values()) {
            rankCounter.put(rank, 0);
        }
        return rankCounter;
    }

    private static double calculateProfitRate(Map<Rank, Integer> rankCounter, int lottoCount) {
        double profitPercent = 0;
        double totalLottoMoney = (double) (lottoCount * GameSetting.PRICE_PER_1LOTTO);

        for (Map.Entry<Rank, Integer> entry : rankCounter.entrySet()) {
            int count = entry.getValue();
            profitPercent += (entry.getKey().getWinningMoney() * count) / totalLottoMoney;
        }
        return profitPercent;
    }

    private static void printLottoResult(Map<Rank, Integer> rankCounter, double profitPercent) {
        final Rank[] rankDisplayOrder = {Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST};

        for (Rank displayRank : rankDisplayOrder) {
            int count = rankCounter.get(displayRank);
            displayRank.printRank(count);   // 당첨통계 출력
        }
        System.out.println("총 수익률은 " + String.format("%.1f", profitPercent) + "입니다");
    }

    public void playGame() {
        Scanner sc = new Scanner(System.in);
        int lottoCount = getLottoCountFromUser(sc);

        List<Lotto> lottoList = createLottos(lottoCount);
        printLottos(lottoList);
        WinningLotto winningLotto = createWinningLotto(sc);
        Map<Rank, Integer> lottoMatchResult = calculateLottoMatch(lottoList, winningLotto);
        double profitPercent = calculateProfitRate(lottoMatchResult, lottoCount);
        printLottoResult(lottoMatchResult, profitPercent);
    }
}
