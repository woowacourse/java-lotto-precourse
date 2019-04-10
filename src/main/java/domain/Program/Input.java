package domain.Program;

import domain.Program.Config.Constant;
import domain.Program.Config.Validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    public static long setPrice(){
        Print.getInputPrice();
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
            Print.getValidation();
            return numberInput();
        }
    }

    private static String stringInput(){
        try {
            return new Scanner(System.in).next();
        }catch(Exception e){
            Print.getValidation();
            return stringInput();
        }
    }
}
