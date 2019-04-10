package domain;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LottoGame {
  private final static int oneLottoPrice = 1000;
  private final static int oneLottoAmount = 6;
  private final static int maxLottoNum = 45;

  public int purchasePrice;
  public int purchaseAmount;

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

  private boolean IsAlreadyNumber(int oneNumber, boolean[] duplicateCheck){
    if(duplicateCheck[oneNumber])
      return false;
    return true;
  }

  private int MakeRandomNum(boolean[] duplicateCheck){
    Random random = new Random();
    int randomNum;
    do{
      randomNum = random.nextInt(maxLottoNum)+1;
    }while(!IsAlreadyNumber(randomNum, duplicateCheck));
    duplicateCheck[randomNum] = true;
    return randomNum;
  }

  private List<Integer> MakeLottoCombination(boolean[] duplicateCheck){
    List<Integer> oneLottoList = new ArrayList(oneLottoAmount);
    for(int i=1;i<=maxLottoNum;i++){
      duplicateCheck[i] = false;
    }
    for(int i=0;i<oneLottoAmount;i++){
      oneLottoList.add(MakeRandomNum(duplicateCheck));
    }
    return oneLottoList;
  }

  private void InputUserPurchase(){
    purchasePrice = InputPurchasePrice();
    if(!IsValidAmount(purchasePrice)) {
      System.out.println("잘못된 금액입니다.");
      return;
    }
    purchaseAmount = purchasePrice/oneLottoPrice;
    System.out.println("\n"+purchaseAmount+"개를 구매했습니다.");
  }

  public Lotto MakeOneLotto(boolean[] duplicateCheck){
    List<Integer> oneLottoCombination = MakeLottoCombination(duplicateCheck);
    Lotto oneLotto = new Lotto(oneLottoCombination);
    return oneLotto;
  }

  private List<Lotto> MakeUserLottoList(){
     boolean[] duplicateCheck = new boolean[maxLottoNum+1];
     List<Lotto> userLotto = new ArrayList();
     for(int i=0;i<purchaseAmount;i++) {
      userLotto.add(MakeOneLotto(duplicateCheck));
      userLotto.get(i).PrintLottoNum();
    }

    return userLotto;
  }

      private List<Integer> StringToIntegerLotto(String winLotto){
        String[] winNumberList = winLotto.split(",");
        List<Integer> winningList = new ArrayList(Lotto.oneLottoAmount);
        for(int i=0;i<Lotto.oneLottoAmount;i++){
            winningList.add(Integer.parseInt(winNumberList[i]));
        }
        return winningList;
    }

    private Lotto InputWinningNumber(){
        Scanner sc = new Scanner(System.in);
        String regEx = "^([1-45]),([1-45]),([1-45]),([1-45]),([1-45]),([1-45])$";
        String winningInput = sc.nextLine();
        /*
        if(!winningInput.matches(regEx))
            return null;
        */
        List<Integer> winningList = StringToIntegerLotto(winningInput);
        for (int i = 0; i < Lotto.oneLottoAmount; i++) {
            System.out.print(winningList.get(i)+" ");
        }
        Lotto winningNumber = new Lotto(winningList);
        return winningNumber;
    }

    private static int InputBonusNumber(){
        Scanner sc = new Scanner(System.in);
        int bonusNum = sc.nextInt();
        return bonusNum;
    }

    public WinningLotto InputWinningLotto(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Lotto winningNumber = InputWinningNumber();
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNum = InputBonusNumber();
        WinningLotto winLotto = new WinningLotto(winningNumber, bonusNum);
        return winLotto;
    }

  public void StartLotto(){
    this.InputUserPurchase();
    if(purchaseAmount==-1)
      return;
    List<Lotto> userLotto = MakeUserLottoList();
    WinningLotto winLotto = InputWinningLotto();
  }

  public static void main(String args[]){
    LottoGame game = new LottoGame();
    game.StartLotto();
  }
}
