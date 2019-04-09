package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 수동 로또 및 당첨 로또를 생성하는 class
 */
public class Shop extends Config {

    private Lotto[] lottoBundle;
    private int count;

    public Shop(int price) {
        this.count = price / 1000;
        this.lottoBundle = new Lotto[count];
    }

    public Lotto[] sellLotto(int price) {
        System.out.println("로또 번호를 입력하세요. 번호는 , 로 구분됩니다.");
        for (int i = 0; i < count; i++) {
            lottoBundle[i] = createLotto(getLottoNumber());
            System.out.println("입력되었습니다.");
        }
        return lottoBundle;
    }

    public WinningLotto createWinningLotto() {
        new Scanner(System.in);
        System.out.println("당첨 번호를 입력해주세요");
        Lotto lotto = createLotto(getLottoNumber());
        System.out.println("보너스 번호를 입력해주세요.");
        int bonusNumber = new BonusNumber(lotto.getLottoNumber()).getBonusNumber();
        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        return winningLotto;
    }

    private Lotto createLotto(List<Integer> lottoNumber) {
        return new Lotto(lottoNumber);
    }

    private ArrayList<Integer> getLottoNumber() {
        int[] numberArray = new LottoPaper().getLottoNumber();
        ArrayList<Integer> lottoNumber = (ArrayList<Integer>) Arrays.stream(numberArray).boxed().collect(Collectors.toList());
        return lottoNumber;
    }
}
