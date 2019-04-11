package domain;

/**
 * @version 1.00 2019/04/11
 * @author 조재훈
 */
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
