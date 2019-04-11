/*
 * @(#)Playerinfo.java	1.8.0_191 2019/04/11
 * 
 * Copyright (c) 2019 Youngbae Son
 * ComputerScience, ProgrammingLanguage, Java, Busan, KOREA
 * All rights reserved.
 * 
 * */
package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 사용자에 대한 정보
 * 구입금액, 로또번호, 당첨통계
 * 
 * 구입금액을 입력받고(예외처리)
 * 로또번호(난수로 생성하고)
 * 당첨통계 차트표
 * */

public class Playerinfo {

	/*구입 금액 만틈 로또가 담겨질 리스트*/
	private List<Lotto> myLottoList;
	/*구입금액*/
	private int buyMoney;
	/*당첨통계차트*/
	private int winningNumChart[];
	/*총 당첨 금액 */
	private	int prizeMoney;
	
	public Playerinfo() {	
		this.myLottoList = new ArrayList<>();
		this.winningNumChart = new int[5];
	}

	public boolean inputOfBuymoney() {

		Scanner scan = new Scanner(System.in);
		System.out.println("구입금액을 입력해 주세요.");
		String buyMoney = scan.nextLine();

		if (checkInputMoney(buyMoney)) {
			createOfmyLotto();
			return true;
		}

		return false;
	}

	public void createOfmyLotto() {

		for (int i = 0; i < buyMoney/1000; i++)
			writeLottoNumber(createRandomNumber());

	}

	private void writeLottoNumber(int[] createRandomNumber) {

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < createRandomNumber.length; i++)
			list.add(createRandomNumber[i]);

		Lotto lotto = new Lotto(list);
		lotto.sort();
		lotto.printLotto();

		this.myLottoList.add(lotto);

	}

	private int[] createRandomNumber() {

		int loopCount = 0;
		int[] number = new int[6];
		boolean[] visit = new boolean[46];
		
		while (loopCount < 6) {

			int lottoNumber = (int) (Math.random() * 100) % 46;

			if (lottoNumber == 0 || visit[lottoNumber])
				continue;

			number[loopCount] = lottoNumber;
			visit[lottoNumber] = true;
			loopCount++;
		}

		return number;
	}

	private boolean checkInputMoney(String buyMoney) {

		int number = 0;
		try {
			number = Integer.parseInt(buyMoney);
			if (number < 1000)
				return false;
		} catch (Exception e) {
			return false;
		}
		
		this.buyMoney = number;
		return true;
	}

	private String[] split(String inputWinningLotto) {

		String[] winningLotto = inputWinningLotto.split(",");
		return winningLotto;

	}
	
	public List<Lotto> getMyLottoList() {
		return myLottoList;
	}

	public int getBuyMoney() {
		return buyMoney;
	}

	public int getPrizeMoney() {
		return prizeMoney;
	}

	public void setPrizeMoney(int prizeMoney) {
		this.prizeMoney = prizeMoney;
	}
	
	public int getWinningNumChart(int index) {
		return winningNumChart[index];
	}

	public void setWinningNumChart(int index) {
		this.winningNumChart[index] += 1;
	}
}
