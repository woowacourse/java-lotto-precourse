package domain;
import java.util.*;

public class User {
	public void playgame() {
		
		LottoShop shop = new LottoShop();
		
		int gameCoin = getPrice();
		shop.createLotto(gameCoin);
		shop.printLotto();
		winNumInput();
		
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
	
	public void winNumInput() {
		Vaild vaild = new Vaild();
		Scanner sc = new Scanner(System.in);
		String winNum = "";
		
		do {
			System.out.println("지난 주 로또 당첨 번호를 입력해주세요.");
			winNum =  sc.nextLine();
		} while(!vaild.winNumVaild(winNum));
		System.out.println(winNum);
	}
}
