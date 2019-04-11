package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {

  final int PRICE_PER_GAME = 1000;

  public void run() {
    int num = getThePriceOfLotto() / PRICE_PER_GAME;
    System.out.println(num + "개를 구매했습니다.");
    ArrayList<Lotto> lottoArrayList = initLottoArrayList(num);
    WinningLotto winningLotto = getWinLotto();
    ArrayList<Rank> lottoRanks = getRanks(lottoArrayList, winningLotto);
    printRanks(lottoRanks);
    printEarningRate(lottoRanks, num);
  }

  private ArrayList<Rank> getRanks(ArrayList<Lotto> lottoArrayList, WinningLotto winningLotto) {
    ArrayList<Rank> lottoRanks = new ArrayList<Rank>();
    for (Lotto lotto : lottoArrayList) {
      lottoRanks.add(winningLotto.match(lotto));
    }
    return lottoRanks;
  }

  private int getThePriceOfLotto() {
    System.out.println("구입금액을 입력해 주세요.");
    Scanner scan = new Scanner(System.in);
    try {
      return scan.nextInt();
    } catch (Exception e) {
      System.out.println("구매 금액은 숫자로 입력해주세요");
      return getThePriceOfLotto();
    }
  }

  private ArrayList<Lotto> initLottoArrayList(int num) {
    ArrayList<Lotto> lottoArrayList = new ArrayList<Lotto>();
    for (int i = 0; i < num; i++) {
      lottoArrayList.add(initLotto());
      showLottoNum(lottoArrayList.get(i));
    }
    return lottoArrayList;
  }

  private Lotto initLotto() {
    List<Integer> lottoNumbers = IntStream.range(1, 46).boxed().collect(Collectors.toList());
    Collections.shuffle(lottoNumbers);
    return new Lotto(lottoNumbers.subList(0, 6));
  }

  private void showLottoNum(Lotto oneLotto) {
    System.out.println(oneLotto.showNumbers());
  }

  private WinningLotto getWinLotto() {
    Lotto winner = setWinLotto();
    System.out.println("보너스 볼을 입력해 주세요.");
    try {
      Scanner scan2 = new Scanner(System.in);
      WinningLotto winLotto = new WinningLotto(winner, scan2.nextInt());
      return winLotto;
    } catch (Exception e) {
      System.out.println("보너스 볼은 숫자로 입력해 주세요.");
      return getWinLotto();
    }
  }

  private Lotto setWinLotto() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    try {
      int[] intNum = Arrays.asList(new Scanner(System.in).next().split(",")).stream()
          .mapToInt(Integer::parseInt).toArray(); //10줄...
      List<Integer> win = Arrays.stream(intNum).boxed().collect(Collectors.toList());
      Lotto winner = new Lotto(win);
      return winner;
    } catch (Exception e) {
      System.out.println("당첨 번호는 숫자로 입력해 주세요.");
      return setWinLotto();
    }
  }

  private void printRanks(ArrayList<Rank> lottoRanks) {
    Map<Rank, Integer> rankIntegerMap = countRank(lottoRanks);
    System.out.println("당첨 통계\n---------");
    System.out.println(
        "3개 일치 (" + Rank.FIFTH.getWinningMoney() + "원)-" + rankIntegerMap.get(Rank.FIFTH) + "개");
    System.out.println(
        "4개 일치 (" + Rank.FOURTH.getWinningMoney() + "원)-" + rankIntegerMap.get(Rank.FOURTH) + "개");
    System.out.println(
        "5개 일치 (" + Rank.THIRD.getWinningMoney() + "원)-" + rankIntegerMap.get(Rank.THIRD) + "개");
    System.out.println("5개 일치, 보너스 볼 일치 (" + Rank.SECOND.getWinningMoney() + "원)-" + rankIntegerMap
        .get(Rank.SECOND) + "개");
    System.out.println(
        "6개 일치 (" + Rank.FIRST.getWinningMoney() + "원)-" + rankIntegerMap.get(Rank.FIRST) + "개");
  }

  private Map<Rank, Integer> countRank(ArrayList<Rank> listOfRank) {
    Map<Rank, Integer> rankMap = setMap();
    for (Rank rank : listOfRank) {
      rankMap.replace(rank, rankMap.get(rank) + 1);
    }
    return rankMap;
  }

  private Map<Rank, Integer> setMap() {
    Map<Rank, Integer> rankMap = new HashMap<Rank, Integer>();
    rankMap.put(Rank.FIRST, 0);
    rankMap.put(Rank.SECOND, 0);
    rankMap.put(Rank.THIRD, 0);
    rankMap.put(Rank.FOURTH, 0);
    rankMap.put(Rank.FIFTH, 0);
    rankMap.put(Rank.MISS, 0);
    return rankMap;
  }

  private void printEarningRate(ArrayList<Rank> rankArrayList, int num) {
    int sum = 0;
    for (Rank rank : rankArrayList) {
      sum += rank.getWinningMoney();
    }
    System.out.println("총 수익률은 " + (double) sum / (num * PRICE_PER_GAME) + "입니다.");
  }
}
