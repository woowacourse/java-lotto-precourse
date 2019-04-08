package domain;

import java.util.Scanner;

public class PlayLotto {

    public int insertMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}