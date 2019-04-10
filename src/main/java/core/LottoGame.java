package core;

import domain.Person;

import java.util.Scanner;

public class LottoGame {
    private Person player;
    private Scanner scanner;

    public LottoGame() {
        player = new Person();
        scanner = new Scanner(System.in);
    }

    public void init() {
        enterBudget();
    }

    private void enterBudget() {
        int budget = 0;
        System.out.println("구입 금액을 입력해 주세요.");
        try {
            budget = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("잘못된 입력입니다.");
            enterBudget();
        }
        if (!player.setBudget(budget))
            System.out.println("마이너스 통장을 갖고 있어서 살 수 없습니다.");
    }
}
