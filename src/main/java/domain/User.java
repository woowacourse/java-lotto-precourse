package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class User {
    private final int MinNumber = 1;
    private final int MaxNumber = 45;
    private final int MinPrice = 1000;
    private final int MaxNumberLength = 6;
    private List<Lotto> createdLotto;
    private List<Integer> checkedLastLotto;
    private HashMap<Integer,Integer> overlap;
    private Scanner Input;

    public int getPrice() {
        Input = new Scanner(System.in);
        int price = 0;
        do {
            System.out.println("구입금액을 입력해 주세요.");
            price = Input.nextInt();
        } while(checkPrice(price));
        return price;
    }

    private boolean checkPrice(int price) {
        if (price < MinPrice) {
            return true;
        }
        return false;
    }

    private void BuyLotto(int price) {
        createdLotto = new ArrayList<Lotto>();
        int myMoney = price;
        while(myMoney >= MinPrice) {
            createLotto();
            myMoney -= MinPrice;
        }
    }

    private void createLotto() {
        overlap = new HashMap<Integer, Integer>();
        List<Integer> lotto = new ArrayList<Integer>();
        for(int i =0; i<MaxNumberLength; i++) {
            int number = randomNumber();
            lotto.add(number);
        }
        createdLotto.add(new Lotto(lotto));
    }

    private int randomNumber() {
        int no = 0;
        do {
            no = (int) (Math.random() * MaxNumber) + MinNumber;
        } while (checkLottoOverlap(no));
        return no;
    }

    private boolean checkLottoOverlap(int no) {
        if (overlap.containsKey(no)) {
            return true;
        }
        overlap.put(no, 0);
        return false;
    }

    public List<Lotto> getLotto(int price) {
        BuyLotto(price);
        System.out.println(createdLotto.size()+"개를 구매했습니다.");
        return createdLotto;
    }

    public List<Integer> getWinningLotto() {
        Input = new Scanner(System.in);
        do {
            overlap = new HashMap<Integer, Integer>();
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            String number = Input.nextLine();
            checkedLastLotto = checkLastLotto(number);
        } while (checkLastLottoSize(checkedLastLotto));

        return checkedLastLotto;
    }

    private List<Integer> checkLastLotto(String number) {
        checkedLastLotto = new ArrayList<Integer>();
        String checkednumber[] =  number.replaceAll(" ", "").split(",");
        for (int i =0; i<checkednumber.length; i++) {
            checkLastLottoState(Integer.valueOf(checkednumber[i]));
        }
        return checkedLastLotto;
    }

    private void checkLastLottoState(int no) {
        if (!checkLastLottoRange(no) && !checkLastLottoOverlap(no)) {
            checkedLastLotto.add(no);
        }
    }

    private boolean checkLastLottoRange(int no) {
        if (no < MinNumber || no > MaxNumber) {
            return true;
        }
        return false;
    }

    private boolean checkLastLottoOverlap(int no) {
        if(overlap.containsKey(no)) {
            System.out.println("!");
            return true;
        }
        overlap.put(no, 1);
        return false;
    }

    private boolean checkLastLottoSize(List<Integer> checkedLastLotto) {
        if (checkedLastLotto.size() > MaxNumberLength || checkedLastLotto.size() < MaxNumberLength) {
            checkedLastLotto = new ArrayList<Integer>();
            return true;
        }
        return false;
    }
}
