package domain;

import java.util.Scanner;

public class LottoGame {
    public void run(){
      int num = getThePriceOfLotto();
    }
    public int getThePriceOfLotto(){
      System.out.println("구입금액을 입력해 주세요.");
      Scanner scan = new Scanner(System.in);
      return scan.nextInt();
    }
}
