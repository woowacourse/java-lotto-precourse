package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGame {
    public void run(){
      int num = getThePriceOfLotto()/1000;
      ArrayList<Lotto> lottoArrayList = new ArrayList<Lotto>();
      for(int i = 0 ; i < num ; i++){
        lottoArrayList.add(initLotto());
      }
    }
    public int getThePriceOfLotto(){
      System.out.println("구입금액을 입력해 주세요.");
      Scanner scan = new Scanner(System.in);
      return scan.nextInt();
    }
    public Lotto initLotto(){
      List<Integer> lottoNumbers = IntStream.range(1,46).boxed().collect(Collectors.toList());
      Collections.shuffle(lottoNumbers);
      return new Lotto(lottoNumbers.subList(0,6));
    }
}
