package com.github.seokhyeonchoi.game;

import com.github.seokhyeonchoi.game.lotto.LottoGame;

/**
 * main method
 */
public class Main {
	public static void main(String[] args) {
		Game lottoGame = new LottoGame();
		
		lottoGame.start();
	}
}
