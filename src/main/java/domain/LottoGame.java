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
    ArrayList<Lotto> lottoArrayList = new ArrayList<Lotto>();
    for (int i = 0; i < num; i++) {
      lottoArrayList.add(initLotto());
      showLottoNum(lottoArrayList.get(i));
    }
    showCorrectNum(getCorrectNum());
  }

  public int getThePriceOfLotto() {
    System.out.println("구입금액을 입력해 주세요.");
    Scanner scan = new Scanner(System.in);
    return scan.nextInt();
  }

  public Lotto initLotto() {
    List<Integer> lottoNumbers = IntStream.range(1, 46).boxed().collect(Collectors.toList());
    Collections.shuffle(lottoNumbers);
    return new Lotto(lottoNumbers.subList(0, 6));
  }

  public void showLottoNum(Lotto oneLotto) {
    System.out.println(oneLotto.showNumbers());
  }

  public ArrayList<Integer> getCorrectNum() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    Scanner scan = new Scanner(System.in);
    ArrayList<Integer> correctNum = new ArrayList<Integer>();
    for (String stringVal : scan.next().split(",")) {
      correctNum.add(Integer.parseInt(stringVal));
    }
    System.out.println("보너스 볼을 입력해 주세요.");
    Scanner scan2 = new Scanner(System.in);
    correctNum.add(Integer.parseInt(scan2.next()));
    return correctNum;
  }

  public void showCorrectNum(ArrayList<Integer> correctNum) {

  }
}
