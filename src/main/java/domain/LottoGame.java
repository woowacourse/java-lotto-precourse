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
  public int[] matchCount;
  public int totalReward;

  private boolean IsValidAmount(int purchasePrice){
    if(purchasePrice < 0){
      return false;
    }
    if(purchasePrice % oneLottoPrice != 0){
      return false;
    }
    return true;
  }

  private boolean IsValidNumber(String number){
    String regEx = "^[0-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$";
    if(number.matches(regEx))
      return true;
    System.out.println("잘못된 당첨 숫자입니다.");
    System.exit(0);
    return false;
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
    for(int i=0;i<oneLottoAmount;i++){
      IsValidNumber(winNumberList[i]);
    }
    List<Integer> winningList = new ArrayList(oneLottoAmount);
    for(int i=0;i<oneLottoAmount;i++){
        winningList.add(Integer.parseInt(winNumberList[i]));
    }
    return winningList;
  }

  private Lotto InputWinningNumber(){
    Scanner sc = new Scanner(System.in);
    String winningInput = sc.nextLine();
    List<Integer> winningList = StringToIntegerLotto(winningInput);
        /*
        for (int i = 0; i < Lotto.oneLottoAmount; i++) {
            System.out.print(winningList.get(i)+" ");
        }
        */
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

  private void InitializeMatchCount(){
    matchCount = new int[6];
    for(int i=0;i<6;i++){
      matchCount[i]=0;
    }
  }

  private void CalculateTotal(Rank rank){
    this.totalReward += rank.getWinningMoney();
  }

  private void MatchEachLotto(List<Lotto> userLotto, WinningLotto winLotto){
    InitializeMatchCount();
    for(int i=0;i<purchaseAmount;i++){
      Rank rank = winLotto.match(userLotto.get(i));
      CalculateTotal(rank);
      matchCount[rank.ordinal()]++;
    }
  }

  public void PrintResult(){
    System.out.println("당첨통계");
    System.out.println("-----------------");
    System.out.println("3개 일치 (5000원) - " + matchCount[4] + "개");
    System.out.println("4개 일치 (50000원) - " + matchCount[3] + "개");
    System.out.println("5개 일치 (1500000원) - " + matchCount[2] + "개");
    System.out.println("5개 일치; 보너스 볼 일치(3000000원) - " + matchCount[1] + "개");
    System.out.println("6개 일치 (2000000000원) - " + matchCount[0] + "개");
    System.out.println("총 수익률은 " + (float)totalReward/purchasePrice + "입니다.");
  }

  public void StartLotto(){
    this.InputUserPurchase();
    if(purchaseAmount==-1)
      return;
    List<Lotto> userLotto = MakeUserLottoList();
    WinningLotto winLotto = InputWinningLotto();
    MatchEachLotto(userLotto, winLotto);
    PrintResult();
  }

  public static void main(String args[]){
    LottoGame game = new LottoGame();
    game.StartLotto();
  }
}
