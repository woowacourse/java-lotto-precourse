package validation;

public class MoneyValidation implements Validation<Integer> {
	@Override
	public boolean check(String value) {
		return false;
	}

	@Override
	public Integer convert(String value) {
		return null;
	}
}
