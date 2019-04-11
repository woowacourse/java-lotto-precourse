package domain;

import com.sun.source.tree.AssertTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class LottoTest {
    private static final int LOTTO_NUM_START = 1;
    private static final int LOTTO_NUM_END = 45;

    @Test
    public void containsValids() {
        List<List<Integer>> numsList = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(6, 5, 4, 3, 2, 1),
                Arrays.asList(10, 20, 30, 40, 41, 45),
                Arrays.asList(40, 30, 41, 45, 20, 10)
        );

        for (var nums : numsList) {
            var lotto = new Lotto(nums);

            // Act & Assert
            nums.forEach((num) -> {
                Assert.assertTrue(lotto.contains(num));
            });
        }
    }

    @Test
    public void containsInvalids() {
        List<List<Integer>> numsList = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(6, 5, 4, 3, 2, 1),
                Arrays.asList(10, 20, 30, 40, 41, 45),
                Arrays.asList(40, 30, 41, 45, 20, 10)
        );

        for (var nums : numsList) {
            var lotto = new Lotto(nums);

            // Act & Assert
            IntStream.range(LOTTO_NUM_START, LOTTO_NUM_END).forEach((num) -> {
                if (nums.contains(num)) {
                    return;
                }
                Assert.assertFalse(lotto.contains(num));
            });
        }
    }

    @Test
    public void countEqualNumbers() {
        List<List<Integer>> numsList = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(6, 5, 4, 3, 2, 1),
                Arrays.asList(10, 20, 30, 40, 41, 45),
                Arrays.asList(40, 30, 41, 45, 20, 10)
        );
        List<Lotto> lottosForCompare = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(6, 5, 4, 3, 2, 1)),
                new Lotto(Arrays.asList(10, 20, 30, 40, 41, 45)),

                new Lotto(Arrays.asList(2, 3, 10, 30, 41, 45)),
                new Lotto(Arrays.asList(31, 32, 33, 34, 35, 36))
        );
        List<List<Integer>> wantsList = Arrays.asList(
                Arrays.asList(6, 6, 0, 2, 0),
                Arrays.asList(6, 6, 0, 2, 0),
                Arrays.asList(0, 0, 6, 4, 0),
                Arrays.asList(0, 0, 6, 4, 0)
        );

        for (int i = 0; i < numsList.size(); i++) {
            var lottoA = new Lotto(numsList.get(i));

            // Act & Assert
            for (int j = 0; j < lottosForCompare.size(); j++) {
                var lottoB = lottosForCompare.get(j);

                Integer got = lottoA.countEqualNumbers(lottoB);
                Assert.assertEquals(wantsList.get(i).get(j), got);
            }
        }
    }
}