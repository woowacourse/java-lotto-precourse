/*
 *@(#)Rank.java           1.0 2019/04/11
 *Copyright (c) 2019 Hyogeon Kim.
 *Lotto Game, Java, Mungyeong, KOREA
 */

package domain;

/**
 * 로또 게임에서 랭크에 대한 정보를 가지고
 * 그에 대한 기능을 하는 클래스
 * @author 김효건
 * @version 1.0 2019년 04월 011일
 */

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
}

