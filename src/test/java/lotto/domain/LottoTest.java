package lotto.domain;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LottoTest {

    @Test
    public void 오름차순_정렬_테스트(){
        Lotto lotto = new Lotto(Arrays.asList(3,4,5,1,2,6));
        List<Integer> expected = Arrays.asList(1,2,3,4,5,6);

        Assert.assertEquals(expected.toString(), lotto.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_중복에러_테스트() {
        new Lotto(Arrays.asList(1,2,3,4,5,5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_사이즈에러_테스트() {
        new Lotto(Arrays.asList(1,2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호_범위에러_테스트() {
        new Lotto(Arrays.asList(1,2,3,4,5, Lotto.LOTTO_MAX_NUMBER+1));
    }

}
