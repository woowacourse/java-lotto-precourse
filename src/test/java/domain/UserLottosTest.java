package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserLottosTest {

    @Test(expected = NumberFormatException.class)
    public void constructorExceptionTest() {
        int count = Util.divideThousand(Util.fromStringToInteger("만원"));
        UserLottos userLottos = new UserLottos(count);
    }

    @Test
    public void constructorTest() {
        int count = Util.divideThousand(Util.fromStringToInteger("3000"));
        UserLottos userLottos = new UserLottos(count);
        assertEquals(3,userLottos.getUserLottosCount());

        count = Util.divideThousand(Util.fromStringToInteger("10000"));
        UserLottos userLottos1 = new UserLottos(count);
        assertEquals(10, userLottos1.getUserLottosCount());

        count = Util.divideThousand(Util.fromStringToInteger("1100"));
        UserLottos userLottos2 = new UserLottos(count);
        assertEquals(1, userLottos2.getUserLottosCount());
    }

}