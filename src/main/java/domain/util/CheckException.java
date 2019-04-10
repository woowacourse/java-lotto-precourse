package domain.util;

public class CheckException {
    public static void checkInsertedMoneyIsValid(int value, int min, int max){
        if(value > min && value < max){
            return;
        }
        throw new IllegalArgumentException();
    }
}
