package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LottoGame {
    private static final int MAX_LOTTO_SIZE = 6;

    private Lotto[] userLotto;
    private WinningLotto winningLotto;

    public int inputCost(Scanner sc) {
        System.out.println("구입금액을 입력해 주세요.");
        return sc.nextInt();
    }

    public void buyLotto(int cnt) {
        this.userLotto = new Lotto[cnt];
        AutoLotto al = new AutoLotto();
        for (int i = 0; i < cnt; i++) {
            this.userLotto[i] = new Lotto(al.makeAutoNumber());
        }
    }

    public void lastWeekNumber(Scanner sc) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        sc.nextLine();
        String strNumber = sc.nextLine();
        System.out.println("보너스 볼을 입력해 주세요.");
        int bounusNumber = sc.nextInt();
        registerLotto(strNumber, bounusNumber);
    }

    private void registerLotto(String strNum, int bonus){
        List<Integer> list = eraseComma(strNum);
        Lotto winLotto = new Lotto(list);
        winningLotto = new WinningLotto(winLotto, bonus);
    }

    private List<Integer> eraseComma(String str){
        List<String> strList = Arrays.asList(str.split(","));
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<MAX_LOTTO_SIZE; i++){
            int num = Integer.parseInt(strList.get(i));
            list.add(num);
        }
        return list;
    }
}
