package domain;

import java.util.List;

public class LottoManager {
    private static final String RANK_THIRD = "3개 일치 (5000원)";
    private static final String RANK_FOURTH = "4개 일치 (50000원)";
    private static final String RANK_FIFTH = "5개 일치 (150000원)";
    private static final String RANK_FIFTHBONUS = "5개 일치, 보너스 볼 일치(30000000원)";
    private static final String RANK_SIX = "6개 일치 (2000000000원)";

    private UserLotto userLotto;
    private LottoMatch lottoMatch;

    public LottoManager(){
        userLotto = new UserLotto();
        lottoMatch = new LottoMatch();
    }

    public void startLotto(){
        userLotto.buyUserLotto();
        lottoMatch.startLottoMatch();
        makeRankList();
    }

    public void makeRankList(){
        List<Lotto> lottoList = userLotto.getLotto();
        WinningLotto winningLotto = new WinningLotto(lottoMatch.getWinLottoNum(), lottoMatch.getBonusNum());
        int[] winLottoCountArray = new int[8];

        for (Lotto lotto : lottoList) {
            winLottoCountArray[winningLotto.match(lotto).getCountOfMatch()]++;
        }
        System.out.println();
        printResult(winLottoCountArray);
    }

    private void printResult(int[] rankingArray){

        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(RANK_THIRD +"- "+rankingArray[3]+"개");
        System.out.println(RANK_FOURTH +"- "+ rankingArray[4]+"개");
        System.out.println(RANK_FIFTH +"- "+ rankingArray[5]+"개");
        System.out.println(RANK_FIFTHBONUS +"- "+ rankingArray[6]+"개");
        System.out.println(RANK_SIX +"- "+ rankingArray[6]+"개");

    }

}

