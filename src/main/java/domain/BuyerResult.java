package domain;
/**
 * BuyerResult.class        1.00 2019/04/09
 *
 * <Copyright 2019. LeeNamJun. All rights reserved.>
 */

/**
 * 구매자의 결과를 저장하는 클래스
 *
 * @version 1.00
 * @author 이남준
 */
public class BuyerResult {
    private static long totalWinningMoney = 0;
    private static int[] countOfWinningLottos = new int[5];

    public void setReults (Rank rank) {
        if(rank.getWinningMoney() > 0) {
            totalWinningMoney += rank.getWinningMoney();
            countOfWinningLottos[rank.getGrade() - 1]++;
        }
    }

    public long getTotalWinningMoney() {
        return totalWinningMoney;
    }

    public int[] getCountOfWinningLottos() {
        return countOfWinningLottos;
    }
}
