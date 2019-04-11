/*
 * @(#)Rank.java		2019/4/11
 * 
 * Copyright (c) 2019 Junmo Han.
 * All rights reserved.
 */

/**
 * Rank 클래스는 구매한 로또와 당첨 로또가 서로 일치하는 숫자의 개수, 등수, 등수별 금액을 반환하는 기능을 합니다. 
 * 
 * @version			1.00 2019년 4월 11일
 * @author 			한준모
 */

package domain;

/**
 * 로또 등수를 의미하는 enum
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
		            	if (rank.matchCount(countOfMatch) && rank != SECOND){
		            			return rank;
		            	}
		        }
		        
		        throw new IllegalArgumentException(countOfMatch + "는 유효하지 않은 값입니다.");
	    }
	
	    private boolean matchCount(int countOfMatch) {
	        	return this.countOfMatch == countOfMatch;
	    }
}

