package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class WinningMoneyTest {

    @Test
    public void setCountMoney() {
        WinningMoney wm = new WinningMoney();
        assertEquals(2, wm.setCountMoney(5000));
    }
}