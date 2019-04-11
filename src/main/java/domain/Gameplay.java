package domain;

public class Gameplay {

	public void runPrompt() {
		int gameMoney = User.inputUserMoney();
		User.buyLotto(gameMoney);
		User.printBoughtLottoList();
		User.makeNumberListOfLastWeek();
		User.compareWithWinningLotto();
		User.printTotalResult(gameMoney);
	}
}