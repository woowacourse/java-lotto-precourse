package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Scanner sc = new Scanner(System.in);

    private List<Lotto> lottos = new ArrayList<>();

    protected void execute() {
        int gameNum = setGameNum(sc.nextInt());
        sc.nextLine();

    }

    private int setGameNum(int total) {
        return total / 1000;
    }
}
