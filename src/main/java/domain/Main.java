/*
 * @(#)Main.java		2019/4/11
 * 
 * Copyright (c) 2019 Junmo Han.
 * All rights reserved.
 */

/**
 * Main 클래스는 로또 게임을 실행하는 기능을 합니다. 
 * 
 * @version			1.00 2019년 4월 11일
 * @author 			한준모
 */

package domain;

public class Main {
		public static void main(String[] args) {
				LottoGame game = new LottoGame();
				game.runGame();
		}
}
