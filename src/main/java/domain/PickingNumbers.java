package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PickingNumbers {
    private final List<Integer> numbers;
    private final static int sizeOfNumber = 45;
    private final static int sizeOfLotto = 6;

    public PickingNumbers(){
        numbers = new ArrayList<Integer>();
        fill();
    }

    private void fill(){
        for(int i = 0; i < sizeOfNumber; i++){
            numbers.add(i + 1);
        }
    }

    public void shuffle(){
        Collections.shuffle(numbers);
    }

    public void show(){
        for(int i = 0; i < 6; i++){
            System.out.println(numbers.get(i));
        }
        System.out.println();
    }

    public void size(){
        System.out.println(numbers.size());
    }

    public List<Integer> getSix(){
        return numbers.subList(0, sizeOfLotto);
    }
}
