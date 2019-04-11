package validation;

import java.util.List;

/**
 * BonusNoValidation 객체는 보너스 볼 데이터 검증을 담당한다.
 *
 * @author 조남균
 */
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
		if (!checkInteger(value)) {
			return false;
		}

		this.bonusNo = convert(value);

		return checkRange() && checkContains();
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

		if ((bonusNo < MIN_NUMBER) || (bonusNo > MAX_NUMBER)) {
			System.out.println(String.format("보너스 볼의 범위는 최소 %d, 최대 %d 입니다.\n", MIN_NUMBER, MAX_NUMBER));
			return false;
		}

		return true;
	}

	private boolean checkContains() {
		if (numbers.contains(bonusNo)) {
			System.out.println("당첨번호에 존재하는 숫자입니다.\n");
			return false;
		}

		return true;
	}

	@Override
	public Integer convert(String value) {
		return Integer.parseInt(value);
	}
}
