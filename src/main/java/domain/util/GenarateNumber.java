package domain.util;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class GenarateNumber {

    public static List<Integer> genarateUserNumber(){
        List <Integer> sixNumbers = new ArrayList<>();
        while(sixNumbers.size()<Constant.NUMBER_OF_LOTTO_NUMBERS){
            addingNumberToList(sixNumbers);
        }
        Collections.sort(sixNumbers);
        return sixNumbers;
    }

    public static void addingNumberToList(List <Integer> numberList){
        int randomNumber = getRandomNum();
        if(!numberList.contains(randomNumber)){
            numberList.add(randomNumber);
        }

    }

    public static int getRandomNum(){
        int randomNum = (int)(Math.random() * Constant.MAX_LOTTO_NUM + Constant.MIN_LOTTO_NUM);
        return randomNum;
    }
}
