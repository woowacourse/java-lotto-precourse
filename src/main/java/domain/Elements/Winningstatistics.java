package domain.Elements;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Winningstatistics {
    private Map<Rank, Integer> statisticsMap = new TreeMap<>(Collections.reverseOrder());

    public Winningstatistics(){
        for(Rank value : Rank.values())
        statisticsMap.putIfAbsent(value,0);
    }

    public static Winningstatistics createWinningStatistics(Lotto[] lottoBundle, WinningLotto winningLotto){
        Winningstatistics statisticsMapInstance = new Winningstatistics();
        for(Lotto value: lottoBundle){
            statisticsMapInstance.putRank(winningLotto.match(value));
        }
        return statisticsMapInstance;
    }

    public Map<Rank, Integer> getStatisticsMap(){
        return statisticsMap;
    }

    @Override
    public String toString(){
        return statisticsMap.toString();
    }

    private void putRank(Rank rank){
        statisticsMap.put(rank,statisticsMap.get(rank)+1);
    }

}
