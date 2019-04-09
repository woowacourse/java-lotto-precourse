package com.molt3nrock.lotto;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Test;

public class LottoTest {

    @Test
    public void toStringLotto() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertEquals("[1, 2, 3, 4, 5, 6]", lotto.toString());
    }
}