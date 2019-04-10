package domain;

import java.util.*;

/**
 * 생성된 로또들의 당첨 통계와 수익성을 계산하는 객체
 *
 * @version 1.0(2019.04.10)
 * @author jongyoon Kim
 */
public class StatisticalAnalyzer {
    private Map<Rank, Integer> winningRankMap = new LinkedHashMap<>();
    private int totalWinningPrice = 0;
    private int usedMoney;
    private static Inputter inputter = new Inputter();
    private static LottoCreator lottoCreator = new LottoCreator();

    public static void main(String[] args) {
        StatisticalAnalyzer statisticalAnalyzer = new StatisticalAnalyzer();
        statisticalAnalyzer.winningStatistical();
    }

    public void winningStatistical(){
        ArrayList<Lotto> lottoList = inputLottoAmountAndCreateLottoList();
        WinningLotto winningLotto = inputWinningNumAndCreateWinningLotto();
        initWinningRankMap();
        for(Lotto lotto : lottoList){
            Rank rank = winningLotto.match(lotto);
            checkingRankAndCalcTotalPrice(rank);
        }
        printWinningStatistical();
        printEarningRate();
    }

    private void checkingRankAndCalcTotalPrice(Rank rank){
        if(rank != Rank.MISS){
            winningRankMap.put(rank, winningRankMap.get(rank) + 1);
            totalWinningPrice += rank.getWinningMoney();
        }
    }

    private void printWinningStatistical(){
        winningStatisticalMessageIntro();
        Iterator<Rank> iterator = winningRankMap.keySet().iterator();
        while(iterator.hasNext()){
            Rank curRank = iterator.next();
            System.out.println(winningStatisticalMessage(curRank));
        }
    }

    private void winningStatisticalMessageIntro(){
        System.out.println("당첨 통계");
        System.out.println("----------------------------");
    }

    private String winningStatisticalMessage(Rank rank){
        String msg = rank.getCountOfMatch() + "개 일치";
        if(rank.equals(Rank.SECOND)){
            msg += ", 보너스 볼 일치";
        }
        msg += "(" + rank.getWinningMoney() + "원)-"
                + winningRankMap.get(rank) + "개";
        return msg;
    }

    private void printEarningRate(){
        double earningRate = (double) totalWinningPrice / usedMoney;
        System.out.println("총 수익률은 " + earningRate
                            + "% 입니다.");
    }

    private ArrayList<Lotto> inputLottoAmountAndCreateLottoList(){
        int lottoAmount = inputter.inputPurchaseAmount();
        usedMoney = lottoAmount * 1000;
        return lottoCreator.purchaseLottoForAmount(lottoAmount);
    }

    private WinningLotto inputWinningNumAndCreateWinningLotto(){
        String inputtedWinningNum = inputter.inputWinningNumber();
        List<Integer> splittedWinningNum = lottoCreator.splitWinningNumAndCheckingReInput(inputtedWinningNum);
        int bonusNum = inputter.inputBonusNumber(splittedWinningNum);
        return lottoCreator.createWinningLotto(splittedWinningNum, bonusNum);
    }

    private void initWinningRankMap(){
        winningRankMap.put(Rank.FIFTH,0);
        winningRankMap.put(Rank.FOURTH,0);
        winningRankMap.put(Rank.THIRD,0);
        winningRankMap.put(Rank.SECOND,0);
        winningRankMap.put(Rank.FIRST,0);
    }
}
