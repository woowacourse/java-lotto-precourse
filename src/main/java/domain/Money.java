package domain;

public class Money {

	private int money;
	private int lottoCount;

	public Money(int money, int lottoCount) {
		this.money = money;
		this.lottoCount = lottoCount;
	}

	public int getMoney() {
		return this.money;
	}

	public int getLottoCount() {
		return this.lottoCount;
	}

}
