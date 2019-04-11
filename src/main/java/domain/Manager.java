package domain;

import java.util.Scanner;

public class Manager {
    User user;

    Manager(){
        user = new User();
    }

    public void startGame(){
        while(!firstQuery());

    }

    public boolean firstQuery(){
        System.out.println("구입금액을 입력해 주세요.");
        String ret = user.inputMoney();

        CheckFormatError(ret);
        CheckMinusError(Integer.parseInt(ret));
        CheckRestError(Integer.parseInt(ret));
        
        return true;
    }

    public boolean CheckRestError(int input){
        if(input % 1000 != 0){
            System.out.println(InputError.REST_ERROR);
            return false;
        }
        return true;
    }

    public boolean CheckMinusError(int input){
        if(input <= 0) {
            System.out.println(InputError.MINUS_ERROR);
            return false;
        }
        return true;
    }

    public boolean CheckFormatError(String input){
        try{
            Integer.parseInt(input);
        }catch(NumberFormatException e){
            System.out.println(InputError.NUMBER_FORMAT_ERROR);
            return false;
        }
        return true;
    }

}
