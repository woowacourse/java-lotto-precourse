package domain;

public class Person {
    private int budget;

    public Person() {

    }

    public boolean setBudget(int budget) {
        if (budget < 0)
            return false;

        this.budget = budget;

        return true;
    }
}
