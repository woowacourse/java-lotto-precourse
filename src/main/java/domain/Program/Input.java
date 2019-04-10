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
            long price = inputLongNumber();
            Validation.checkNumberRange(price, Constant.PRICE_MIN,Constant.PRICE_MAX);
            Validation.checkNumberRest(price,Constant.LOTTO_PRICE);
            return price;
        }catch(Exception e){
            return setPrice();
        }
    }

    public static String setLottoNumber(){
        try{
            String stringLottoNumber = inputString();
            Validation.checkSelfLottoNumber(stringLottoNumber);
            return stringLottoNumber;
        }catch(Exception e){
            return setLottoNumber();
        }
    }

    public static int setBonusNumber(List<Integer> lottoPaper){
        Print.getBonusNumberSetter();
        try{
            int bonusNumber = inputIntegernumber();
            Validation.checkNumberRange(bonusNumber,Constant.LOTTO_MIN,Constant.LOTTO_MAX);
            Validation.checkBonusNumberDuplication(lottoPaper,bonusNumber);
            return bonusNumber;
        }catch(Exception e){
            return setBonusNumber(lottoPaper);
        }
    }

    private static long inputLongNumber(){
        try {
            return new Scanner(System.in).nextLong();
        }catch(Exception e){
            Print.getValidation();
            return inputLongNumber();
        }
    }

    private static int inputIntegernumber(){
        try {
            return new Scanner(System.in).nextInt();
        }catch(Exception e){
            Print.getValidation();
            return inputIntegernumber();
        }
    }

    private static String inputString(){
        try {
            return new Scanner(System.in).next();
        }catch(Exception e){
            Print.getValidation();
            return inputString();
        }
    }
}
