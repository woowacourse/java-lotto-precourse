package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class UserLotto {

    private List<Lotto> userLottoList;

    public UserLotto(){
    }

    public UserLotto(int amount){
        userLottoList = new ArrayList<>();

        for(int i = 0; i < amount; i++){
            createUserLotto();
        }
        System.out.println(amount + "개를 구매했습니다.");
        printAllUserLotto();
    }

    private void createUserLotto(){
        List<Integer> determinedNumberList = new ArrayList<>();

        for(int i = 0; i < ConstValue.LOTTO_COUNT_SIZE; i++){
            fillRandomLottoNumber(determinedNumberList);
        }
        Collections.sort(determinedNumberList);

        Lotto lotto = new Lotto(determinedNumberList);
        userLottoList.add(lotto);
    }

    private void fillRandomLottoNumber(List<Integer> determinedNumberList){
        int randomNumber;

        do{
            randomNumber = makeRandomNumber();
        }while(determinedNumberList.contains(randomNumber));

        determinedNumberList.add(randomNumber);
    }

    private int makeRandomNumber(){
        return (int) (Math.random() * ConstValue.MAXIMUM_LOTTO_NUMBER)
                + ConstValue.MINIMUM_LOTTO_NUMBER;
    }

    private void printAllUserLotto(){
        Iterator<Lotto> iter = userLottoList.iterator();
        while(iter.hasNext()){
            iter.next().printLottoNumber();
        }
    }
}
