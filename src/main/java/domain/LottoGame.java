package domain;

import java.util.Scanner;

/**
 * 로또 게임을 실행할 메인함수
 */

public class LottoGame {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("구입금액을 입력해 주세요.");
    GameControler control = new GameControler(sc.nextInt());
    sc.nextLine();
    control.setLottos();
  }
}
