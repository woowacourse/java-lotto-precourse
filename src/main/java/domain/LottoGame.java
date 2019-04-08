package domain;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LottoGame {

  private boolean IsValidAmount(int purchaseAmount){
    if(purchaseAmount < 0){
      return false;
    }
    if(purchaseAmount % 1000 != 0){
      return false;
    }
    return true;
  }

  private int InputPurchaseAmount(){
    Scanner sc = new Scanner(System.in);
    System.out.println("구입금액을 입력해 주세요.");
    int purchaseAmount = -1;
    try {
      purchaseAmount= sc.nextInt();
    }catch (InputMismatchException e){
      System.out.println("유효하지 않은 값입니다");
    }
    return purchaseAmount;
  }

  public void StartLotto(){
    int purchaseAmount = this.InputPurchaseAmount();
    if(!this.IsValidAmount(purchaseAmount)){
      System.out.println("잘못된 금액입니다.");
      return;
    }
  }

  public static void main(String args[]){
    LottoGame game = new LottoGame();
    game.StartLotto();
  }
}
