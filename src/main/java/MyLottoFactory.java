import domain.LottoFactory;

import domain.Lotto;
import domain.LottoInfo;
import domain.NumberPicker;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MyLottoFactory implements LottoFactory {

    private NumberPicker picker;

    public MyLottoFactory(NumberPicker picker) {
        this.picker = picker;
    }

    @Override
    public Lotto newLotto() {
        var nums = IntStream.range(LottoInfo.LOTTO_NUM_START, LottoInfo.LOTTO_NUM_END + 1)
                .boxed()
                .toArray(Integer[]::new);

        var pickedNums = picker.PickNums(nums, LottoInfo.LOTTO_LENGTH);

        return new Lotto(Arrays.asList(pickedNums));
    }
}


