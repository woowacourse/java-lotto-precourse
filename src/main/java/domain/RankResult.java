package domain;

import constnum.Const;

public enum RankResult {
    MISS(Rank.MISS,Const.ZERO,"순위권 밖입니다."),
    FIFTH(Rank.FIFTH,Const.ZERO,Rank.FIFTH.getCountOfMatch()+ Const.RESULT_RANK_STR_MATCH_COUNT+Const.RESULT_RANK_STR_ROUND+Rank.FIFTH.getWinningMoney()+Const.RESULT_RANK_STR_PRIZE),
    FOURTH(Rank.FOURTH,Const.ZERO,Rank.FOURTH.getCountOfMatch()+Const.RESULT_RANK_STR_MATCH_COUNT+Const.RESULT_RANK_STR_ROUND+Rank.FOURTH.getWinningMoney()+Const.RESULT_RANK_STR_PRIZE),
    THIRD(Rank.THIRD,Const.ZERO,Rank.THIRD.getCountOfMatch()+Const.RESULT_RANK_STR_MATCH_COUNT+Const.RESULT_RANK_STR_ROUND+Rank.THIRD.getWinningMoney()+Const.RESULT_RANK_STR_PRIZE),
    SECOND(Rank.SECOND,Const.ZERO,Rank.SECOND.getCountOfMatch()+Const.RESULT_RANK_STR_MATCH_COUNT+Const.RESULT_RANK_STR_BONUS+Const.RESULT_RANK_STR_ROUND+Rank.SECOND.getWinningMoney()+Const.RESULT_RANK_STR_PRIZE),
    FIRST(Rank.FIRST,Const.ZERO,Rank.FIRST.getCountOfMatch()+Const.RESULT_RANK_STR_MATCH_COUNT+Const.RESULT_RANK_STR_ROUND+Rank.FIRST.getWinningMoney()+Const.RESULT_RANK_STR_PRIZE);

    private Rank rank;
    private int count;
    private String rankResultStr;

    private RankResult(Rank rank, int count, String rankResultStr){
        this.rank = rank;
        this.count = count;
        this.rankResultStr = rankResultStr;
    }

    public static RankResult valueOf(Rank rank){
        for(RankResult rankResult : values()){
            if(rankResult.rank == rank){
                return rankResult;
            }
        }
        throw new IllegalArgumentException(rank + "는 유효하지 않은 값입니다.");
    }

    private static RankResult initMatchRank(RankResult rankResult, Rank rank){
        if(rankResult.rank == rank){
            return rankResult;
        }
        throw new IllegalArgumentException(rank + "는 유효하지 않은 값입니다.");
    }

    public int getCount() {
        return count;
    }

    public String getRankResultStr() {
        return rankResultStr;
    }

    public Rank getRank() {
        return rank;
    }

    public void ifMatchRankIncreaseCount(Rank rank){
        if(this.rank == rank){
            increaseCountOne();
        }
    }

    private void increaseCountOne(){
        count++;
    }
}
