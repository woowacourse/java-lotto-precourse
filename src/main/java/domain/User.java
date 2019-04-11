package domain;
import java.util.*;

public class User {
	public void playgame() {
		int gameCoin = getPrice();
		LottoShop shop = new LottoShop();
		shop.createLotto(gameCoin);
		shop.printLotto();
		
	}
	
	public int getPrice() {
		Vaild vaild = new Vaild();
		String money = "";
		
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("구매금액을 입력해주세요.");
			money = sc.nextLine();
		} while(!vaild.priceVaild(money));
		
		return Integer.parseInt(money) / 1000;
	}
}
