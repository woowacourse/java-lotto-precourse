import domain.NumberPicker;

import java.util.Random;
import java.util.stream.IntStream;

public class NumberPickerByShuffling implements NumberPicker {

    private Random rand;

    public NumberPickerByShuffling(Random rand) {
        this.rand = rand;
    }

    @Override
    public Integer[] PickNums(Integer[] nums, int numPicked) {
        var shuffledIdxs = initShuffledIdxs(nums.length);

        return IntStream.range(0, numPicked)
                .map((i) -> nums[shuffledIdxs[i]])
                .boxed()
                .toArray(Integer[]::new);
    }

    private int[] initShuffledIdxs(int length) {
        var idxs = IntStream.range(0, length).toArray();

        IntStream.range(0, length).forEach((from) -> {
            int to = rand.nextInt(length);
            _swap(idxs, from, to);
        });

        return idxs;
    }

    private void _swap(int[] nums, int from, int to) {
        int tmp = nums[from];
        nums[from] = nums[to];
        nums[to] = tmp;
    }
}
