package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserLottosTest {

    @Test(expected = NumberFormatException.class)
    public void constructorExceptionTest() {
        UserLottos userLottosInvalidArgs = new UserLottos("만원");
    }

//    @Test
//    public void constructorTest() {
//        UserLottos userLottos = new UserLottos("3000");
//        assertEquals(3,userLottos.getUserLottosCount());
//
//        UserLottos userLottos1 = new UserLottos("1000000");
//        assertEquals(1000, userLottos1.getUserLottosCount());
//
//        UserLottos userLottos2 = new UserLottos("1100");
//        assertEquals(1,userLottos2.getUserLottosCount());
//    }
}