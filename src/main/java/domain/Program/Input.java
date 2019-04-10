package domain.Program;

import domain.Program.Config.Constant;
import domain.Program.Config.Validation;

import java.util.Scanner;

public class Input {
    public static long setPrice(){
        try{
            long price = numberInput();
            Validation.checkNumberRange(price, Constant.PRICE_MIN,Constant.PRICE_MAX);
            Validation.checkNumberRest(price,Constant.LOTTO_PRICE);
            return price;
        }catch(Exception e){
            return setPrice();
        }
    }

    private static long numberInput(){
        try {
            return new Scanner(System.in).nextLong();
        }catch(Exception e){
            System.out.println("유효하지 않는 값입니다.");
            return numberInput();
        }
    }
}
