import domain.MoneyReader;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MoneyReaderFromUser implements MoneyReader {
    private static final int INVALID = -1;

    private Scanner sc;

    public MoneyReaderFromUser() {
        this.sc = new Scanner(System.in);
    }

    @Override
    public int readMoney() {
        var money = _readInt();

        while (!isValidMoney(money)) {
            System.out.println("잘못된 입력입니다. 음 아닌 정수를 입력해주세요");
            money = _readInt();
        }
        return money;
    }

    private boolean isValidMoney(int money) {
        return INVALID < money;
    }

    private int _readInt() {
        System.out.println("구입금액을 입력해 주세요.");
        int num = INVALID;

        try {
            num = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.printf("got: \n" + sc.nextLine());
        }
        return num;
    }
}
