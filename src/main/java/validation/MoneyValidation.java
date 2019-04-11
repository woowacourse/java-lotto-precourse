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
			System.out.println( "정수가 아닙니다.\n");
			return false;
		}
	}

	@Override
	public Integer convert(String value) {
		return null;
	}
}
