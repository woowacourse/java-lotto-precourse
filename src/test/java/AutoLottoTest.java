import domain.AutoLotto;
import org.junit.Test;

import static org.junit.Assert.*;

public class AutoLottoTest {

    @Test
    public void makeAutoNumber() {
        AutoLotto al = new AutoLotto();
        assertEquals(52, al.makeAutoNumber());
    }
}