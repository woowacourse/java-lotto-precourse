package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMain {
    public static void main(String[] args){
        UserLottos userLottos = new UserLottos(Console.getInputLottoMoney());
        List<Integer> winningLottoNumber = Console.getWinningLottoNumber();
        int winningLottoBonus = Console.getWinngLottoBonus();
        Lotto winningLottoBase = new Lotto(winningLottoNumber);
        WinningLotto winningLotto = new WinningLotto(winningLottoBase, winningLottoBonus);

        System.out.println("당첨통계");
        System.out.println("-----");

        userLottos.checkWinningLotto(winningLotto);


    }
}
