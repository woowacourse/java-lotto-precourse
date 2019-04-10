import domain.LottoFactory;

import domain.Lotto;
import domain.NumberPicker;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MyLottoFactory implements LottoFactory {
    // [LOTTO_NUM_FROM, LOTTO_NUM_TO]
    public static final int LOTTO_NUM_FROM = 1;
    public static final int LOTTO_NUM_TO = 45;
    public static final int LOTTO_LENGTH = 6;

    private NumberPicker picker;

    public MyLottoFactory(NumberPicker picker) {
        this.picker = picker;
    }

    @Override
    public Lotto newLotto() {
        var nums = IntStream.range(LOTTO_NUM_FROM, LOTTO_NUM_TO + 1)
                .boxed()
                .toArray(Integer[]::new);

        var pickedNums = picker.PickNums(nums, LOTTO_LENGTH);

        return new Lotto(Arrays.asList(pickedNums));
    }
}


