package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * GameUser 객체는 돈과 구매한 로또를 소유한다.
 *
 * @author 조남균
 */
public class GameUser {
	private final int money;
	private List<Lotto> lottos;

	public GameUser(int money) {
		this.money = money;
		lottos = new ArrayList<>();
	}

	public void addLotto(Lotto lotto) {
		lottos.add(lotto);
	}

	public int countOfLotto() {
		return lottos.size();
	}

	public Lotto getLotto(int index) {
		return lottos.get(index);
	}

	public int getMoney() {
		return money;
	}
}
