package domain.Program;

public class Random {
    public static int createNumber(int size){
        return (int)(Math.random()* size) +1;
    }
}
