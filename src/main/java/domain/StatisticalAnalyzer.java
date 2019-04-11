package domain;

import java.util.*;

/**
 * 생성된 로또들의 당첨 통계와 수익성을 계산하는 객체
 *
 * @version 1.1(2019.04.11)
 * @author jongyoon Kim
 */
public class StatisticalAnalyzer {

    /**
     * 당첨 통계 계산
     *
     * @param lottoList 유저가 랜덤으로 뽑은 로또 리스트
     * @param winningLotto 당첨 번호 로또
     */
    public void calcWinningStatistical(ArrayList<Lotto> lottoList, WinningLotto winningLotto){
        Map<Rank, Integer> winningRankMap = initWinningRankMap();
        for(Lotto lotto : lottoList){
            Rank rank = winningLotto.match(lotto);                  //유저 로또와 당첨 번호 로또와 비교
            winningRankMap = checkingRank(rank, winningRankMap);    //비교하여 나온 값으로 rank 저장소 갱신
        }
        printWinningStatistical(winningRankMap);
        long totalEarning = calcTotalEarning(winningRankMap);
        printEarningRate(totalEarning,lottoList.size() * 1000);
    }

    /**
     * 유저 로또와 당첨 번호 로또들을 비교하여 나온 rank를 가지고 당첨 정보 갱신
     *
     * @param rank 유저 로또와 당첨 로또를 비교하여 나온 rank
     * @param winningRankMap 당첨 정보
     * @return 당첨 정보
     */
    private Map<Rank, Integer> checkingRank(Rank rank, Map<Rank, Integer> winningRankMap){
        if(rank != Rank.MISS){
            winningRankMap.put(rank, winningRankMap.get(rank) + 1);
        }
        return winningRankMap;
    }

    private void printWinningStatistical(Map<Rank, Integer> winningRankMap){
        winningStatisticalMessageIntro();
        for(Rank curRank : winningRankMap.keySet()){
            System.out.println(winningStatisticalMessage(curRank, winningRankMap));
        }
    }

    private void winningStatisticalMessageIntro(){
        System.out.println("당첨 통계");
        System.out.println("----------------------------");
    }

    /**
     * 당첨 정보를 가지고 당첨 통계 메세지 생성
     * 2등의 경우 보너스 볼이 맞아야 하므로 추가 메세지 삽입
     *
     * @param rank 현재 랭크
     * @param winningRankMap 당첨 정보
     * @return 해당 rank에 대한 메세지 생성
     */
    private String winningStatisticalMessage(Rank rank, Map<Rank, Integer> winningRankMap){
        String msg = rank.getCountOfMatch() + "개 일치";
        if(rank.equals(Rank.SECOND)){
            msg += ", 보너스 볼 일치";
        }
        msg += "(" + rank.getWinningMoney() + "원)-"
                + winningRankMap.get(rank) + "개";
        return msg;
    }

    private void printEarningRate(long totalEarning, int usedMoney){
        double earningRate = ((double) (totalEarning - usedMoney) / usedMoney) * 100;
        System.out.println("총 수익률은 " + String.format("%.1f", earningRate)
                            + "% 입니다.");
    }

    /**
     * 당첨 정보를 저장할 저장소(LinkedHashMap) 초기화
     *
     * @return 당첨 정보 저장할 맵 객체
     */
    private Map<Rank, Integer> initWinningRankMap(){
        Map<Rank, Integer> winningRankMap = new LinkedHashMap<>();
        winningRankMap.put(Rank.FIFTH,0);
        winningRankMap.put(Rank.FOURTH,0);
        winningRankMap.put(Rank.THIRD,0);
        winningRankMap.put(Rank.SECOND,0);
        winningRankMap.put(Rank.FIRST,0);
        return winningRankMap;
    }

    /**
     * 당첨 정보를 가지고 수입 계산
     *
     * @param winningRankMap 당첨 정보
     * @return 총 수입
     */
    private long calcTotalEarning(Map<Rank, Integer> winningRankMap){
        long totalEarning = 0;
        for(Rank rank : winningRankMap.keySet()){
            totalEarning += ((long)rank.getWinningMoney() * winningRankMap.get(rank));
        }
        return totalEarning;
    }
}
