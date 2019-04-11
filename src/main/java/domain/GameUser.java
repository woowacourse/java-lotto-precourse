package domain;

import java.util.ArrayList;
import java.util.List;

public class GameUser {
	private final int money;
	private List<Lotto> lottos;

	public GameUser(int money) {
		this.money = money;
		lottos = new ArrayList<>();
	}
}
