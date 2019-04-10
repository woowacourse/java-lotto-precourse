package domain;

import java.util.Scanner;

public class GameController {

    private static final int lottoPrice = 1000;

    public void startGame(){
        Scanner scanner = new Scanner(System.in);
        int numberOfPrice = purchasePrice(scanner);

        System.out.println("구입개수 : " + numberOfPrice + "개");
    }

    private int purchasePrice(Scanner scanner){
        System.out.println("구입 금액을 입력해 주세요.");

        return (scanner.nextInt())/lottoPrice;
    }

}
