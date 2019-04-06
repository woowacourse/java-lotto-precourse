package domain;

import java.util.Scanner;

public class Display {

    Scanner sc;

    public Display(){
        sc = new Scanner(System.in);
    }

    int inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        int money = sc.nextInt();
        int numbersOfLottoes = money / 1000;
        return numbersOfLottoes;
    }
}
