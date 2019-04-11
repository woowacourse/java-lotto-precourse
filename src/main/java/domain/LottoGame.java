package domain;

public class LottoGame {
	private int numberOfPurchase; 
	private static final int LOTTO_CHARGE = 1000;
	
	public void printNumberOfPurchase(int purchaseAmount) {
		numberOfPurchase = purchaseAmount/LOTTO_CHARGE;
		System.out.println("\n"+numberOfPurchase+"개를 구매했습니다.");
	}
	
	public static void main(String[] args) {
		LottoGame game = new LottoGame();
		UserInput user = new UserInput();
		int purchaseAmount;
		
		purchaseAmount = user.InputPurchaseAmount();
		game.printNumberOfPurchase(purchaseAmount);
		
	}
}
