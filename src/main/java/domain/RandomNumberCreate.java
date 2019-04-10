package domain;

import java.util.*;

public class RandomNumberCreate {

    private static Random RAND = new Random();
    static Set<Integer> random_Number_Create_Set = new TreeSet<>();
    static List<Integer> lotto_Rand_Numbers;

    static Set<Integer> randNumber_Create() {
        for (; random_Number_Create_Set.size() < Info.LOTTO_NUMBER_MAX_LENGTH; ) {
            random_Number_Create_Set.add(RAND.nextInt(Info.LOTTO_NUMBER_MAX_VALUE) + Info.LOTTO_NUMBer_MIN_VALUE);
        }
        return random_Number_Create_Set;
    }

    static List<Integer> set_Change_List() {
        lotto_Rand_Numbers = new ArrayList<>();
        lotto_Rand_Numbers.addAll(randNumber_Create());
        return lotto_Rand_Numbers;
    }

    static void random_Set_Number_Reset() {
        for (Iterator<Integer> iter = random_Number_Create_Set.iterator(); iter.hasNext(); ) {
            iter.next();
            iter.remove();
        }
    }
}
