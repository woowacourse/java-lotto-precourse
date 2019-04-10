import domain.MoneyReader;

import java.util.Scanner;

public class MoneyReaderFromUser implements MoneyReader {

    private Scanner sc;

    public MoneyReaderFromUser() {
        this.sc = new Scanner(System.in);
    }
    @Override
    public int readMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        // [TODO] check input is valid
        return sc.nextInt();
    }
}
