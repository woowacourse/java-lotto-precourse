/*
 * @(#)InputErrorTest.java
 * v2.0
 * 2019/04/11
 */

package com.codemcd.lotto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 로또 게임 입력 테스트
 *
 * @author 박성범
 * @version v2.0
 */
public class InputErrorTest {

    @Test
    public void isRightNumberOfComma_올바른_입력() {
        String input = "1,2,3,4,5,6";

        boolean isValid = InputError.isRightNumberOfComma(input);

        assertThat(isValid).isTrue();
    }

    @Test
    public void isRightNumberOfComma_쉼표_6개이상() {
        String input = "1,2,3,4,5,,6";

        boolean isValid = InputError.isRightNumberOfComma(input);

        assertThat(isValid).isFalse();
    }

    @Test
    public void isRightNumberOfComma_쉼표_4개이하() {
        String input = "1,2,3,4,6";

        boolean isValid = InputError.isRightNumberOfComma(input);

        assertThat(isValid).isFalse();
    }

    @Test
    public void isRightNumberOfRange_45보다_큰_수() {
        String input = "46";

        boolean isValid = InputError.isRightNumberOfRange(input);

        assertThat(isValid).isFalse();
    }

    @Test
    public void isRightNumberOfRange_음수() {
        String input = "-2";

        boolean isValid = InputError.isRightNumberOfRange(input);

        assertThat(isValid).isFalse();
    }

    @Test
    public void isOverlapNumber_중복된_로또_번호() {
        String input = "1,2,3,4,6,6";

        boolean isValid = InputError.isOverlapNumber(input);

        assertThat(isValid).isFalse();
    }

    @Test
    public void isOverlapNumber_정상적인_로또_번호() {
        String input = "1,11,21,31,41,33";

        boolean isValid = InputError.isOverlapNumber(input);

        assertThat(isValid).isTrue();
    }

    @Test
    public void isMinimumPrice_1000원보다_작은_금액() {
        String input = "900";

        boolean isValid = InputError.isMinimumPrice(input);

        assertThat(isValid).isFalse();
    }

    @Test
    public void isNaturalNumber_0으로_시작하는_수() {
        String input = "01000";

        boolean isValid = InputError.isNaturalNumber(input);

        assertThat(isValid).isFalse();
    }

    @Test
    public void isNumeric_숫자가_아닌_입력() {
        String input = "abcd";

        boolean isValid = InputError.isNumeric(input);

        assertThat(isValid).isFalse();
    }
}