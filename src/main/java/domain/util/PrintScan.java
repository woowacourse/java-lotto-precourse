package domain.util;

import java.util.Scanner;

public class PrintScan {
    private static final String REQUEST_INPUT_MONEY_TEXT = "로또를 구매할 금액을 입력해 주세요. 로또는 장당 1000원 입니다";

    private static Scanner scan = new Scanner(System.in);

    public static int requesetInputMoney () {
        System.out.println(REQUEST_INPUT_MONEY_TEXT);
        return Integer.parseInt(scan.nextLine());
    }

    public static void exeptionPrint(){
        System.out.println("1,000이상 2,147,483,647미만의 숫자를 입력해 주세요");
    }


}
