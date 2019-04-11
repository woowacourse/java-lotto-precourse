package domain;

import java.util.List;
import java.util.TreeMap;

public class LottoManager {
    private UserLotto userLotto;
    private LottoMatch lottoMatch;
    private TreeMap<Integer, Integer> map = new TreeMap<>();
    private String[] resultStrArray = new String[6];

    public LottoManager() {
        userLotto = new UserLotto();
        lottoMatch = new LottoMatch();
    }

    public void startLotto() {
        userLotto.buyUserLotto();
        lottoMatch.startLottoMatch();
        settingMap();
        settingResultArray();
        makeRankList();
    }

    private void settingMap(){
        map.put(Rank.FIRST.getWinningMoney(), 0);
        map.put(Rank.SECOND.getWinningMoney(), 0);
        map.put(Rank.THIRD.getWinningMoney(), 0);
        map.put(Rank.FOURTH.getWinningMoney(), 0);
        map.put(Rank.FIFTH.getWinningMoney(), 0);
        map.put(Rank.MISS.getWinningMoney(),0);
    }

    private void settingResultArray(){
        resultStrArray[0] = Constant.RANK_MISS;
        resultStrArray[1] = Constant.RANK_THIRD;
        resultStrArray[2] = Constant.RANK_FOURTH;
        resultStrArray[3] = Constant.RANK_FIFTH;
        resultStrArray[4] = Constant.RANK_FIFTH_BONUS;
        resultStrArray[5] = Constant.RANK_SIX;
    }

    private void makeRankList() {
        List<Lotto> lottoList = userLotto.getLotto();
        WinningLotto winningLotto = new WinningLotto(lottoMatch.getWinLottoNum(), lottoMatch.getBonusNum());
        int tmp;
        int totalPrice = 0;

        for (Lotto lotto : lottoList) {
            tmp = map.get(winningLotto.match(lotto).getWinningMoney());
            map.put(winningLotto.match(lotto).getWinningMoney(), ++tmp);
            totalPrice += winningLotto.match(lotto).getWinningMoney();
        }

        int[] rank = new int[6];
        int i = 0;
        for (int key: map.keySet()) {
            rank[i++] = map.get(key);
        }
        printResult(rank,totalPrice, lottoList.size());
    }


    private void printResult(int[] rankArray, int totalPrice, int userLottoAmount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int i = 1; i < rankArray.length; i++) {
            System.out.println(resultStrArray[i]+"- "+rankArray[i]+"개");
        }
        printWinRating(totalPrice,userLottoAmount);
    }

    private void printWinRating(double totalPrice, double userLottoAmount){
        double winRate = Double.parseDouble(String.format("%.3f", totalPrice/(userLottoAmount*1000)));
        System.out.println("총 수익률은 "+winRate+"입니다.");
    }

}

