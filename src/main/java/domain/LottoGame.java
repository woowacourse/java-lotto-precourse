package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {

  public void run() {
    int num = getThePriceOfLotto() / 1000;
    System.out.println(num + "개를 구매했습니다.");
    ArrayList<Lotto> lottoArrayList = initLottoArrayList(num);
    getWinLotto();
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
}
