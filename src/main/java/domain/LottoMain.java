/*
 * Class : LottoMain	(로또를 실행하는 Main 클래스)
 * 
 * Version : 1.0.0
 * 
 * 2019-4-10
 * 
 * Jeongho Park
 */

package domain;

public class LottoMain {

	public static void main(String[] args) {
		LottoMachine lotto = new LottoMachine();
		Lotto userLotto[] = lotto.buyLotto();
		CompareNums cmp = new CompareNums(userLotto);
		cmp.makeWinningLotto();
	}
}
