package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        ArrayList<Integer> nums = new ArrayList(numbers);
        Collections.sort(nums);

        var numStrs = IntStream.range(0, nums.size())
                .mapToObj(i -> Integer.toString(nums.get(i)))
                .collect(Collectors.toList());


        return "[" + String.join(",", numStrs.toArray(new String[nums.size()])) + "]";
    }

    // 추가 기능 구현
    public boolean contains(Integer num) {
        return numbers.contains(num);
    }

    public int countEqualNumbers(Lotto lotto) {
        int countOfMatch = 0;
        for (var num : numbers) {
            countOfMatch += lotto.contains(num) ? 1 : 0;
        }
        return countOfMatch;
    }
}
