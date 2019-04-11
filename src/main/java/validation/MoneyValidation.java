package validation;

public class MoneyValidation implements Validation<Integer> {
	public static final int MONEY_UNIT = 1_000;
	public static final int MIN_MONEY = 1_000;
	public static final int MAX_MONEY = 100_000;
	private int money;

	@Override
	public boolean check(String value) {
		return false;
	}

	private boolean checkInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			System.out.println("정수가 아닙니다.\n");
			return false;
		}
	}

	private boolean checkRange() {
		if ((money < MIN_MONEY) || (money > MAX_MONEY)) {
			System.out.println(String.format("금액의 범위는 최소 %,d원, 최대 %,d원 입니다.\n", MIN_MONEY, MAX_MONEY);
			return false;
		}

		return true;
	}

	private boolean checkUnit() {
		if (money % MONEY_UNIT != 0) {
			System.out.println(String.format("금액의 단위는 %,d원 입니다.\n", MONEY_UNIT);
			return false;
		}

		return true;
	}

	@Override
	public Integer convert(String value) {
		return null;
	}
}
