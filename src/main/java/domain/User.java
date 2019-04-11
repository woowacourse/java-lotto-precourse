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
		List<Lotto> userLottos = shop.getLottos();
		
		matchLotto(winLotto, userLottos);
	}
	
	public void matchLotto(WinningLotto winLotto, List<Lotto> userLottos) {
		
		List<Rank> ranks = new ArrayList<Rank>();
		Iterator iterator = userLottos.iterator();
		while(iterator.hasNext()) {
			Lotto userLotto = (Lotto)iterator.next();
			Rank rank = winLotto.match(userLotto);
			ranks.add(rank);
		}
		System.out.println("당첨 통계");
		System.out.println("-----------");
		
		rankCount(ranks, Rank.FIFTH);
		rankCount(ranks, Rank.FOURTH);
		rankCount(ranks, Rank.THIRD);
		rankCount(ranks, Rank.SECOND);
		rankCount(ranks, Rank.FIRST);
	}
	
	public void rankCount(List<Rank> ranks, Rank target) {
		Iterator it = ranks.iterator();
		int numOfMatchs = 0;
		while(it.hasNext()) {
			Rank rank = (Rank)it.next();
			if (rank.equals(target)) {
				numOfMatchs++;
			}
		}
		System.out.printf("%d개 일치 (%d원) - %d개\n", target.getCountOfMatch(), target.getWinningMoney(), numOfMatchs);
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
