package domain;

import java.util.Scanner;

public class Manager {
    User user;

    Manager(){
        user = new User();
    }

    public void startGame(){
        firstQuery();

    }

    public boolean firstQuery(){
        System.out.println("구입금액을 입력해 주세요.");
        String ret = user.inputMoney();

        CheckFormatError(ret);


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
