package domain;

public class LottoGame {
	
	private LottoShop lottoShop;
	private LottoBank lottoBank;
	
	public LottoGame() {
		lottoShop = new LottoShop();
		lottoBank = new LottoBank(lottoShop);
	}

	public void init() {
		lottoShop.setNumOfLotto();
		lottoShop.buyLotto();
		
		lottoBank.setWinningLotto();
		lottoBank.matchUserLotto();
		lottoBank.calUserProfit();
	}
}
