package domain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Shop {
    Scanner scan = new Scanner(System.in);
    private int INITIAL_PRICE = 0;

    public int inputPrice() {
        int price = checkInputPrice(INITIAL_PRICE);
        return price;
    }

    public int checkInputPrice(int price) {
        try {
            int signedprice = scan.nextInt();
            price = checkMinusPrice(signedprice);
            return price;
        } catch (InputMismatchException e) {
            System.out.println("유효하지 않는 값입니다.");
            scan = new Scanner(System.in);
            price = checkInputPrice(INITIAL_PRICE);
        }
        return price;
    }

    public int checkMinusPrice(int price) {
        if (price < 0) {
            System.out.println("0보다 작을 수 없습니다.");
            price = checkInputPrice(INITIAL_PRICE);
        }
        return price;
    }
}
