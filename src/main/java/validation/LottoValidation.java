package validation;

import java.util.List;

public class LottoValidation implements Validation<List<Integer>> {
	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 45;
	public static final int NUMBER_CNT = 6;
	private static final String REGULAR_EXPRESSION = "^([0-9]+)(,[0-9]+){5}$";
	private static final String SEPARATOR = ",";
	private List<Integer> numbers;

	@Override
	public boolean check(String value) {
		return false;
	}

	private boolean checkList(String value) {
		if (!value.matches(REGULAR_EXPRESSION)) {
			System.out.println("입력 형식을 맞춰주세요.");
			return false;
		}

		return true;
	}

	private boolean checkCountNumbers() {
		if (numbers.size() != NUMBER_CNT) {
			System.out.println("6개 숫자를 입력해야 합니다.");
			return false;
		}

		return true;
	}

	@Override
	public List<Integer> convert(String value) {
		return null;
	}
}
