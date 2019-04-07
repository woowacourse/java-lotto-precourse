package domain;

import java.util.ArrayList;
import java.util.List;

public class Machine extends Config {
    private List<Integer> lottoMachineNumber = new ArrayList<>();
    private int count;
    private Lotto[] lottoBundle;

    public Machine(int price){
        this.count = (price/LOTTO_PRICE);
        this.lottoBundle = new Lotto[count];
    }

    public Lotto[] sellLotto(int price) {
        System.out.println("랜덤으로 로또가 생성됩니다.");
        for(int i=0; i< count; i++) {
            fillLottoNumber();
            lottoBundle[i] = createLotto(getRandomLottoNumber());
        }
        return this.lottoBundle;
    }

    private List<Integer> getRandomLottoNumber(){
        List<Integer> lottoUserNumber = new ArrayList<>();
        for(int i=0; i<LOTTO_NUMBER_SIZE; i++) {
            lottoUserNumber.add(lottoMachineNumber.remove(createRandomNumber((LOTTO_MAX_VALUE-1)-i)));
        }
        return lottoUserNumber;
    }

    private int createRandomNumber(int size) {
        return(int)(Math.random()*size)+1;
    }

    private Lotto createLotto(List<Integer> lottoNumber) {
        return new Lotto(lottoNumber);
    }

    private void fillLottoNumber() {
        lottoMachineNumber.clear();
        for(int i=(LOTTO_MIN_VALUE+1); i<=LOTTO_MAX_VALUE; i++) {
            lottoMachineNumber.add(i);
        }
    }
}
