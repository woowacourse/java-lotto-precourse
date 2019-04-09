package domain;

import java.util.Scanner;

/**
 * 게임의 흐름을 컨트럴하는 마스터 객체
 */
public class Controller {
    private static final int MINIMUM_MONEY = 1000;      //로또 구입할수 있는 최소 가격
    private static final int MAXIMUM_MONEY = 100000;    //로또 구입할수 있는 최대 가격
    Scanner scanner = new Scanner(System.in);

    private int money;

    public void askHowMany() {
        String inputValue;

        do {
            System.out.println("1000원 이상, 10만원 이하 구입금액을 입력해 주세요.");
            inputValue = scanner.nextLine();
        } while (!isNumber(inputValue));
    }

    /* Overflow가 일어나는지, 숫자인지 체크하는 메소드 */
    public boolean isNumber(String inputValue) {
        try {
            money = Integer.parseInt(inputValue);

            return checkInputRight();
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkInputRight() {
        return ((money >= MINIMUM_MONEY) && (money <= MAXIMUM_MONEY));
    }
}
