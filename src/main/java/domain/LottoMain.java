package domain;

public class LottoMain {

	public static void main(String[] args) {
		LottoMachine lotto = new LottoMachine();
		Lotto userLotto[] = lotto.buyLotto();
		CompareNums cmp = new CompareNums(userLotto);
		cmp.makeWinningLotto();
	}
}
