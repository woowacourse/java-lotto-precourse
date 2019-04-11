package domain;

import java.util.List;
import java.util.Scanner;

public class User {
    private List<Lotto> lottolist;
    private Scanner scanner;
    private String pay;

    User(){
        scanner = new Scanner(System.in);
    }

    public String inputMoney(){
        String pay = scanner.nextLine();
        return pay;
    }

}
