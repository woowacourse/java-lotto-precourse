/*
 * @(#)WinningLotto.java		2019/4/11
 * 
 * Copyright (c) 2019 Junmo Han.
 * All rights reserved.
 */

/**
 * WinningLotto 클래스는 구매한 로또와 당첨 로또의 숫자, 보너스 숫자가 같은지 확인합니다.
 * 
 * @version			1.00 2019년 4월 11일
 * @author 			한준모
 */

package domain;

/**
 * 당첨 번호를 담당하는 객체
 */
public class WinningLotto {
	    private final Lotto lotto;
	    private final int bonusNo;
	
	    public WinningLotto(Lotto lotto, int bonusNo) {
		        this.lotto = lotto;
		        this.bonusNo = bonusNo;
	    }
	    
	    public Rank match(Lotto userLotto) {
		        // TODO 로직 구현
		        int countOfMatch = 0;
		        boolean matchBonus;
		        
		        for (Integer number : userLotto.getNumbers()) {
		        		countOfMatch += isMatchingNumber(number);
		        }
		        matchBonus = isValidMatchingBonus(userLotto);
		        
		        return Rank.valueOf(countOfMatch, matchBonus);
	    }
	    
	    /**
		 * 구매한 로또의 번호와 당청 로또의 번호를 비교하면서 맞으면 그 수를 세기 위해
		 * 1을 아니면 0을 반환합니다.
		 */
    	private int isMatchingNumber(Integer number) {
	    		return (lotto.getNumbers().contains(number) ? 1 : 0);
    	}
    	
    	private boolean isValidMatchingBonus(Lotto userLotto) {
    			return (userLotto.getNumbers().contains(bonusNo) ? true : false);		
    	}
}
