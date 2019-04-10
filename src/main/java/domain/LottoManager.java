package domain;

import java.util.HashMap;
import java.util.List;

public class LottoManager {
    private static final String RANK_THIRD = "3개 일치 (5000원)";
    private static final String RANK_FOURTH = "4개 일치 (50000원)";
    private static final String RANK_FIFTH = "5개 일치 (150000원)";
    private static final String RANK_FIFTHBONUS = "5개 일치, 보너스 볼 일치(30000000원)";
    private static final String RANK_SIX = "6개 일치 (2000000000원)";

    private UserLotto userLotto;
    private LottoMatch lottoMatch;
    private HashMap<Integer, Integer> map = new HashMap<>();


    public LottoManager() {
        userLotto = new UserLotto();
        lottoMatch = new LottoMatch();
    }

    public void startLotto() {
        userLotto.buyUserLotto();
        lottoMatch.startLottoMatch();
        map.put(2000000000, 0);
        map.put(30000000, 0);
        map.put(1500000, 0);
        map.put(50000, 0);
        map.put(5000, 0);
        map.put(0,0);
        makeRankList();
    }

    public void makeRankList() {
        List<Lotto> lottoList = userLotto.getLotto();
        WinningLotto winningLotto = new WinningLotto(lottoMatch.getWinLottoNum(), lottoMatch.getBonusNum());
        int tmp;

        for (Lotto lotto : lottoList) {

            tmp = map.get(winningLotto.match(lotto).getWinningMoney());
            map.put(winningLotto.match(lotto).getWinningMoney(), ++tmp);
        }
        System.out.println();
        printResult(map);
    }

    private void printResult(HashMap<Integer,Integer> map) {

        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(RANK_THIRD + "- " + map.get(5000) + "개");
        System.out.println(RANK_FOURTH + "- " +  map.get(50000) + "개");
        System.out.println(RANK_FIFTH + "- " + map.get(1500000) + "개");
        System.out.println(RANK_FIFTHBONUS + "- " + map.get(30000000) + "개");
        System.out.println(RANK_SIX + "- " + map.get(2000000000) + "개");

    }

}

