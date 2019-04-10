package domain;

import constnum.Const;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private List<RankResult> rankResultList = new ArrayList<>(Rank.values().length);
    private int winningMoney = Const.ZERO;
    private float winningMoneyPercent = Const.ZERO;

    public LottoResult(List<Rank> rank){
        initRankResultList();
        setRankingResult(rank);
    }

    private void initRankResultList(){
        for(Rank rank : Rank.values()){
            this.rankResultList.add(RankResult.valueOf(rank));
        }
    }

    private void setRankingResult(List<Rank> rankList){
        for(Rank rank : rankList){
            matchRank(rank);
            setWinMoney(rank);
        }
    }

    public void calWinningMoneyPercent(int userPayment){
        winningMoneyPercent = (float)winningMoney / (float)userPayment;
    }

    public void printRankResultList(){
        for(RankResult rankResult : rankResultList){
            printRankResult(rankResult);
        }
    }

    public float getWinningMoneyPercent() {
        return winningMoneyPercent;
    }

    private void matchRank(Rank rank){
        for(RankResult rankResult : rankResultList){
            rankResult.ifMatchRankIncreaseCount(rank);
        }
    }

    private void setWinMoney(Rank rank){
        winningMoney += rank.getWinningMoney();
    }

    private void printRankResult(RankResult rankResult){
        if(rankResult.getRank() == Rank.MISS){
            return;
        }
        System.out.println(rankResult.getRankResultStr() + " " + rankResult.getCount());
    }

}
