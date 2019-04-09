/*
 * Main
 * 
 * version 1.0
 * 
 * 2019. 4. 6
 * 
 * Created by Wongeun Song
 */

package edu.yk1028;

public class Main {
	public static void main(String[] args) {
		User user = new User();
		LottoMachine lottoMachine = new LottoMachine();
		LottoGame lottoGame = new LottoGame();

		user.buyLottos(lottoMachine);
		user.printLottos();
		while(!lottoGame.generateWinningLotto());
		lottoGame.confirmWinning(user);
	}
}
