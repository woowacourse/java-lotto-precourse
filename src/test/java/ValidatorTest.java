/*
 *  클래스 이름 : ValidatorTest.java
 *
 *  버전 정보 : 1.0.0
 *
 *  날짜 : 2019-04-07
 *
 *  저작권 : 이예지
 */

import java.util.Arrays;
import java.util.List;

import com.woowacourse.lotto.domain.Lotto;
import com.woowacourse.lotto.util.Validator;
import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest {
	@Test
	public void checkPurchasingAmountValid_빈문자입력() {
		String amount = "";
		Assert.assertFalse(Validator.checkPurchasingAmountValid(amount));
	}

	@Test
	public void checkPurchasingAmountValid_공백입력() {
		String amount = " ";
		Assert.assertFalse(Validator.checkPurchasingAmountValid(amount));
	}

	@Test
	public void checkPurchasingAmountValid_문자입력() {
		String amount = "천원";
		Assert.assertFalse(Validator.checkPurchasingAmountValid(amount));
	}

	@Test
	public void checkPurchasingAmountValid_1000원미만입력() {
		String amount = "100";
		Assert.assertFalse(Validator.checkPurchasingAmountValid(amount));
	}

	@Test
	public void checkPurchasingAmountValid_정상작동() {
		String amount = "1000";
		Assert.assertTrue(Validator.checkPurchasingAmountValid(amount));
	}

	@Test
	public void checkOverlapNumberValid_중복존재() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		Assert.assertFalse(Validator.checkOverlapNumber(1, list));
	}

	@Test
	public void checkOverlapNumberValid_정상작동() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		Assert.assertTrue(Validator.checkOverlapNumber(5, list));
	}

	@Test
	public void checkWinningNumberListValid_7자리이상() {
		List<String> list = Arrays.asList("1", "2", "3", "4", "5", "6", "7");
		Assert.assertFalse(Validator.checkWinningNumberListValid(list));
	}

	@Test
	public void checkWinningNumberListValid_6자리미만() {
		List<String> list = Arrays.asList("1", "2", "3", "4", "5");
		Assert.assertFalse(Validator.checkWinningNumberListValid(list));
	}

	@Test
	public void checkOverlapNumberList_중복존재() {
		List<String> list = Arrays.asList("1,2,3,4,5,5".split(","));
		Assert.assertFalse(Validator.checkOverlapNumberList(list));
	}

	@Test
	public void checkOverlapNumberList_정상작동() {
		List<String> list = Arrays.asList("1,2,3,4,5,6".split(","));
		Assert.assertTrue(Validator.checkOverlapNumberList(list));
	}

	@Test
	public void checkRangeLottoNumber_문자입력() {
		Assert.assertFalse(Validator.checkRangeLottoNumber("a"));
	}

	@Test
	public void checkRangeLottoNumber_빈문자입력() {
		Assert.assertFalse(Validator.checkRangeLottoNumber(""));
	}

	@Test
	public void checkRangeLottoNumber_공백입력() {
		Assert.assertFalse(Validator.checkRangeLottoNumber(" "));
	}

	@Test
	public void checkRangeLottoNumber_범위에서벗어난숫자입력() {
		Assert.assertFalse(Validator.checkRangeLottoNumber("0"));
		Assert.assertFalse(Validator.checkRangeLottoNumber("46"));
	}

	@Test
	public void checkRangeLottoNumber_정상작동() {
		Assert.assertTrue(Validator.checkRangeLottoNumber("1"));
		Assert.assertTrue(Validator.checkRangeLottoNumber("45"));
	}

	@Test
	public void checkWinningBonusBallValid_당첨번호와중복되는숫자입력() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		Assert.assertFalse(Validator.checkWinningBonusBallValid("5", new Lotto(list)));
	}

	@Test
	public void checkWinningBonusBallValid_정상작동() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		Assert.assertTrue(Validator.checkWinningBonusBallValid("45", new Lotto(list)));
	}
}
