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

    System.out.println("\n"+control.getN()+"개를 구매했습니다.");
    control.printLottos();

    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    String lastLotto = sc.nextLine();
    System.out.println("보너스 볼을 입력해 주세요.");
    int bonusNum = sc.nextInt();
    control.setWinningLotto(lastLotto, bonusNum);

    System.out.println("\n당첨 통계\n---------");
    control.printResult();
  }
}
