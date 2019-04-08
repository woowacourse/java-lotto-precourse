package domain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private int inputPrice;

    public void run() {
        do {
            buyLotto();
        } while (print());
    }

    private void buyLotto() {
        Scanner sc = new Scanner(System.in);

        try {
            inputPrice = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("올바른 숫자가 아닙니다.");
            buyLotto();
        }
    }

    private boolean print() {
        int num = inputPrice / 1000;

        if (num <= 0) {
            System.out.println("로또를 살 수 없습니다.");
            return true;
        }

        System.out.println(num + "개를 구매했습니다.");
        return false;
    }
}
