package domain;

public class LottoMain {

	public static void main(String[] args) {
		LottoMachine lotto = new LottoMachine();
		CompareNums cmp = new CompareNums();
		lotto.buyLotto();
		cmp.makeWinningLotto();
	}
}
