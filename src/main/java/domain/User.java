package domain;
import java.util.*;

public class User {
	public String resultNum = "";
	public void playgame() {
		
		LottoShop shop = new LottoShop();
		
		int gameCoin = getPrice();
		shop.createLotto(gameCoin);
		shop.printLotto();
		List<Integer> winningLottoNumber = winNumInput();
		int bonus = bonusNumInput();
		
		WinningLotto winLotto = new WinningLotto(new Lotto(winningLottoNumber), bonus);
		
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
	
	public List<Integer> winNumInput() {
		Vaild vaild = new Vaild();
		Scanner sc = new Scanner(System.in);
		String winNum = "";
		
		do {
			System.out.println("지난 주 로또 당첨 번호를 입력해주세요.");
			winNum =  sc.nextLine(); // 1,2,3,4,5,6
		} while(!vaild.winNumVaild(winNum));
		
		List<Integer> numbers = new ArrayList<Integer>();
		String[] tokens = winNum.split(",");
		for (int i = 0; i < tokens.length ; i++) {
			numbers.add(Integer.parseInt(tokens[i]));
		}
		
		return numbers;
	}
	
	public int bonusNumInput() {
		Vaild vaild = new Vaild();
		Scanner sc = new Scanner(System.in);
		String bonusNum = "";
		
		do {
			System.out.println("보너스 볼의 번호를 입력해주세요.");
			bonusNum = sc.nextLine();
		} while(!vaild.bonusNumVaild(bonusNum, this.resultNum));
		return Integer.parseInt(bonusNum);
	}
}
