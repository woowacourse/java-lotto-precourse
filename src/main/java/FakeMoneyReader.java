import domain.MoneyReader;

import java.util.Scanner;

public class FakeMoneyReader implements MoneyReader {
    @Override
    public int readMoney() {
        System.out.println("readMoney called");
        return 10000;
    }
}
