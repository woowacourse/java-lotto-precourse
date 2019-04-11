package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void 중복된로또숫자_입력() {
        //given
        List<Integer> lottoNumberList = Arrays.asList(1,1,2,3,4,5);

        //when
        Lotto lotto = new Lotto(lottoNumberList);
        //then
    }

    @Test
    public void 전부다른번호() {
        //given
        List<Integer> lottoNumberList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> winningLottoNumberList = Arrays.asList(7, 8, 9, 10, 11, 12);
        Lotto lotto = new Lotto(lottoNumberList);
        Lotto winningLotto = new Lotto(winningLottoNumberList);

        //when
        int matchedNumberCount = lotto.countMatchedNumber(winningLotto);

        //then
        assertThat(matchedNumberCount).isEqualTo(0);
    }

    @Test
    public void 한개일치_다섯개불일치() {
        //given
        List<Integer> lottoNumberList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> winningLottoNumberList = Arrays.asList(1, 8, 9, 10, 11, 12);
        Lotto lotto = new Lotto(lottoNumberList);
        Lotto winningLotto = new Lotto(winningLottoNumberList);

        //when
        int matchedNumberCount = lotto.countMatchedNumber(winningLotto);

        //then
        assertThat(matchedNumberCount).isEqualTo(1);
    }
}