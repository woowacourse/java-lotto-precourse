package domain;

import java.util.Scanner;

public class UserInputReciever {
    Scanner scanner = new Scanner(System.in);

    public void RecievePurchaseAmount(){
        try {
            TryToRecievePurchaseAmount();
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    private void TryToRecievePurchaseAmount() throws IllegalArgumentException{
        System.out.println("이후구현예정");
    }
}
