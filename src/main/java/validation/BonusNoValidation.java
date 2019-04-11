package validation;

import java.util.List;

public class BonusNoValidation implements Validation<Integer> {
	public static final int MIN_NUMBER = LottoValidation.MIN_NUMBER;
	public static final int MAX_NUMBER = LottoValidation.MAX_NUMBER;
	private List<Integer> numbers;
	private int bonusNo;

	public BonusNoValidation(List<Integer> numbers) {
		this.numbers = numbers;
	}

	@Override
	public boolean check(String value) {
		return false;
	}

	@Override
	public Integer convert(String value) {
		return null;
	}
}
