package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또 한장을 의미하는 객체
 */
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    public String toString(){
        return numbers.toString();
    }

    public  boolean contains(int number){
        return numbers.contains(number);
    }

    public ArrayList<Integer> returnArrayList(){
        return new ArrayList<>(numbers);
    }

    public ArrayList<Integer> retainAll(Lotto comparedLotto){
        ArrayList<Integer> originalList = returnArrayList();
        ArrayList<Integer> winningList = comparedLotto.returnArrayList();
        originalList.retainAll(winningList);
        return originalList;
    }
}
