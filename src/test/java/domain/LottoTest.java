package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호에_중복된_번호가_있을_경우_예외처리() {
        List<Integer> numbers = Arrays.asList(1, 1, 2, 3, 4, 5);
        new Lotto(numbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호가_5개일_경우_예외처리() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        new Lotto(numbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호에_0이_있을_경우_예외처리() {
        List<Integer> numbers = Arrays.asList(0, 2, 3, 4, 5, 6);
        new Lotto(numbers);
    }
}