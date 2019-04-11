package domain;
import java.util.*;

public class LottoShop {
	
	private List<Lotto> lottos = new ArrayList<Lotto>();
	public void createLotto(int ticketNum) {
		
		for(int i = 0; i < ticketNum; i++) {
			 lottos.add(Lotto.create());
		}
	}
	
	public void printLotto() {
		for (Lotto lotto : lottos) {
			System.out.println(lotto.getNumbers().toString());
		}
	}
	
	public List<Lotto> getLottos() {
		return this.lottos;
	}
}