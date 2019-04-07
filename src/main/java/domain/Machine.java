package domain;

import java.util.ArrayList;
import java.util.List;

public class Machine {
    private List<Integer> lottoMachineNumber = new ArrayList<>();

    public Lotto[] sellLotto(int price) {
        System.out.println("랜덤으로 로또가 생성됩니다.");
        int count = (price/1000);
        Lotto[] lottoBundle = new Lotto[count];
        for(int i=0; i< count; i++) {
            fillLottoNumber();
            lottoBundle[i] = createLotto(getRandomLottoNumber());
        }
        return lottoBundle;
    }

    private List<Integer> getRandomLottoNumber(){
        List<Integer> lottoUserNumber = new ArrayList<>();
        for(int i=0; i<6; i++) {
            lottoUserNumber.add(lottoMachineNumber.remove(createRandomNumber(44-i)));
        }
        return lottoUserNumber;
    }

    private int createRandomNumber(int size) {
        return(int)(Math.random()*size)+1;
    }

    private Lotto createLotto(List<Integer> lottoNumber) {
        return new Lotto(lottoNumber);
    }

    public void fillLottoNumber() {
        lottoMachineNumber.clear();
        for(int i=1; i<=45; i++) {
            lottoMachineNumber.add(i);
        }
    }
}
