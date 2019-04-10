package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoMatch {
    private Scanner scanner;
    private Lotto winLotto;
    private WinningLotto winningLotto;
    private int bonusNumber;

    public LottoMatch(){
        scanner = new Scanner(System.in);
    }

    public void startLottoMatch(){
        inputWinNumbers();
        inputBonusNumber();
    }

    private void inputWinNumbers(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String matchNum = scanner.nextLine();
        winLotto = new Lotto(splitNum(matchNum));
    }

    private List<Integer> splitNum(String matchNum){
        String[] splitedNumArray = matchNum.split(",");
        List<Integer> winNumList = new ArrayList<>();
        for (String s : splitedNumArray) {
            winNumList.add(Integer.valueOf(s));
        }
        return winNumList;
    }

    private void inputBonusNumber(){
        System.out.println("보너스 볼을 입력해 주세요.");
        bonusNumber = scanner.nextInt();
        winningLotto = new WinningLotto(winLotto, bonusNumber);
    }

    public Lotto getWinLottoNum(){
        return winLotto;
    }

    public int getBonusNum(){
        return bonusNumber;
    }
}
