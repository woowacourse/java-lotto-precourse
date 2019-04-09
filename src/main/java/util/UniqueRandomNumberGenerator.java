package util;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author delf
 */
public class UniqueRandomNumberGenerator {
    public static final Random r = new Random();
    public static Set getUniqueNumbers(int n, int min, int max) {
        Set<Integer> set = new LinkedHashSet<>();
        while (set.size() < n) {
            set.add(r.nextInt(max - min) + min);
        }

        return set;
    }
}
