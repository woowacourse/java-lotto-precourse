/**
 * 우아한테크코스 프리코스 3주차 미션
 * 로또 게임
 *
 * @author JiHoon Kim
 * @version 1.0
 */

package domain;

import java.util.List;

/**
 * 구매금액과 당첨금, 로또 객체의 리스트를 가지고 있는 클래스
 */
public class Person {
    private final int BUDGET_MIN_LIMIT = 0;
    private final int LOTTO_PRICE = 1000;

    private int budget;
    private int prizeMoney;
    private List<Lotto> myLotto;

    public Person() {
        prizeMoney = 0;
    }

    public boolean setBudget(int budget) {
        if (budget < BUDGET_MIN_LIMIT) {
            System.out.println("마이너스 통장을 갖고 있어서 로또를 살 수 없습니다.");
            return false;
        }
        this.budget = budget;

        return true;
    }

    public int payBudget() {
        return budget;
    }

    public void keepLotto(List<Lotto> lottoList) {
        this.myLotto = lottoList;
    }

    /**
     * 가지고 있는 로또를 당첨 번호와 비교해서 종류별 갯수로 분류한 Array로 리턴해주는 메소드
     *
     * @param winningLotto 당첨 번호
     * @return convertToRankIndex 메소드를 통해 분류한 Array
     */
    public int[] checkRank(WinningLotto winningLotto) {
        int[] rankCounter = new int[6];
        Rank rank;

        for (Lotto lotto : myLotto) {
            rank = winningLotto.match(lotto);
            rankCounter[convertRankToIndex(rank)]++;
            prizeMoney += rank.getWinningMoney();
        }

        return rankCounter;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    /**
     * @return 로또를 사는데 쓰인 액수
     */
    public int getMoneySpent() {
        return (budget / LOTTO_PRICE) * LOTTO_PRICE;
    }

    /**
     * 랭크를 종류마다 Array로 분류하기 위해 각각의 인덱스 값으로 리턴해주는 메소드
     *
     * @param rank 가지고 있는 로또와 당첨 로또를 비교한 랭크
     * @return MISS - 0 // FIFTH - 1 // FOURTH - 2 // THIRD - 3 // SECOND - 4 // FIRST - 5
     */
    private int convertRankToIndex(Rank rank) {
        if (rank.equals(Rank.MISS))
            return 0;
        if (rank.equals(Rank.FIFTH) || rank.equals(Rank.FOURTH))
            return rank.getCountOfMatch() - 2;
        if (rank.equals(Rank.THIRD))
            return 3;
        if (rank.equals(Rank.SECOND))
            return 4;
        return 5;
    }
}
