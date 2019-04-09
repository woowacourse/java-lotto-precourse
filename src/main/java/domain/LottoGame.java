package domain;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LottoGame {
  public static int oneLottoPrice = 1000;
  public static int oneLottoAmount = 6;
  public static int maxLottoNum = 45;

  public int purchasePrice;
  public int purchaseAmount;
  public int lottoAmount;

  private boolean IsValidAmount(int purchasePrice){
    if(purchasePrice < 0){
      return false;
    }
    if(purchasePrice % oneLottoPrice != 0){
      return false;
    }
    return true;
  }

  private int InputPurchasePrice(){
    Scanner sc = new Scanner(System.in);
    System.out.println("구입금액을 입력해 주세요.");
    int purchasePrice = -1;
    try {
      purchasePrice= sc.nextInt();
    }catch (InputMismatchException e){
      System.out.println("유효하지 않은 값입니다");
    }
    return purchasePrice;
  }

  public void StartLotto(){
    purchasePrice = InputPurchasePrice();
    if(!IsValidAmount(purchasePrice)) {
      System.out.println("잘못된 금액입니다.");
      return;
    }
    purchaseAmount = purchasePrice/oneLottoPrice;
    System.out.println("\n"+purchaseAmount+"개를 구매했습니다.");
    /*
    for (int i = 0; i < oneLottoAmount; i++) {
      System.out.print(list.get(i) + " ");
    }
    */
  }

  public static void main(String args[]){
    LottoGame game = new LottoGame();
    game.StartLotto();
  }
}
