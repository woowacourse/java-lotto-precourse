import domain.NumberPicker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class NumberPickerByShufflingTest {

    private static final int NUM_PICKED = 6;

    private NumberPickerByShuffling picker;

    @Before
    public void setUp() throws Exception {
        picker = new NumberPickerByShuffling(new Random());
    }

    // 원하는 갯수만큼 뽑았는지
    // 중복 없이 뽑았는지 (입력 받은 갯수를 초과해서 뽑지 않도록)

    @Test
    public void pickNumsWithVariousNumPicked() {
        var nums = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        var pickedNums = new int[]{0, 1, 3, 5, 7, 10};

        for (var numPicked : pickedNums) {
            // Act
            var got = picker.PickNums(nums, numPicked);

            // Assert
            Assert.assertEquals(numPicked, got.length);
        }
    }

    @Test
    public void pickNumsNonDuplicatedNums() {
        var nums = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int n = 100;

        IntStream.range(0, n).forEach((i) -> {
            // Act
            var picked = picker.PickNums(nums, NUM_PICKED);
            var counter = initCounter(picked);

            Assert.assertEquals(NUM_PICKED, counter.size());
        });
    }

    @Test
    public void pickNumsNonDuplicatedNumsPickValidNum() {
        var nums = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        var counter = initCounter(nums);

        int n = 100;

        IntStream.range(0, n).forEach((i) -> {
            // Act
            var picked = picker.PickNums(nums, NUM_PICKED);
            var pickedCounter = initCounter(picked);

            // Assert
            for(var pickedNum : pickedCounter.keySet()) {
                Assert.assertTrue(counter.containsKey(pickedNum));
            }
        });
    }


    @Test
    public void pickNumsDuplicatedNums() {
        var nums = new Integer[]{1, 2, 2, 2, 2, 4, 4, 5, 9, 9, 9, 9, 9, 9, 10, 81, 100};
        var counter = initCounter(nums);

        int n = 100;

        IntStream.range(0, n).forEach((i) -> {
            // Act
            var picked = picker.PickNums(nums, NUM_PICKED);
            System.out.println(Arrays.toString(picked));
            var pickedCounter = initCounter(picked);

            // Assert
            for(var pickedNum : pickedCounter.keySet()) {
                Assert.assertTrue(counter.containsKey(pickedNum));
                Assert.assertTrue(pickedCounter.get(pickedNum) <= counter.get(pickedNum));
            }
        });
    }

    private HashMap<Integer, Integer> initCounter(Integer[] nums) {
        var counter = new HashMap<Integer, Integer>();
        for (var num : nums) {
            if (counter.containsKey(num)) {
                counter.put(num, counter.get(num) + 1);
                continue;
            }
            counter.put(num, 1);
        }

        return counter;
    }
}