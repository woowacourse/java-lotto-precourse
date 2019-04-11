/*
 * @(#)Playgame.java	1.8.0_191 2019/04/11
 * 
 * Copyright (c) 2019 Youngbae Son
 * ComputerScience, ProgrammingLanguage, Java, Busan, KOREA
 * All rights reserved.
 * 
 * */
package domain;

import java.util.ArrayList;
import java.util.List;
/*
 * 게임전체를 운영하는 클래스
 * 
 * */
public class Playgame {

	public static void main(String[] args) {

		/* 사용자의 구입금액,구입금액, 로또번호, 당첨통계 차트표 */
		Playerinfo player = new Playerinfo();
		playerInit(player);

		/* 지난주 당첨번호를 입력 */
		WinningLotto winningLotto = null;
		winningLotto = WinngLottoInit(winningLotto);

		gamePlay(player, winningLotto);
		
		printWinningchart((double) player.getPrizeMoney() / (double) player.getBuyMoney(), player);

	}

	private static void gamePlay(Playerinfo player, WinningLotto winningLotto) {

		/*구입금액 만큼 만들어진 로또와 지난 주 당첨번호를 비료*/
		for (int i = 0; i < player.getBuyMoney() / 1000; i++) {

			Rank rank = winningLotto.match(player.getMyLottoList().get(i));
			checkWinningNumChart(rank, player);
			player.setPrizeMoney(rank.getWinningMoney());
		}
	}

	private static void checkWinningNumChart(Rank rank, Playerinfo player) {

		if (rank.getWinningMoney() == 5000)
			player.setWinningNumChart(4);
		if (rank.getWinningMoney() == 50000)
			player.setWinningNumChart(3);
		if (rank.getWinningMoney() == 1500000)
			player.setWinningNumChart(2);
		if (rank.getWinningMoney() == 30000000)
			player.setWinningNumChart(1);
		if (rank.getWinningMoney() == 2000000000)
			player.setWinningNumChart(0);
	}

	private static void printWinningchart(double result, Playerinfo player) {

		System.out.println("당첨통계");
		System.out.println("---------");
		System.out.println("3개일치 (5000원)- " + player.getWinningNumChart(4) + "개");
		System.out.println("4개일치 (50000원)- " + player.getWinningNumChart(3) + "개");
		System.out.println("5개일치 (1500000원)- " + player.getWinningNumChart(2) + "개");
		System.out.println("5개일치,보너스 볼 일치 (30000000원)- " + player.getWinningNumChart(1) + "개");
		System.out.println("6개일치 (2000000000원)- " + player.getWinningNumChart(0) + "개");
		System.out.println("총 수익률은 " + result + "입니다.");
	}

	private static void playerInit(Playerinfo player) {

		while (!player.inputOfBuymoney());
	}

	private static WinningLotto WinngLottoInit(WinningLotto winningLotto) {

		Winninginput winningInput = new Winninginput();

		while (!winningInput.inputOfLastWeekendLotto());

		while (!winningInput.inputOfBonusNumber());

		return winningLotto = new WinningLotto(new Lotto(winningInput.getNumbers()), winningInput.getBonusNum());

	}

}
