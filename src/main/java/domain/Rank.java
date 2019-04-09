/*
 * @Rank.java     0.1 2019-04-10
 * */

package domain;

/**
 * 로또 등수를 의미하는 enum
 *
 * @version 0.1
 */
public enum Rank {
    MISS(0, 0),
    FIFTH(3, 5_000), // 5등
    FOURTH(4, 50_000), // 4등
    THIRD(5, 1_500_000), // 3등
    SECOND(5, 30_000_000), // 2등
    FIRST(6, 2_000_000_000); // 1등

    private static final int WINNING_MIN_COUNT = 3; // 최소 3개를 맞춰야 당첨 금액이 존재

    private int countOfMatch; // 맞춘 갯수
    private int winningMoney; // 당첨 금액

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

    public int getWinningMinCount() {
        return WINNING_MIN_COUNT;
    }

    /**
     * 맞춘 갯수와 보너스 볼 일치 여부로 Lotto 당첨 등급을 결정
     *
     * @param countOfMatch Lotto 번호와 당첨 번호 일치한 갯수
     * @param matchBonus   Lotto 번호와 보너스 볼 일치 여부
     * @return 당첨 등급
     */
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
}

