import domain.RandomLottoNumberGenerator;
import domain.interfaces.LottoNumberGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RandomLottoNumberGeneratorTest {
    // 난수임을 고려하여 충분히 루프를 돌게 한다.
    private static final int NUM_GENERATION_LOOP = 1000;

    private LottoNumberGenerator generator = new RandomLottoNumberGenerator();

    @Test
    public void testNumberSetGeneration() {
        List<Set<Integer>> numSets = generateNumberSets();
        for (Set<Integer> set : numSets) {
            checkNumSetRange(set);
        }
        checkBoundaryPresent(numSets);
    }

    private void checkBoundaryPresent(List<Set<Integer>> numSets) {
        boolean isMaxPresent = false;
        boolean isMinPresent = false;
        for (Set<Integer> s : numSets) {
            isMaxPresent |= s.contains(LottoNumberGenerator.LOTTO_NUM_MAX);
            isMinPresent |= s.contains(LottoNumberGenerator.LOTTO_NUM_MIN);
        }
        Assert.assertTrue(isMaxPresent);
        Assert.assertTrue(isMinPresent);
    }

    private List<Set<Integer>> generateNumberSets() {
        List<Set<Integer>> numSets = new ArrayList<>(NUM_GENERATION_LOOP);

        for (int i = 0; i < NUM_GENERATION_LOOP; i++) {
            numSets.add(generator.generateLottoNumberSet());
        }

        return numSets;
    }

    private void checkNumSetRange(Set<Integer> numSet) {
        for (int i : numSet) {
            Assert.assertTrue(i + " in Invalid Range", checkNumRange(i));
        }
    }

    private boolean checkNumRange(int n) {
        return n >= LottoNumberGenerator.LOTTO_NUM_MIN && n <= LottoNumberGenerator.LOTTO_NUM_MAX;
    }
}
