package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class User {
    private ArrayList<Lotto> lottoList;
    private Scanner scanner;
    private String pay;
    private int lottoCnt;

    User(){
        scanner = new Scanner(System.in);
        lottoList = new ArrayList<>();
    }

    public String inputMoney(){
        pay = scanner.nextLine();
        return pay;
    }

    int getRandomNumber(){
        Random random = new Random();
        return random.nextInt(45) + 1;
    }

    public void makeLottoList(){
        lottoCnt = Integer.parseInt(pay) / 1000;

        for(int i=0; i<lottoCnt; i++){
            lottoList.add(makeLotto());
        }
    }
    

    public Lotto makeLotto(){
        // 초기화가 되나?
        boolean[] checkNumber = new boolean[46];
        ArrayList<Integer> numbers = new ArrayList<>();
        Lotto lotto;

        // indent 1로 나중에 수정하자
        for(int i=0; i<6; i++){
            int number = getRandomNumber();
            if(!checkNumber[number]) {
                checkNumber[number] = true;
                numbers.add(number);
                continue;
            }
            i--;
        }

        lotto = new Lotto(numbers);
        return lotto;
    }
}
