package domain;

/**
 * 로또 등수를 의미하는 enum
 */
public enum Rank {
    MISS(0, 0), // 낙첨
    FIFTH(3, 5_000), // 5등
    FOURTH(4, 50_000), // 4등
    THIRD(5, 1_500_000), // 3등
    SECOND(5, 30_000_000, ", 보너스 볼 일치"), // 2등
    FIRST(6, 2_000_000_000); // 1등;

    private static final int WINNING_MIN_COUNT = 3;

    private int countOfMatch;
    private int winningMoney;
    private String additionalMessage = "";

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    private Rank(int countOfMatch, int winningMoney, String additionalMessage) {
        this(countOfMatch, winningMoney);
        this.additionalMessage = additionalMessage;
    }
    
    private boolean matchCount(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
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
            if (rank.matchCount(countOfMatch)) {
                return rank;
            }
        }

        throw new IllegalArgumentException(countOfMatch + "는 유효하지 않은 값입니다.");
    }

    public String getRankDescription() {
        if (MISS.equals(this)) {
            return "낙첨";
        }
        
        return this.countOfMatch + "개 일치" + this.additionalMessage
                + " (" + this.winningMoney + "원)";
    }
}
