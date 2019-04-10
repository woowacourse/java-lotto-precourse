package domain;

import java.util.List;

public class Person {
    private int budget;
    private List<Lotto> myLotto;

    public Person() {

    }

    public boolean setBudget(int budget) {
        if (budget < 0) {
            System.out.println("마이너스 통장을 갖고 있어서 로또를 살 수 없습니다.");
            return false;
        }
        this.budget = budget;

        return true;
    }

    public int payBudget() {
        return budget;
    }

    public void keepLotto(List<Lotto> lottoList) {
        this.myLotto = lottoList;
    }
}
