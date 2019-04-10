
package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class User {
    private final int MinPrice = 1000;
    private Scanner Input;
    public int getPrice() {
        Input = new Scanner(System.in);
        int price = 0;
        do {
            System.out.println("구입금액을 입력해 주세요.");
            price = Input.nextInt();
        } while(checkPrice(price));
        return price;
    }
    private boolean checkPrice(int price) {
        if (price < MinPrice) {
            return true;
        }
        return false;
    }

}