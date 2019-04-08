package domain;

import domain.interfaces.UserInterface;

import java.util.List;
import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {

    @Override
    public int promptPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    @Override
    public String[] promptWinningLottoNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().split(",");
    }

    @Override
    public int promptBonusNumber(){
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    @Override
    public void notifyInvalidPurchaseAmount() {
        System.out.println("잘못된 입력입니다.");
    }

    @Override
    public void printStatistics(List<Integer> lottos) {

    }
}
