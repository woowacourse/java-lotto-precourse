import domain.NumberPicker;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class MyLottoFactoryTest {

    private MyLottoFactory factory;
    private NumberPicker mockedPicker;

    @org.junit.Test
    public void newLottoPickValidLength() {
        mockedPicker = mock(NumberPickerByShuffling.class);
        when(mockedPicker.PickNums(any(Integer[].class), eq(factory.LOTTO_LENGTH)))
                .thenReturn(new Integer[factory.LOTTO_LENGTH]);

        factory = new MyLottoFactory(mockedPicker);

        // Act
        factory.newLotto();

        // Assert
        verify(mockedPicker).PickNums(any(Integer[].class), eq(factory.LOTTO_LENGTH));
    }
}