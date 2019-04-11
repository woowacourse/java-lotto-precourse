/*
 * @(#)WinningLotto.java	1.8.0_191 2019/04/11
 * 
 * Copyright (c) 2019 Youngbae Son
 * ComputerScience, ProgrammingLanguage, Java, Busan, KOREA
 * All rights reserved.
 * 
 * */
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
	
	/*사용자가 만든 로또 번호와 당첨번호를 비교한다
	 * 일치하는 갯수 count, 보너스 번호 일치 matchBonus
	 * Rank valueOf(count, matchBonus)에서 당첨 등수를 찾는다
	 * */
	public Rank match(Lotto userLotto) {

		int count = 0;
		boolean matchBonus = false;
		for (int i = 0; i < userLotto.getNumbers().size()-1; i++) {
			if ( this.lotto.getNumbers().get(i) == userLotto.getNumbers().get(i) ) {
				count++;
			}
		}
		
		if ( this.bonusNo == userLotto.getNumbers().get(5) ) {
			count++;
			matchBonus = true;
		}
			
		return Rank.valueOf(count, matchBonus);
	}

	public Lotto getLotto() {
		return lotto;
	}

	public int getBonusNo() {
		return bonusNo;
	}

}
