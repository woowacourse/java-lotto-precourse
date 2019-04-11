package domain;

/**
 * 게임을 실행하는 클래스
 */
public class Main {

	/* 게임이 실행되는 공간 */
	public static void main(String[] args) {
		LottoMarket lottoMarket = new LottoMarket();
		WinningLottoMaker winningLottoMaker = new WinningLottoMaker();
		lottoMarket.purchaseLotto();

		LottoOffice lottoOffice = new LottoOffice(winningLottoMaker.makeWinningLotto(), lottoMarket.getLottoList());
		lottoOffice.printRankStats();
		lottoOffice.printEarningRate(lottoMarket.getPurchasePrice());
	}
}
