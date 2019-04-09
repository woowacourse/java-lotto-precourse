package domain;

import java.util.Scanner;

public class Inputter {
    private static Scanner scan = new Scanner(System.in);

    public int inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        int money = scan.nextInt();
        return money / 1000;
    }

    public String inputWinningNumber(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scan.nextLine();
    }

    public int inputBonusNumber(){
        System.out.println("보너스 볼을 입력해 주세요.");
        return scan.nextInt();
    }
}
