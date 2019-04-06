package domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class WinningMoneyTest {

    @Test
    public void getWinningMoney() {
        WinningMoney wm = new WinningMoney();
        assertEquals(5000, wm.getWinningMoney(0));
    }
}