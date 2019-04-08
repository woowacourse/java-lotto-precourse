package domain;

import jdk.internal.util.xml.impl.Input;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    int inputPrice;

    public void run() {
        buyLotto();
    }

    private void buyLotto() {
        Scanner sc = new Scanner(System.in);

        try {
            inputPrice = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("올바른 숫자가 아닙니다.");
        } finally {
            sc.close();
        }
    }
}
