package domain.util;

import java.util.Scanner;

public class PrintScan {
    private static Scanner scan = new Scanner(System.in);

    public static int requesetInputMoney () {
        System.out.format("로또를 구매할 금액을 입력해 주세요. 로또는 장당 %d원 입니다.%n",Input.MIN_INPUT_MONEY);
        return Integer.parseInt(scan.nextLine());
    }

    public static void printOutofRangeNotice(){
        System.out.format("%d이상 %d이하의 숫자를 입력해 주세요.%n",Input.MIN_INPUT_MONEY,Input.MAX_INPUT_MONEY);
    }

    public static void printRestMoney(int restMoney){
        System.out.format("%d원의 거스름돈이 남았습니다.%n",restMoney);
    }


}
