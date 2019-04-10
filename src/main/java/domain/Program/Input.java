package domain.Program;

import domain.Program.Config.Constant;
import domain.Program.Config.Validation;

import java.util.ArrayList;
import java.util.List;
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

    public static String setSelfLottoNumber(){
        try{
            String stringLottoNumber = stringInput();
            Validation.checkSelfLottoNumber(stringLottoNumber);
            return stringLottoNumber;
        }catch(Exception e){
            return setSelfLottoNumber();
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

    private static String stringInput(){
        try {
            return new Scanner(System.in).next();
        }catch(Exception e){
            System.out.println("유효하지 않는 값입니다.");
            return stringInput();
        }
    }
}
