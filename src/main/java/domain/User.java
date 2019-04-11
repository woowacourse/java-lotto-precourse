
package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class User {
    private final int MinNumber = 1;
    private final int MaxNumber = 45;
    private final int MinBudget = 1000;
    private final int MaxNumberLength = 6;
    private List<Lotto> createdLotto;
    private List<Integer> checkedWinNumber;
    private HashMap<Integer, Integer> overlap;
    private Scanner Input;

    public int getBudget() {
        Input = new Scanner(System.in);
        int Budget = 0;
        do {
            System.out.println("구입금액을 입력해 주세요.");
            Budget = Input.nextInt();
        } while (checkBudget(Budget));
        return Budget;
    }

    private boolean checkBudget(int Budget) {
        if (Budget < MinBudget) {
            return true;
        }
        return false;
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
    private void BuyLotto(int Budget) {
        createdLotto = new ArrayList<Lotto>();
        int myMoney = Budget;
        while(myMoney >= MinBudget) {
            createLotto();
            myMoney -= MinBudget;
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
    public List<Lotto> getLotto(int Budget) {
        BuyLotto(Budget);
        System.out.println(createdLotto.size()+"개를 구매했습니다.");
        return createdLotto;
    }

    public List<Integer> getWinningLotto() {
        Input = new Scanner(System.in);
        do {
            overlap = new HashMap<Integer, Integer>();
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            String number = Input.nextLine();
            checkedWinNumber = checkWinNumber(number);
        } while (checkWinNumberSize(checkedWinNumber));

        return checkedWinNumber;
    }
    private List<Integer> checkWinNumber(String number) {
        checkedWinNumber = new ArrayList<Integer>();
        String checkednumber[] =  number.replaceAll(" ", "").split(",");
        for (int i =0; i<checkednumber.length; i++) {
            checkWinNumberState(Integer.valueOf(checkednumber[i]));
        }
        return checkedWinNumber;
    }

    private void checkWinNumberState(int no) {
        if (!checkWinNumberRange(no) && !checkWinNumberOverlap(no)) {
            checkedWinNumber.add(no);
        }
    }

    private boolean checkWinNumberRange(int no) {
        if (no < MinNumber || no > MaxNumber) {
            return true;
        }
        return false;
    }

    private boolean checkWinNumberOverlap(int no) {
        if(overlap.containsKey(no)) {
            System.out.println("!");
            return true;
        }
        overlap.put(no, 1);
        return false;
    }

    private boolean checkWinNumberSize(List<Integer> checkedWinNumber) {
        if (checkedWinNumber.size() > MaxNumberLength || checkedWinNumber.size() < MaxNumberLength) {
            checkedWinNumber = new ArrayList<Integer>();
            return true;
        }
        return false;
    }
    public int getBonusNo() {
        int no = 0;
        do {
            System.out.println("보너스 볼을 입력해 주세요.");
            Input = new Scanner(System.in);
            no = Input.nextInt();
        } while(checkBonusNo(no));
        return no;
    }

    private boolean checkBonusNo(int no) {
        if (no < MinNumber || no > MaxNumber) {
            return true;
        }
        if (overlap.containsKey(no)) {
            return true;
        }
        return false;
    }
}