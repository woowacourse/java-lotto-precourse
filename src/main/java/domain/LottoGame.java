package domain;

import java.util.Scanner;

public class LottoGame {

  public static int InputPurchaseAmount(){
    Scanner sc = new Scanner(System.in);
    System.out.println("구입금액을 입력해 주세요.");
    int purchaseAmount = sc.nextInt();
    return purchaseAmount;
  }

  public static void main(String args[]){
    
  }
}
