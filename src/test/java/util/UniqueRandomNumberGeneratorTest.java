package util;

import org.junit.Test;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author delf
 */
public class UniqueRandomNumberGeneratorTest {

    @Test
    public void 조건에_맞는_난수를_반환한다() {
        int size = 6;
        int max = 45;
        int min = 1;
        int test = 100;

        for (int i = 0; i < test; i++) {
            @SuppressWarnings("unchecked")
            Set<Integer> set = UniqueRandomNumberGenerator.getUniqueNumbers(size, min, max);
            assertThat(set.size()).isEqualTo(size);
            for (int n : set) {
                assertThat(n).isBetween(min, max);
            }
        }
    }
}