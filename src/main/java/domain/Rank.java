/*
 * 이 클래스는 로또 등수를 의미하는 상수를 담고있습니다.
 *
 * 클래스 이름    Rank
 * 버전 정보     1.0
 * 날짜    2019/04/11
 * 저작권   권유상
 */

package domain;

public enum Rank {
    FIRST(6, 2_000_000_000), // 1등
    SECOND(5, 30_000_000), // 2등
    THIRD(5, 1_500_000), // 3등
    FOURTH(4, 50_000), // 4등
    FIFTH(3, 5_000), // 5등
    MISS(0, 0);

    private static final int WINNING_MIN_COUNT = 3;

    private int countOfMatch;
    private int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch < WINNING_MIN_COUNT) {
            return MISS;
        }

        if (SECOND.matchCount(countOfMatch) && matchBonus) {
            return SECOND;
        }

        for (Rank rank : values()) {
            if (rank.matchCount(countOfMatch) && rank != SECOND) {
                return rank;
            }
        }

        throw new IllegalArgumentException(countOfMatch + "는 유효하지 않은 값입니다.");
    }

    private boolean matchCount(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }

    public void printRank(int count) {
        if (countOfMatch < WINNING_MIN_COUNT) {
            return;
        }
        if (this == Rank.SECOND) {
            System.out.println(countOfMatch + "개 일치, 보너스볼 일치 (" + winningMoney + ")원 - " + count + "개");
            return;
        }
        System.out.println(countOfMatch + "개 일치 (" + winningMoney + ")원 - " + count + "개");
    }
}

