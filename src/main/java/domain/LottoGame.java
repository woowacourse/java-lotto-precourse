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

  public void run() {
    int num = getThePriceOfLotto() / 1000;
    System.out.println(num + "개를 구매했습니다.");
    ArrayList<Lotto> lottoArrayList = initLottoArrayList(num);
    WinningLotto winningLotto = getWinLotto();
    ArrayList<Rank> lottoRanks = getRanks(lottoArrayList, winningLotto);
    printRanks(lottoRanks);
  }

  private ArrayList<Rank> getRanks(ArrayList<Lotto> lottoArrayList, WinningLotto winningLotto) {
    ArrayList<Rank> lottoRanks = new ArrayList<Rank>();
    for (Lotto lotto : lottoArrayList) {
      lottoRanks.add(winningLotto.match(lotto));
    }
    return lottoRanks;
  }

  public int getThePriceOfLotto() {
    System.out.println("구입금액을 입력해 주세요.");
    Scanner scan = new Scanner(System.in);
    return scan.nextInt();
  }

  public ArrayList<Lotto> initLottoArrayList(int num) {
    ArrayList<Lotto> lottoArrayList = new ArrayList<Lotto>();
    for (int i = 0; i < num; i++) {
      lottoArrayList.add(initLotto());
      showLottoNum(lottoArrayList.get(i));
    }
    return lottoArrayList;
  }

  public Lotto initLotto() {
    List<Integer> lottoNumbers = IntStream.range(1, 46).boxed().collect(Collectors.toList());
    Collections.shuffle(lottoNumbers);
    return new Lotto(lottoNumbers.subList(0, 6));
  }

  public void showLottoNum(Lotto oneLotto) {
    System.out.println(oneLotto.showNumbers());
  }

  public WinningLotto getWinLotto() {
    Lotto winner = setWinLotto();
    System.out.println("보너스 볼을 입력해 주세요.");
    Scanner scan2 = new Scanner(System.in);
    WinningLotto winLotto = new WinningLotto(winner, scan2.nextInt());
    return winLotto;
  }

  public Lotto setWinLotto() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    Scanner scan = new Scanner(System.in);
    int[] intNum = Arrays.asList(scan.next().split(",")).stream().mapToInt(Integer::parseInt)
        .toArray();
    List<Integer> win = Arrays.stream(intNum).boxed().collect(Collectors.toList());
    Lotto winner = new Lotto(win);
    return winner;
  }

  public void printRanks(ArrayList<Rank> lottoRanks) {
    Map<Rank, Integer> rankIntegerMap = countRank(lottoRanks);
    System.out.println("당첨 통계\n---------");
    System.out.println("3개 일치 (5000원)-" + rankIntegerMap.get(Rank.FIFTH) + "개");
    System.out.println("4개 일치 (50000원)-" + rankIntegerMap.get(Rank.FOURTH) + "개");
    System.out.println("5개 일치 (1500000원)-" + rankIntegerMap.get(Rank.THIRD) + "개");
    System.out.println("5개 일치, 보너스 볼 일치 (30000000원)-" + rankIntegerMap.get(Rank.SECOND) + "개");
    System.out.println("6개 일치 (2000000000원)-" + rankIntegerMap.get(Rank.FIRST) + "개");
  }

  public Map<Rank, Integer> countRank(ArrayList<Rank> listOfRank) {
    Map<Rank, Integer> rankMap = setMap();
    for (Rank rank : listOfRank) {
      rankMap.replace(rank, rankMap.get(rank) + 1);
    }
    return rankMap;
  }

  public Map<Rank, Integer> setMap() {
    Map<Rank, Integer> rankMap = new HashMap<Rank, Integer>();
    rankMap.put(Rank.FIRST, 0);
    rankMap.put(Rank.SECOND, 0);
    rankMap.put(Rank.THIRD, 0);
    rankMap.put(Rank.FOURTH, 0);
    rankMap.put(Rank.FIFTH, 0);
    rankMap.put(Rank.MISS, 0);
    return rankMap;
  }
}
